package com.pavan.service;

import java.util.List;

import com.pavan.dto.StudentDto;

public interface IStudentMngtService {
	public StudentDto getStudentByNo(int sNo);
	public List<StudentDto> getStudentsByNames(String name1, String name2);
}
