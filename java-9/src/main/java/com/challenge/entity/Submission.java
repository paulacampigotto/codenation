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
@Table(name = "submission")
public class Submission implements Serializable{
	
	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name = "chalenge_id")
	private Challenge challenge; 
	
	
	@NotNull
	@Column(name = "score")
	private float score;
	
	@NotNull
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;

	public Submission() {
	}

	public Submission(User user, Challenge challenge, float score) {
		this.setUser(user);
		this.setChallenge(challenge);
		this.setScore(score);
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Calendar getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Calendar created_at) {
		this.created_at = created_at;
	}
	
	
}



	