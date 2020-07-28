package com.dollarsbank.model;

import java.util.List;

//this is the daoimpl
public class SavingsAccount extends Account{
	
	private Account acc;
	
	private int currentBalance;
	private int deposit;
	private int withdraw;
	private int balance;
	//maybe needed in controller instead?
	private int accountName;

	@Override
	public String fundTransfer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int depositAmounts() {
		// TODO Auto-generated method stub
		
		balance = currentBalance + deposit;
		
		return balance;
	}

	@Override
	public int withdrawAmounts() {
		// TODO Auto-generated method stub
		
		//also to make sure it wont allow users to withdraw more than what is available
		
		balance = currentBalance - withdraw;
		
		return balance;
	}

	@Override
	public List<Customer> transList() {
		//store lists of transactions
		//this uses the function from the abstract class Account.java
		//a param will have to pass through for custAccountName
		List<Customer> custList = (List<Customer>) acc.transList();
		return custList;
	}
	
}
