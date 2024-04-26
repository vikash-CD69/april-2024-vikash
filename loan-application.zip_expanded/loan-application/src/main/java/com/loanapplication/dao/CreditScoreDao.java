package com.loanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanapplication.entity.CreditScore;

public interface CreditScoreDao extends JpaRepository<CreditScore, String>{

}
