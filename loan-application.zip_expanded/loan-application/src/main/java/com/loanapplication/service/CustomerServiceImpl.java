package com.loanapplication.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loanapplication.dao.CustomerDao;
import com.loanapplication.dao.LoanAppDao;
import com.loanapplication.dao.LoanDao;
import com.loanapplication.entity.Customer;
import com.loanapplication.entity.Loan;
import com.loanapplication.entity.LoanApp;
import com.loanapplication.exception.InvalidCredentialsException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao custDao;
	@Autowired
	private LoanAppDao loanAppDao;
	@Autowired
	private LoanDao loanDao;
	@Override
	public Customer register(Customer customer) {
		Customer customer1 = custDao.save(customer);
		return customer1;
	}
	@Override
    public Customer login(String email, String password) throws InvalidCredentialsException {
        Customer customer = custDao.getByEmail(email);
        
        if (customer == null || !(password.equals(customer.getPassword()))) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
        
        return customer;
    }
	@Override
	public List<Loan> getAllLoans() {
		return loanDao.findAll();
	}
	@Override
	public LoanApp applyLoan(int custId, int loanId) {
		LoanApp loan = new LoanApp();
		loan.setCustomerId(custId);
		loan.setLoanId(loanId);
		loan.setStatus("pending");
		return loanAppDao.save(loan);
	}
	@Override
	public List<LoanApp> getLoanStatus(int loanId, int custId) {
		List<LoanApp> list1 = loanAppDao.getByCustId(custId);
		List<LoanApp> list2 = loanAppDao.getByLoanId(loanId);
		List<LoanApp> matchingElements = new ArrayList<>();
        for (LoanApp element : list1) {
            if (list2.contains(element)) {
                matchingElements.add(element);
            }
        }
        return matchingElements;
	
	}
	
	
}
