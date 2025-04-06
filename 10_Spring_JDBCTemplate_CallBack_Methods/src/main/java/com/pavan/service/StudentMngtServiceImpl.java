package com.pavan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.bo.StudentBo;
import com.pavan.dao.IStudentDao;
import com.pavan.dto.StudentDto;

@Service
public class StudentMngtServiceImpl implements IStudentMngtService{

	@Autowired
	private IStudentDao dao;
	
	
	
	@Override
	public StudentDto getStudentByNo(int sNo) {
		
		StudentBo bo = dao.getStudentByNo(sNo);
		StudentDto dto = new StudentDto();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<StudentDto> getStudentsByNames(String name1, String name2) {
		List<StudentDto> dtos = new ArrayList<StudentDto>();
		List<StudentBo> bos = dao.getStudentsByNames(name1, name2);
		bos.forEach(bo->{
			StudentDto dto = new StudentDto();
			BeanUtils.copyProperties(bo, dto);
			dtos.add(dto);
		});
		
		return dtos;
		
	}

	
}
