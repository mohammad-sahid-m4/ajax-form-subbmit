package com.metafour.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="studentinformation2")
public class Student {
private static final long serialVersionUID=-3009157732242241606L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;

@Column(name="firstname")
private String firstname;

@Column(name="lastname")
private String lastname;

@Column(name="gender")
private String gender;

@Column(name="hobby")
private String hobby;

@Column(name="country")
private String country;

@Column(name="roll")
private long roll;

@DateTimeFormat(pattern="dd/MM/yyyy")
@Temporal(TemporalType.DATE)
@Column(name="date")
private Date date;

public Student() {
	super();
}

public Student(long id, String firstname, String lastname, String gender, String hobby, String country, long roll,
		Date date) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.gender = gender;
	this.hobby = hobby;
	this.country = country;
	this.roll = roll;
	this.date = date;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getHobby() {
	return hobby;
}

public void setHobby(String hobby) {
	this.hobby = hobby;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public long getRoll() {
	return roll;
}

public void setRoll(long roll) {
	this.roll = roll;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}
}
