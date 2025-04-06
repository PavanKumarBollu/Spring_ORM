package com.pavan.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.dao.IEmployeeDao;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMangementService {

	@Autowired
	private IEmployeeDao dao;

	public EmployeeMgmtServiceImpl(IEmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public int fetchEmpsCount() {
		return dao.getEmpsCount();
	}

	@Override
	public String getEmployeeNameByNo(int eno) {
		return dao.getEmployeeNameByNo(eno);
	}

	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		return dao.getEmployeeDetailsByNo(eno);
	}

	@Override
	public List<Map<String, Object>> getEmployeeDeatilsByAddress(String addr1, String addr2) {
		return dao.getEmployeeDeatilsByAddress(addr1, addr2);
	}

	@Override
	public int insertEmp(String ename, String eaddress, int salary) {
		return dao.insertEmp(ename, eaddress, salary);
	}

	@Override
	public int addBonusToEmpByAddress(String addr, int bonus) {
		return dao.addBonusToEmpByAddress(addr, bonus);
	}

}
