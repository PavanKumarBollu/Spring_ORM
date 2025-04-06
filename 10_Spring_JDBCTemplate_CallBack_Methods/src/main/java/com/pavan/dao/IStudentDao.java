package com.pavan.dao;

import java.util.List;

import com.pavan.bo.StudentBo;

public interface IStudentDao {
	public StudentBo getStudentByNo(int sNo);
	public List<StudentBo> getStudentsByNames(String name1, String name2);
}
