package com.pavan.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pavan.bo.EmployeeBo;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String GET_EMPLOYEE_BY_PASSWORD 	= "SELECT EMPLOYEEID, EMPLOYEENUMBER, EMAILID, PASSWORD, CREATEDBY,CREATEDON FROM EMPLOYEE WHERE PASSWORD IN (:pas1,:pas2,:pas3)";
	private static final String SELECT_EMPL_BY_ENO 			= "SELECT EMAILID FROM EMPLOYEE WHERE EMPLOYEENUMBER=:NO";
	private static final String REGISTER_EMPLOYEE 			= "INSERT INTO EMPLOYEE (employeeId,employeeNumber,emailId,password,createdBy,createdOn) VALUES (:employeeId,:employeeNumber,:emailId,:password,:createdBy,:createdOn)";
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<EmployeeBo> getEmployeessByPassword(String pas1, String pas2, String pas3) {

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("pas1", pas1);
		map.addValue("pas2", pas2);
		map.addValue("pas3", pas3);

		return template.query(GET_EMPLOYEE_BY_PASSWORD, map, rs -> {
			List<EmployeeBo> bos = new ArrayList<EmployeeBo>();
			while(rs.next())
			{
				EmployeeBo bo = new EmployeeBo();
				bo.setEmployeeId(rs.getInt(1));
				bo.setEmployeeNumber(rs.getString(2));
				bo.setEmailId(rs.getString(3));
				bo.setPassword(rs.getString(4));
				bo.setCreatedBy(rs.getInt(5));
				bo.setCreatedOn(rs.getString(6));
				bos.add(bo);
			}
			return bos;
		});

	}

	@Override
	public Integer registerEmployee(EmployeeBo bo) {
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(bo);
		int count = template.update(REGISTER_EMPLOYEE, source);
		return count;
	}

	@Override
	public String getEmployeMailByEmpNumber(String empNumber) {
		Map<String, String> map = Map.of("NO", empNumber);
		return template.queryForObject(SELECT_EMPL_BY_ENO, map, String.class);
		
	}

}
