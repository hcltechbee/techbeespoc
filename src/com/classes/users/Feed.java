package com.classes.users;

import com.mysql.jdbc.Blob;

public class Feed {
	 private String Feed_Text;
	 private Blob Photo;
	 private int Feed_Id;
	public int getFeed_Id() {
		return Feed_Id;
	}
	public void setFeed_Id(int feed_Id) {
		Feed_Id = feed_Id;
	}
	public String getFeed_Text() {
		return Feed_Text;
	}
	public void setFeed_Text(String feed_Text) {
		Feed_Text = feed_Text;
	}
	public Blob getPhoto() {
		return Photo;
	}
	public void setPhoto(Blob photo) {
		Photo = photo;
	}
	
}
