package com.pavan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pavan.bo.StudentBo;

@Repository
public class StudentDaoImpl implements IStudentDao {

	private static final String GET_STUDENT_BY_NO = "SELECT SID, SNAME, SAGE, SADDRESS FROM STUDENT WHERE SID =?";
	private static final String GET_STUDENTS_BY_NAMES = "SELECT SID, SNAME, SAGE, SADDRESS FROM STUDENT WHERE SNAME IN (?,?)";
	private static final String GET_STUDENTS_BY_ADDRESS = "SELECT SID, SNAME, SAGE, SADDRESS FROM STUDENT WHERE SADDRESS IN (?,?)";
	@Autowired
	private JdbcTemplate template;

	@Override
	public StudentBo getStudentByNo(int sNo) {
		return template.queryForObject(GET_STUDENT_BY_NO, new StudentMapper(), sNo);
	}

	class StudentMapper implements RowMapper<StudentBo> {

		@Override
		public StudentBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentBo bo = new StudentBo();
			bo.setsId(rs.getInt("sid"));
			bo.setsName(rs.getString("sName"));
			bo.setsAge(rs.getInt("sAge"));
			bo.setsAddress(rs.getString("sAddress"));
			return bo;
		}

	}

	@Override
	public List<StudentBo> getStudentsByNames(String name1, String name2) {
		List<StudentBo> BO = template.query(GET_STUDENTS_BY_NAMES, (rs, num) -> {
			StudentBo bo = null;
			bo = new StudentBo();
			bo.setsId(rs.getInt("sid"));
			bo.setsName(rs.getString("sName"));
			bo.setsAge(rs.getInt("sAge"));
			bo.setsAddress(rs.getString("sAddress"));
			return bo;
		}, name1, name2);

		return BO;
	}

	@Override
	public List<StudentBo> getStudentsByAddress(String addr1, String addr2) {
//		return template.query(GET_STUDENTS_BY_ADDRESS, new ResultSetExtractor<List<StudentBo>>() {
//
//			@Override
//			public List<StudentBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				List<StudentBo> bo = new ArrayList<StudentBo>();
//				StudentBo stdbo = null;
//				while (rs.next()) {
//					stdbo = new StudentBo();
//
//					stdbo.setsId(rs.getInt("sid"));
//					stdbo.setsName(rs.getString("sName"));
//					stdbo.setsAge(rs.getInt("sAge"));
//					stdbo.setsAddress(rs.getString("sAddress"));
//					bo.add(stdbo);
//				}
//				return bo;
//			}
//		}, addr1, addr2);
		
		
//		Second Way of doing the same task
		
//		return template.query(GET_STUDENTS_BY_ADDRESS, new RowMapperResultSetExtractor<StudentBo>(new BeanPropertyRowMapper<StudentBo>(StudentBo.class)),addr1,addr2);

		// 3rd Way of doing the same task
		
		List<StudentBo> stdbos = new ArrayList<StudentBo>();
		
		template.query(GET_STUDENTS_BY_ADDRESS,new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {

				StudentBo stdbo = new StudentBo();
			
				stdbo.setsId(rs.getInt("sid"));
				stdbo.setsName(rs.getString("sName"));
				stdbo.setsAge(rs.getInt("sAge"));
				stdbo.setsAddress(rs.getString("sAddress"));
				stdbos.add(stdbo);
			}
			
		} ,addr1, addr2);
		
		return stdbos;
	}

}
