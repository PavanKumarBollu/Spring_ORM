package com.pavan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pavan.bo.StudentBo;


@Repository
public class StudentDaoImpl implements IStudentDao {
	
	@Autowired
	private HibernateTemplate hTemplate;

	@Override
	public int insert(StudentBo s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StudentBo s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StudentBo s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentBo getStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentBo> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
