package com.loanapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loanapplication.entity.Customer;
import com.loanapplication.entity.Loan;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	@Query("SELECT c FROM Customer c WHERE c.email = :email")
	Customer getByEmail(String email);

	@Query("SELECT l FROM Loan l")
	List<Loan> getLoans();

}
