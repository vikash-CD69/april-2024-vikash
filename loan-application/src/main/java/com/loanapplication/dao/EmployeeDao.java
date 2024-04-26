package com.loanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loanapplication.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	@Query("SELECT c FROM Employee c WHERE c.email = :email")
	Employee getByEmail(String email);

}
