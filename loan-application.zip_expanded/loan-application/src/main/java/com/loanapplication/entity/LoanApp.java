package com.loanapplication.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class LoanApp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int customerId;
	private int loanId;
	private String status;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "loanId")
	private List<LoanApp> loans;
	public LoanApp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoanApp(int id, int customerId, int loanId, String status, List<LoanApp> loans) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.loanId = loanId;
		this.status = status;
		this.loans = loans;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<LoanApp> getLoans() {
		return loans;
	}
	public void setLoans(List<LoanApp> loans) {
		this.loans = loans;
	}
	
	

}
