package com.connection;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userslogin database table.
 * 
 */
@Entity
@Table(name="userslogin")

public class Userslogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_Id", unique=true, nullable=false)
	private int user_Id;

	@Column(name="EMAIL_ID", nullable=false, length=255)
	private String emailId;

	@Column(name="FIRST_NAME", nullable=false, length=45)
	private String firstName;

	@Column(name="ISADMIN", nullable=false)
	private byte isadmin;

	@Column(name="LAST_NAME", nullable=false, length=45)
	private String lastName;

	@Column(name="PASSWORD", nullable=false, length=255)
	private String password;

	//bi-directional one-to-one association to Userdetail
	@OneToOne(mappedBy="userslogin", cascade={CascadeType.PERSIST})
	private Userdetail userdetail;

	public Userslogin() {
	}

	public int getUser_Id() {
		return this.user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Userdetail getUserdetail() {
		return this.userdetail;
	}

	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}

}