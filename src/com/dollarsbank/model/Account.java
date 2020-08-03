package com.dollarsbank.model;

//this one is an abstraction
public abstract class Account {
	
public abstract double fundTransfer(double amount, String receiverId);
	
	public abstract double deposit(double amount);
	
	public abstract double withdraw(double amount);
	
	public abstract void printList();
	
	public abstract void addHistory(String text);
}
