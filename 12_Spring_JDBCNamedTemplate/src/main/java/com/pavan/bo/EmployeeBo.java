package com.pavan.bo;

public class EmployeeBo {
	private Integer employeeId;
	private String employeeNumber;
	private String emailId;
	private String password;
	private Integer createdBy;
	private String createdOn;
	
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}



	public String getEmployeeNumber() {
		return employeeNumber;
	}



	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Integer getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}



	public String getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}



	@Override
	public String toString() {
		return "EmployeeBo [employeeId=" + employeeId + ", employeeNumber=" + employeeNumber + ", emailId=" + emailId
				+ ", password=" + password + ", createdBy=" + createdBy + ", createdOn=" + createdOn + "]";
	}
	
	
	
}
