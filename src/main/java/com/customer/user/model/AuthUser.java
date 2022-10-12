package com.customer.user.model;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.customer.user.config.AesEncryptor;




@Entity
public class AuthUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String firstName;
	private String lastName;
	private String customerAddress;
	private String state;
	private String country;
	private String pan;
	private int contactNo;
	private String email;
	private Date dateOfBirth;
	private String contactPreference;
	
	 @Convert(converter = AesEncryptor.class)
	private String passWord;

	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	public String getContactPreference() {
		return contactPreference;
	}
	public void setContactPreference(String contactPreference) {
		this.contactPreference = contactPreference;
	}
	public AuthUser() {
		super();
	}

	public AuthUser(int userId, String firstName, String lastName, String customerAddress, String state, String country,
			String pan, int contactNo, String email, Date dateOfBirth, String contactPreference, String passWord) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerAddress = customerAddress;
		this.state = state;
		this.country = country;
		this.pan = pan;
		this.contactNo = contactNo;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.contactPreference = contactPreference;
		this.passWord = passWord;
	}
	
	@Override
	public String toString() {
		return "AuthUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", customerAddress=" + customerAddress + ", state=" + state + ", country=" + country + ", pan=" + pan
				+ ", contactNo=" + contactNo + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", contactPreference=" + contactPreference + ", passWord=" + passWord + "]";
	}
	public AuthUser(int userId, String firstName, String lastName, String customerAddress, String state, String country,
			String pan, int contactNo, Date dateOfBirth, String contactPreference) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerAddress = customerAddress;
		this.state = state;
		this.country = country;
		this.pan = pan;
		this.contactNo = contactNo;
		this.dateOfBirth = dateOfBirth;
		this.contactPreference = contactPreference;
	}
	
	
	
	
	
	
	
	
	
	
}