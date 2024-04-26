package com.loanapplication.service;

import java.util.List;

import com.loanapplication.entity.Customer;
import com.loanapplication.entity.Loan;
import com.loanapplication.entity.LoanApp;
import com.loanapplication.exception.InvalidCredentialsException;

public interface CustomerService {

	Customer register(Customer customer);

	Customer login(String email, String password) throws InvalidCredentialsException;

	List<Loan> getAllLoans();

	LoanApp applyLoan(int custId, int loanId);

	List<LoanApp> getLoanStatus(int loanId, int custId);
	

}
