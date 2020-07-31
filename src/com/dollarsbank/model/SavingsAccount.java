package com.dollarsbank.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//this is the daoimpl
public class SavingsAccount extends Account {
	private Customer cust;

	private double balance;

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	private List<String> transHistory = new ArrayList<String>();

	public List<String> getTransHistory() {
		return transHistory;
	}

	public void setTransHistory(List<String> transHistory) {
		this.transHistory = transHistory;
	}

	public String fundTransfer(double balance, double withdraw, double deposit, String custAccName) {

		if (custAccName.equals(cust.getCustAccName())) {

		}

		return null;
	}

	// this print the list
	public void printList(Customer customer) {

		for (String strong : transHistory) {
			getTransHistory();
			System.out.println(strong.toString());
		}

	}

	// this adds to the list
	@Override
	public void addHistory(String text) {
		
		if (transHistory.size() == 5) {
			transHistory.remove(0);
			System.out.println("removing index 0");
			transHistory.add(text + "added at " + timeStamp);

		} else {

			transHistory.add(text + "added at " + timeStamp);
		}

	}

	@Override
	public String fundTransfer(double Balance, double amount, String custAccName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double deposit(double amount) {
		
		if (transHistory.size() ==0) {
			
		}
		else {
			addHistory("Deposited " + amount + " as of " + timeStamp);
		}
		
		balance += amount;
		return balance;
	}

	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		balance -= amount;
		return balance;
	}

}
