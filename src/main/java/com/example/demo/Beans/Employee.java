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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String department;
	private String designation;
	private String contact;
	private String email;
	private String country;
	private String state;
	private String city;
	private String address;
	private String password;
	
	@Basic(optional = false)
	@Column(name = "created_at", insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	/*@Temporal(TemporalType.DATE)*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joiningdate; 
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	private int status;
	
	@OneToMany(mappedBy = "employee")
	private List<Project> project;
	
	

	public Employee() {
		super();
	}

	public Employee(String name, String department, String designation, String contact, String email, String country,
			String state, String city, String address, String password, Date joiningdate) {
		super();
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.contact = contact;
		this.email = email;
		this.country = country;
		this.state = state;
		this.city = city;
		this.address = address;
		this.password = password;
		this.joiningdate = joiningdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", designation=" + designation
				+ ", contact=" + contact + ", email=" + email + ", country=" + country + ", state=" + state + ", city="
				+ city + ", address=" + address + ", password=" + password + ", date=" + date + ", joiningDate="
				+ joiningdate + ", company=" + company + ", status=" + status + ", project=" + project + "]";
	}
	
	
	
	
}
