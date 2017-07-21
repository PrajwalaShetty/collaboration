package com.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="blog_comment")
public class BlogComment implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private Date createdOn;
@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name = "create_by_id")
private PROJ2_USER createdBy;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="blog_post_id")
private BlogPost blogPost;
private String body;
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
public void setCreatedBy(PROJ2_USER user) {
	this.createdBy = user;
}
public BlogPost getBlogPost() {
	return blogPost;
}
public void setBlogPost(BlogPost blogPost) {
	this.blogPost = blogPost;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}

}