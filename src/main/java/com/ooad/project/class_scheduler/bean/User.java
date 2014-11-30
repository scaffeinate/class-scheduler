package com.ooad.project.class_scheduler.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="USER", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL"),
		@UniqueConstraint(columnNames = "USERNAME") })

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name, email, password, username,
		track, school;
	private boolean confirmed;
	
	@Id
	@Column(name="ID", unique=true, nullable=false)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="NAME", unique=false, nullable=false, length=50)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="EMAIL", unique=true, nullable=false, length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="PASSWORD", unique=false, nullable=false, length=100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="USERNAME", unique=true, nullable=false, length=25)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="TRACK", unique=false, nullable=false, length=50)
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	
	@Column(name="SCHOOL", unique=false, nullable=false, length=50)
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	@Column(name="CONFIRMED", unique=false, nullable=false)
	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
}
