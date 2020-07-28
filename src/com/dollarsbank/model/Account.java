package com.dollarsbank.model;

import java.util.List;

//this one is an abstraction
public abstract class Account {
	//this is the dao
	//insert methods for actions (i.e. transfer funds btwn account)
	
	
	
	public abstract String fundTransfer();
	
	public abstract int depositAmounts();
	
	public abstract int withdrawAmounts();
	
	//get Customer accountName and pass through as a param
	public abstract List<Customer> transList();
	
}
