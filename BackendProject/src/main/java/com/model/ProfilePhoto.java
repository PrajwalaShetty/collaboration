package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
//import javax.persistence.Table;

@Entity
//@Table(name = "proj2_profile_pics")
public class ProfilePhoto {
	
	@Id
	@GeneratedValue
	@Column(name = "PHOTO_ID")
	private int id;
	
	@Column(name = "PHOTO_NAME")
	private String photoName;
	
	@Lob   //to store some image files, Large Object
	@Column(name = "PHOTO_DATA")
	private byte[] data;
	
	
    private String username;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPhotoName() {
		return photoName;
	}


	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}


	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

}
