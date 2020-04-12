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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "full_name")
	private String full_name;
	
	@NotNull
	@Email
	@Size(min = 1, max = 100)
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "nickname")
	private String nickname;
	
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "password")
	private String password;
	
	@NotNull
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="user")
	private Set<Candidate> candidates;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="user")
	private Set<Submission> submissions;

	public User() {
	}

	public User(String full_name, String email, String nickname, String password) {
		this.setFull_name(full_name);
		this.setEmail(email);
		this.setNickname(nickname);
		this.setPassword(password);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Calendar created_at) {
		this.created_at = created_at;
	}

}