package com.pavan.dao;

import java.util.List;

import com.pavan.bo.EmployeeBo;

public interface IEmployeeDao {
	public List<EmployeeBo> getEmployeessByPassword(String pas1, String pas2, String pas3);
	public Integer registerEmployee(EmployeeBo bo);
	public String getEmployeMailByEmpNumber(String empNumber);
	
}
