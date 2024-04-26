package com.loanapplication.service;

import java.util.List;

import com.loanapplication.entity.Employee;
import com.loanapplication.entity.LoanApp;
import com.loanapplication.exception.InvalidCredentialsException;

public interface EmployeeService {

	Employee login(String email, String password) throws InvalidCredentialsException;

	List<LoanApp> getAllLoans();

	void updateLoanStatus(String loanId, String status);

	int viewCreditScore(String customerPan);

}
