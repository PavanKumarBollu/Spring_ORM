package com.pavan.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDao {
	public int getEmpsCount();
	public String getEmployeeNameByNo(int eno);
	public Map<String,Object> getEmployeeDetailsByNo(int eno);
	public List<Map<String,Object>> getEmployeeDeatilsByAddress(String addr1,String addr2);
	public int insertEmp(String ename,String eaddress,int esalary);
	public int addBonusToEmpByAddress(String addr,int bonus);
}
