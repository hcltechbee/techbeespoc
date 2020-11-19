package com.connection;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the userdetails database table.
 * 
 */
@Entity
@Table(name="userdetails")

public class Userdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID", unique=true, nullable=false)
	private int userId;

	@Column(name="ADDRESS", nullable=false, length=255)
	private String address;

	@Column(name="CITY", nullable=false, length=45)
	private String city;

	@Column(name="COUNTRY", nullable=false, length=45)
	private String country;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH", nullable=false)
	private Date dateOfBirth;

	@Column(name="FIRST_NAME", nullable=false, length=45)
	private String firstName;

	@Column(name="GENDER", nullable=false, length=1)
	private String gender;

	@Column(name="LAST_NAME", nullable=false, length=45)
	private String lastName;

	@Column(name="MOBILE_NUMBER", nullable=false)
	private BigInteger mobileNumber;

	@Column(name="PINCODE", nullable=false, length=45)
	private String pincode;

	@Column(name="STATE", nullable=false, length=45)
	private String state;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	//bi-directional one-to-one association to Userslogin
	@OneToOne
	@JoinColumn(name="USER_ID", nullable=false, insertable=false, updatable=false)
	private Userslogin userslogin;

	public Userdetail() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigInteger getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Userslogin getUserslogin() {
		return this.userslogin;
	}

	public void setUserslogin(Userslogin userslogin) {
		this.userslogin = userslogin;
	}

}