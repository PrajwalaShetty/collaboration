package com.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proj2_friend")
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column(name="from_id")
private String fromId;
@Column(name="to_id")
private String toId;
private char status;//  'A'  , 'D',  'P'
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFromId() {
	return fromId;
}
public void setFromId(String fromId) {
	this.fromId = fromId;
}
public String getToId() {
	return toId;
}
public void setToId(String toId) {
	this.toId = toId;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}

}
