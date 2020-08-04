package com.dollarsbank.model;

import java.util.List;

//this one is an abstraction
public abstract class Account {
	
	public abstract double fundTransfer(double amount, int receiverId);
	
	public abstract double deposit(double amount);
	
	public abstract double depositTrans(double amount);
	
	public abstract double withdraw(double amount);
	
	public abstract void addHistory(String text);
	
	public abstract void printList();
	
	public abstract List<String> getHistories();
}
