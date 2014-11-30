package com.ooad.project.class_scheduler.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")

public class Course implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private int id, intake_count, availability, class_credits;
	private String coursecode, coursename, professor, starttime,
		endtime, day1, day2, class_level;
	
	@Id
	@Column(name="ID", unique=true, nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="INTAKE_COUNT", unique=false, nullable=false)
	public int getIntake_count() {
		return intake_count;
	}
	public void setIntake_count(int intake_count) {
		this.intake_count = intake_count;
	}
	
	@Column(name="AVAILABILITY", unique=false, nullable=false)
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	@Column(name="CLASS_CREDITS", unique=false, nullable=false)
	public int getClass_credits() {
		return class_credits;
	}
	public void setClass_credits(int class_credits) {
		this.class_credits = class_credits;
	}
	
	@Column(name="COURSECODE", unique=false, nullable=false, length=20)
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	
	@Column(name="COURSENAME", unique=false, nullable=false, length=100)
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	@Column(name="PROFESSOR", unique=false, nullable=false, length=50)
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	@Column(name="STARTTIME", unique=false, nullable=false, length=10)
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	@Column(name="ENDTIME", unique=false, nullable=false, length=10)
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	
	@Column(name="DAY1", unique=false, nullable=false, length=10)
	public String getDay1() {
		return day1;
	}
	public void setDay1(String day1) {
		this.day1 = day1;
	}
	
	@Column(name="DAY2", unique=false, nullable=false, length=10)
	public String getDay2() {
		return day2;
	}
	public void setDay2(String day2) {
		this.day2 = day2;
	}
	@Column(name="CLASS_LEVEL", unique=false, nullable=false, length=50)
	public String getClass_level() {
		return class_level;
	}
	public void setClass_level(String class_level) {
		this.class_level = class_level;
	}
	
}
