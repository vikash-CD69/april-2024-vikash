package com.loanapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CreditScore {
	
	@Id
	private String pan;
	private int score;
	
	public CreditScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditScore(String pan, int score) {
		super();
		this.pan = pan;
		this.score = score;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	

}
