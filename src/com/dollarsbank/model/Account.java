package com.dollarsbank.model;

//this one is an abstraction
public abstract class Account {
	
	public abstract String fundTransfer(double Balance, double amount, String custAccName);
	
	public abstract double deposit(double amount);
	
	public abstract double withdraw(double amount);
	
	public abstract void printList();
	
	public abstract void transHistory(String text);
}
