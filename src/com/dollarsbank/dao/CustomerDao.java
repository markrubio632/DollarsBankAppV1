package com.dollarsbank.dao;

import java.util.List;

import com.dollarsbank.model.Customer;

public interface CustomerDao {
	
	public int saveCustomer(Customer customer);
	
	public int updateBalance(double custBalance, int custId);
	
	public int deleteCustomer(int CustId);
	
	public List<Customer> findAllCustomers();
	
	public Customer findById(int custId);

}
