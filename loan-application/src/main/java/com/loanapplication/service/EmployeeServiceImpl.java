package com.loanapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapplication.dao.CreditScoreDao;
import com.loanapplication.dao.EmployeeDao;
import com.loanapplication.dao.LoanAppDao;
import com.loanapplication.dao.LoanDao;
import com.loanapplication.entity.Employee;
import com.loanapplication.entity.LoanApp;
import com.loanapplication.exception.InvalidCredentialsException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	@Autowired
	private LoanAppDao loanAppDao;
	@Autowired
	private LoanDao loanDao;
	@Autowired
	private CreditScoreDao credDao;
	@Override
    public Employee login(String email, String password) throws InvalidCredentialsException {
        Employee emp = empDao.getByEmail(email);
        
        if (emp == null || !(password.equals(emp.getPassword()))) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
        
        return emp;
    }
	@Override
	public List<LoanApp> getAllLoans() {
		return loanAppDao.findAll();
	}
	@Override
	public void updateLoanStatus(String loanId, String status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int viewCreditScore(String customerPan) {
		// TODO Auto-generated method stub
		return 0;
	}
}
