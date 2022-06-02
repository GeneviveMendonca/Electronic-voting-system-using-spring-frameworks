package com.electronicvotingsystem.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int userId;

	@NotNull
	private String name;

	@NotNull
	private String address;

	@NotNull
	private String gender;

	@NotNull
	private String mobileNo;

	@NotNull
	private LocalDateTime dateOfBirth;

	@NotNull
	private String district;

	@NotNull(message = "username should not be empty ")
	private String userName;

	@NotNull(message = "password should not be empty ")

	private String password;

	public User() {
		super();
	}

	public User(int userId, @NotNull String name, @NotNull String address, @NotNull String gender,
			@NotNull String mobileNo, @NotNull LocalDateTime dateOfBirth, @NotNull String district,
			@NotNull String userName, @NotNull String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.district = district;
		this.userName = userName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", address=" + address + ", gender=" + gender
				+ ", mobileNo=" + mobileNo + ", dateOfBirth=" + dateOfBirth + ", district=" + district + ", userName="
				+ userName + ", password=" + password + "]";
	}
}
