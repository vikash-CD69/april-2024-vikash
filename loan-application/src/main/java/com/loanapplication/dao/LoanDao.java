package com.loanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanapplication.entity.Loan;

public interface LoanDao extends JpaRepository<Loan, Integer> {

}
