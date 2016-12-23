package com.tutorial.sample.info;
/**
 * 
 * @author Ravi.Katiyar : Added author name 
 *
 */
public class UserInfoInterface {
	String name;
	String dob;
	String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("Test to reconfirm");
	}

}
