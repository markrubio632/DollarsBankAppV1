package com.dollarsbank.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//this is the daoimpl
public class SavingsAccount extends Account {

	// may have to change these to public to use in other methods/classes
	private Account acc;

	private Customer cust;

	public String fundTransfer(double balance, double withdraw, double deposit, String custAccName) {

		if (custAccName.equals(cust.getCustAccName())) {

		}

		return null;
	}

	public double depositAmounts(double balance, double deposit) {
		// TODO Auto-generated method stub

		balance = cust.getCustBalance() + deposit;
		cust.setCustBalance(balance);
		return balance;
	}

	@Override
	public void withdrawAmounts(double balance, double withdraw) {
		
		//THIS MAY NEED TO BE A PUBLIC DOUBLE
		
		if(balance >= withdraw) {
			balance = cust.getCustBalance() - withdraw;
		cust.setCustBalance(balance);
		}
		else {
			System.out.println("Overdraw not allowed. Please try again with a different amount.");
			System.out.println("Current balance: " + balance);
		}
	}

	public List<Customer> transList(String custAccName) {
		// store lists of transactions
		// this uses the function from the abstract class Account.java
		List<Customer> custList = (List<Customer>) acc.transList(cust.custAccName);
		return custList;
	}

	@Override
	public Customer addCustomer() {

		Customer customer = new Customer();

		return customer;
	}
	@Override
	public List transHistory() {
		// TODO Auto-generated method stub
		//when adding in a new user add a timestamp to associate with
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println(timeStamp);
		return null;
	}

}
