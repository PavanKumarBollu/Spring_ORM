package com.pavan.service;

import java.util.List;

import com.pavan.dto.EmployeeDto;

public interface IEmployeeService {
	public List<EmployeeDto> getEmployeessByPassword(String pas1, String pas2, String pas3);
	public Integer registerEmployee(EmployeeDto bo);
	public String getEmployeMailByEmpNumber(String empNumber);
}
