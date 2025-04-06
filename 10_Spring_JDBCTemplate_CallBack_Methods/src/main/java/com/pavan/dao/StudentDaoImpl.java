package com.pavan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pavan.bo.StudentBo;

@Repository
public class StudentDaoImpl implements IStudentDao {

	private static final String GET_STUDENT_BY_NO 		= "SELECT SID, SNAME, SAGE, SADDRESS FROM STUDENT WHERE SID =?";
	private static final String GET_STUDENTS_BY_NAMES 	= "SELECT SID, SNAME, SAGE, SADDRESS FROM STUDENT WHERE SNAME IN (?,?)";
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
		List<StudentBo> BO = template.query(GET_STUDENTS_BY_NAMES,new StudentsRowMapper(),name1, name2);
		
		return BO;
	}

	private static class StudentsRowMapper implements RowMapper<StudentBo> {

		@Override
		public StudentBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentBo bo = null;
			bo = new StudentBo();
			bo.setsId(rs.getInt("sid"));
			bo.setsName(rs.getString("sName"));
			bo.setsAge(rs.getInt("sAge"));
			bo.setsAddress(rs.getString("sAddress"));
			return bo;
		}

	}

}
