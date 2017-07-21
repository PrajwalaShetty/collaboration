package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="blog_post")
public class BlogPost implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private Date createdOn;

@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name = "create_by_id")
private PROJ2_USER createdBy;

private String title;
@Lob
@Column(name="body")
private String body;

@OneToMany(mappedBy="blogPost",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
@JsonIgnore
private List<BlogComment> comments=new ArrayList<BlogComment>();


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}
public PROJ2_USER getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(PROJ2_USER createdBy) {
	this.createdBy = createdBy;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
public List<BlogComment> getComments() {
	return comments;
}
public void setComments(List<BlogComment> comments) {
	this.comments = comments;
}
}