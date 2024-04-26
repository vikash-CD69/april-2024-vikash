package com.loanapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.loanapplication.entity.Customer;
import com.loanapplication.entity.Employee;
import com.loanapplication.entity.LoanApp;
import com.loanapplication.service.CustomerService;
import com.loanapplication.service.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/home")
public class Controller {

	@Autowired
	private CustomerService custServ;
	@Autowired
	private EmployeeService empServ;

	// for Customer Registration
	@PostMapping("/register")
	public ResponseEntity<Object> registerCustomer(@RequestBody Customer customer) {
		try {
			Customer registeredCustomer = custServ.register(customer);
			return ResponseEntity.status(201).body(registeredCustomer);
		} catch (Exception ex) {
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}

	@PostMapping("/customer/login")
	public ResponseEntity<Object> loginCustomer(@RequestParam String email, @RequestParam String password) {
		try {
			Customer loggedInCustomer = custServ.login(email, password);
			return ResponseEntity.status(200).body(loggedInCustomer);
		} catch (Exception ex) {
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}

	@PostMapping("/employee/login")
	public ResponseEntity<Object> loginEmployee(@RequestParam String email, @RequestParam String password) {
		try {
			Employee loggedInEmployee = empServ.login(email, password);
			return ResponseEntity.status(200).body(loggedInEmployee);
		} catch (Exception ex) {
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
	
	@GetMapping("/viewloan")
	public ResponseEntity<Object> viewLoan(){
		return ResponseEntity.status(201).body(custServ.getAllLoans());
	}
	
	@PostMapping("/applyloan/{custId}/{loanId}")
	public ResponseEntity<Object> applyLoan(@PathVariable int custId, @PathVariable int loanId){
		return ResponseEntity.status(200).body(custServ.applyLoan(custId,loanId));
	} 
	
	@GetMapping("/{custId}/{loanId}/status")
    public ResponseEntity<Object> viewLoanStatus(@PathVariable int loanId, @PathVariable int custId) {
        try {
        	List<LoanApp> loanStatus = custServ.getLoanStatus(loanId,custId);
            return ResponseEntity.ok(loanStatus);
        } catch (Exception ex) {
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return ResponseEntity.status(404).body(map);
		}
    }
	
	@GetMapping("/loanapplications")
	public ResponseEntity<Object> viewLoanApplications(){
		return ResponseEntity.status(201).body(empServ.getAllLoans());
	}
	
	@PutMapping("/{loanId}/status")
    public ResponseEntity<Object> updateLoanStatus(@PathVariable String loanId, @RequestParam LoanApp loan) {
        try {
            empServ.updateLoanStatus(loanId, loan.getStatus());
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return ResponseEntity.status(404).body(map);
		}
    }
	
	@GetMapping("/viewCS/{customerPan}")
    public ResponseEntity<Integer> viewCreditScore(@PathVariable String customerPan) {
        try {
            int creditScore = empServ.viewCreditScore(customerPan);
            return ResponseEntity.ok(creditScore);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	

}
