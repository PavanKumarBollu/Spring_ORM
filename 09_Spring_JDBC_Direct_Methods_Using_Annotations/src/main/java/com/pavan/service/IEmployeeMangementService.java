package com.pavan.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeMangementService {
	public int fetchEmpsCount();

	public String getEmployeeNameByNo(int eno);

	public Map<String, Object> getEmployeeDetailsByNo(int eno);

	public List<Map<String, Object>> getEmployeeDeatilsByAddress(String addr1, String addr2);

	public int insertEmp(String ename, String eaddress,  int salary);

	public int addBonusToEmpByAddress(String addr, int bonus);
}
