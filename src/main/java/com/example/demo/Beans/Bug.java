package com.example.demo.Beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bug")
public class Bug {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int bugId;
	private int reporter;
	private int assignTo;
	private String priority;
	private String category;
	private String platform;
	private String summary;
	private int status;
	
	@OneToMany(mappedBy = "bug")
	private List<Images> image;
	
	@OneToMany(mappedBy = "bug")
	private List<Note> note;
	
	@Basic(optional = false)
	@Column(name = "created_at", insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
}
