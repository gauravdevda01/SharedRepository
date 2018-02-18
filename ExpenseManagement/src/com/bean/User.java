package com.bean;

public class User 
{
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private Integer mobileNum;
	private String userName;
	private String password;
	private Integer roleId;
	private Character isActive;
	
	public User()
	{}
	
	public User(String firstName, String middleName, String lastName, String email, Integer mobileNum, String userName,
			String password, Integer roleId, Character isActive) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNum = mobileNum;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.isActive = isActive;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Integer mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Character getIsActive() {
		return isActive;
	}
	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}
	
	
}
