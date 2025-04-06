package com.pavan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.bo.EmployeeBo;
import com.pavan.dao.IEmployeeDao;
import com.pavan.dto.EmployeeDto;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao  dao;
	

	@Override
	public List<EmployeeDto> getEmployeessByPassword(String pas1, String pas2, String pas3) {
		List<EmployeeBo> bos = dao.getEmployeessByPassword(pas1, pas2, pas3);
		List<EmployeeDto> dtos = new ArrayList<EmployeeDto>();
		bos.forEach(bo->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(bo, dto);
			dtos.add(dto);
		});
		return dtos;
	}

	@Override
	public Integer registerEmployee(EmployeeDto dto) {
		EmployeeBo bo = new EmployeeBo();
		BeanUtils.copyProperties(dto, bo);
		return dao.registerEmployee(bo);
	}

	@Override
	public String getEmployeMailByEmpNumber(String empNumber) {
		return dao.getEmployeMailByEmpNumber(empNumber);
	}

}
