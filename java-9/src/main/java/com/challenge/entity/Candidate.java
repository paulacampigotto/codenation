package com.challenge.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name = "candidate")

public class Candidate implements Serializable{

	
	
	@Id	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Id	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "acceleration_id")
	private Acceleration acceleration;
	
	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@NotNull
	@Column(name = "status")
	private Integer status;
	
	@NotNull
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;

	public Candidate() {
	}

	public Candidate(User user, Acceleration acceleration, 
			Company company, Integer status) {
		this.setUser(user);
		this.setAcceleration(acceleration);
		this.setCompany(company);
		this.setStatus(status);
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Calendar getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Calendar created_at) {
		this.created_at = created_at;
	}

	public Acceleration getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Acceleration acceleration) {
		this.acceleration = acceleration;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

	
}

	