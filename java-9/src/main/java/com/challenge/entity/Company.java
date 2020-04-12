package com.challenge.entity;


import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "slug")
	private String slug;
	
	@NotNull
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="company")
	private Set<Candidate> candidates;

	public Company() {
	}

	public Company(String name, String slug) {
		this.setName(name);
		this.setSlug(slug);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Calendar created_at) {
		this.created_at = created_at;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}


}