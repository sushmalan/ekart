package com.ssd.ecort.dto;

public class UserDto {
	
	private Integer id;
	private String name;
	private String email;
	private Long mobileNo;
	private String pwd;
	private String address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserDto(Integer id, String name, String email, Long mobileNo, String pwd, String address) {
		super(); 
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.pwd = pwd;
		this.address = address;
	}
	public UserDto(String name, String email, Long mobileNo, String pwd, String address) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.pwd = pwd;
		this.address = address;
	}
	public UserDto() {
		super();
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + ", pwd=" + pwd
				+ ", address=" + address + "]";
	}
	
	
	

}
