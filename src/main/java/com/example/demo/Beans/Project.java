package com.example.demo.Beans;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String projectName;
	private String clientName;
	private String summary;
	
	private Date createdAt; 
	private int contact;
	
	@Column(unique = true) /*making email unique*/
	private String email;
	private int status;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private Employee employee;
	
	@Basic(optional = false)
	@Column(name = "date", insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
}
