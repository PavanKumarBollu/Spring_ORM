package com.pavan.dao;

import java.util.List;

import com.pavan.bo.StudentBo;

public interface IStudentDao {
	public int insert(StudentBo s);

	public void delete(int id);

	public void delete(StudentBo s);

	public void update(StudentBo s);

	public StudentBo getStudent(int id);

	public List<StudentBo> getAllStudents();
}
