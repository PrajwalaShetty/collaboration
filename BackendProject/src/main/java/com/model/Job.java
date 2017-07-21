package com.model;

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
@Table(name="proj2_job")
public class Job {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int jobId;
private String jobTitle;
private String jobDescription;
private Date postedOn;
private String skillsRequired;
private String salary;
private String location;
private String email;

@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name = "create_by_id")
private PROJ2_USER createdBy;


public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getJobTitle() {
	return jobTitle;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}
public String getJobDescription() {
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}
public Date getPostedOn() {
	return postedOn;
}
public void setPostedOn(Date postedOn) {
	this.postedOn = postedOn;
}
public String getSkillsRequired() {
	return skillsRequired;
}
public void setSkillsRequired(String skillsRequired) {
	this.skillsRequired = skillsRequired;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public PROJ2_USER getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(PROJ2_USER createdBy) {
	this.createdBy = createdBy;
}
}
