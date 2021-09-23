package com.example.demo.Beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int contact;
	private String email;
	private String password;
	private String address;
	private String country;
	private String authPerson;
	private String authMob;
	private String authEmail;
	private String authState;
	/*
	@Basic(optional = false)
	@CreationTimestamp
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)*/
	@Basic(optional = false)
	@Column(name = "created_at", insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt; /*= new Date()*/
	
	private int noOfEmp;
	
	@OneToMany(mappedBy = "company")
	private List<Employee> employee;
	
	private int status;
	
	@OneToMany(mappedBy = "company")
	private List<Project> project;
	
	@OneToMany(mappedBy = "company")
	private List<Images> image;
	
	@OneToMany(mappedBy = "company")
	private List<Note> note;
	
	
}
