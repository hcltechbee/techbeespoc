package com.servlet.users;

import java.io.Serializable;
import javax.persistence.*;


import java.sql.Timestamp;


/**
 * The persistent class for the userfeeds database table.
 * 
 */
@Entity
@Table(name="userfeeds")
@NamedQuery(name="Userfeed.findAll", query=com.constants.QueryConstants.SELECTFEED)
public class Userfeed implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FEED_ID", unique=true, nullable=false)
	private int feedId;

	
	@Column(name="DATE_CREATED" , columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	
	private Timestamp dateCreated;

	@Lob
	@Column(name="FEED_TEXT", nullable=false)
	private String feedText;

	
	@Column(name="LAST_UPDATED", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	
	private Timestamp lastUpdated;

	@Lob
	@Column(name="PHOTO", nullable=false)
	private byte[] photo;

	@Column(name="USER_ID", nullable=false)
	private int userId;

	public Userfeed() {
	}

	public int getFeedId() {
		return this.feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getFeedText() {
		return this.feedText;
	}

	public void setFeedText(String feedText) {
		this.feedText = feedText;
	}

	public Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}