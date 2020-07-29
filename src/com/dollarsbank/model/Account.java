package com.dollarsbank.model;

import java.util.List;

//this one is an abstraction
public abstract class Account {
	//this is the dao
	//insert methods for actions (i.e. transfer funds btwn account)
	
	public abstract Customer addCustomer();
	
	//public abstract Customer addCustomer();
	
	public abstract String fundTransfer(double Balance, double withdraw, 
			double deposit, String custAccName);
	
	public abstract double depositAmounts(double balance, double deposit);
	
	public abstract void withdrawAmounts(double balance, double withdraw);
	
	//get Customer accountName and pass through as a param
	public abstract List<Customer> transList(String custAccName);
	
	public abstract List transHistory();
}
