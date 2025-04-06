package com.pavan.dto;

import java.io.Serializable;

public class StudentDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer sId;
	private String sName;
	private Integer sAge;
	private String sAddress;
	
	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Integer getsAge() {
		return sAge;
	}

	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	@Override
	public String toString() {
		return "StudentDto [sId=" + sId + ", sName=" + sName + ", sAge=" + sAge + ", sAddress=" + sAddress + "]";
	}
	
}

