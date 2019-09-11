package com.donors.dao;

public class Donor {
	
	private String loginId = null;
	
	private String bloodGroup = null;
	
	private Long mobileNo = null;
	
	private String password = null;
	
	private Address address = null;

	public Donor() {
		super();
	}

	public Donor(String loginId, String bloodGroup, Long mobileNo, String password, Address address) {
		super();
		this.loginId = loginId;
		this.bloodGroup = bloodGroup;
		this.mobileNo = mobileNo;
		this.password = password;
		this.address = address;
	}
	
	public Donor(String loginId, String bloodGroup, Long mobileNo,  Address address) {
		super();
		this.loginId = loginId;
		this.bloodGroup = bloodGroup;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Donor [loginId=" + loginId + ", bloodGroup=" + bloodGroup + ", mobileNo=" + mobileNo + ", password="
				+ password + ", address=" + address + "]";
	}
	
	
	
	

}
