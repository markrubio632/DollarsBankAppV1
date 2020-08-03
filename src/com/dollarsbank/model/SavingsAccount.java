package com.dollarsbank.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//this is the daoimpl
public class SavingsAccount extends Account {
	private double balance;

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	private List<String> transHistory = new ArrayList<String>();

	public List<String> getTransHistory() {
		return transHistory;
	}

	public void setTransHistory(List<String> transHistory) {
		this.transHistory = transHistory;
	}

	@Override
	public double deposit(double amount) {
		
			addHistory("Deposited " + amount + " as of " + timeStamp);

		return balance += amount;

	}

	@Override
	public double withdraw(double amount) {
		
		addHistory("Withdrew " + amount + " as of " + timeStamp);

		return balance -= amount;

	}

	@Override
	public double fundTransfer(double amount, String receiverName) {
		
		addHistory("Withdrew " + amount + " and transferred to " + receiverName + " as of " + timeStamp);
		
		 balance -= amount;
		 //this amount should be used to add/subtract from accounts in controller
		 return amount;
	}

	@Override
	public void addHistory(String text) {
		
		if (transHistory.size() == 5) {
			transHistory.remove(0);
			System.out.println("removing index 0");
			transHistory.add(text);
			//setTransHistory(getTransHistory());

		} else {
			transHistory.add(text);
			//setTransHistory(getTransHistory());
		}

	}

	//the print history isnt working
	@Override
	public void printList() {
		
		getTransHistory();
		for (String print : transHistory)
		{
			System.out.println("in print");
			System.out.println(print);
			
		}

	}

}
