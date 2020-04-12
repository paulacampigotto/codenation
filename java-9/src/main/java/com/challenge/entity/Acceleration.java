package com.challenge.entity;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "acceleration")
public class Acceleration {

	@Id
	@GeneratedValue 
	private Integer id;
	
	@Column(name = "name")
	@NotNull
	@Size(min = 1, max = 100)
	private String name;
	
	@Column(name = "slug")
	@NotNull
	@Size(min = 1, max = 50)
	private String slug;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "challenge_id",referencedColumnName="id",nullable=false,unique=true)
	private Challenge challenge;
	
	@Column(name = "created_at")
	@NotNull
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created_at;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="acceleration")
	private Set<Candidate> candidates;

	public Acceleration() {
	}

	public Acceleration(String name, String slug, Challenge challenge) {
		this.setName(name);
		this.setSlug(slug);
		this.setChallenge(challenge);
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

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}
	

}