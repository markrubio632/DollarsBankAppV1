package com.dollarsbank.utility;

public class ConsolePrinterUtility {
	
	public void mainMenu() {
		System.out.println("DOLLARSBANK Welcomes You!");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	
	public void customerCreator() {
		System.out.println("Enter Details for New Account");
		System.out.println("Customer Name: ");
		System.out.println("Customer Address: ");
		System.out.println("Customer Contact Number: ");
		System.out.println("Customer ID: ");
		System.out.println("Customer Password: ");
		System.out.println("Customer Initial Deposit Amount: ");
		System.out.println("Customer Account Name: ");

	}
	
	public void loginInterface() {
		System.out.println("Enter Login Details");

		System.out.println("User Name: ");
		
		System.out.println("Password: ");
	}
	
	public void customerMenu() {
		System.out.println("Welcome Customer!!!");

		System.out.println("1. Deposit Amount");

		System.out.println("2. Withdraw Amount");

		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Generate Stub");
		System.out.println("7. Sign Out");
		System.out.println("8. Exit");
	}

}
