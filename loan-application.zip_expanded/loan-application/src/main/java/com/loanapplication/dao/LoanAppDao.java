package com.loanapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loanapplication.entity.LoanApp;


public interface LoanAppDao extends JpaRepository<LoanApp, Integer>{

	@Query("SELECT la FROM LoanApp la WHERE la.custId =?1")
	List<LoanApp> getByCustId(int custId);

	@Query("SELECT la FROM LoanApp la WHERE la.loanId =?1")
	List<LoanApp> getByLoanId(int loanId);

}
