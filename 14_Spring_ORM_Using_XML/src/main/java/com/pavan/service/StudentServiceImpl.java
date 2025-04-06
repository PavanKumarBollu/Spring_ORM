package com.pavan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.dao.IStudentDao;
import com.pavan.dto.StudentDto;



@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentDao dao;

	@Override
	public int insert(StudentDto s) {
		return 0;
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public void delete(StudentDto s) {
		
	}

	@Override
	public void update(StudentDto s) {
		
	}

	@Override
	public StudentDto getStudent(int id) {
		return null;
	}

	@Override
	public List<StudentDto> getAllStudents() {
		return null;
	}

}
