package com.connection;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userslogin database table.
 * 
 */
@Entity
@Table(name="userslogin")
@NamedQuery(name="Userslogin.findAll", query="SELECT u FROM Userslogin u")
public class Userslogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_Id", unique=true, nullable=false)
	private int user_Id;

	@Column(name="DEPARTMENT", length=45)
	private String department;

	@Column(name="EMAIL_ID", nullable=false, length=255)
	private String emailId;

	@Column(name="FIRST_NAME", nullable=false, length=45)
	private String firstName;

	@Column(name="IS_RM")
	private byte isRm;

	@Column(name="ISADMIN", nullable=false)
	private byte isadmin;

	@Column(name="LAST_NAME", nullable=false, length=45)
	private String lastName;

	@Column(name="LOCATION", length=45)
	private String location;

	@Column(name="PASSWORD", nullable=false, length=255)
	private String password;

	@Column(name="RM_ID")
	private int rmId;

	@Column(name="USERDETAIL_USER_ID")
	private int userdetailUserId;

	public Userslogin() {
	}

	public int getUser_Id() {
		return this.user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public byte getIsRm() {
		return this.isRm;
	}

	public void setIsRm(byte isRm) {
		this.isRm = isRm;
	}

	public byte getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(byte isadmin) {
		this.isadmin = isadmin;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRmId() {
		return this.rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public int getUserdetailUserId() {
		return this.userdetailUserId;
	}

	public void setUserdetailUserId(int userdetailUserId) {
		this.userdetailUserId = userdetailUserId;
	}

}