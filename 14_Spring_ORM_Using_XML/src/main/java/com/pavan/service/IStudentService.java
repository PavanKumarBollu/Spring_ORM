package com.pavan.service;

import java.util.List;

import com.pavan.dto.StudentDto;

public interface IStudentService {
	
	public int insert(StudentDto s);

	public void delete(int id);

	public void delete(StudentDto s);

	public void update(StudentDto s);

	public StudentDto getStudent(int id);

	public List<StudentDto> getAllStudents();

}
