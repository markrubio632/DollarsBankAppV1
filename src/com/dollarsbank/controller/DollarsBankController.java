package com.dollarsbank.controller;

import java.util.Scanner;

import com.dollarsbank.model.Customer;

public class DollarsBankController {
	// this is the controller
	// contain UI stuff
	
	//these are just for the fun capitals used in some UIs
	private static final String businessName = "DOLLARSBANK";
	public static final String welcome = "WELCOME";

	public final String bankName = businessName;
	
	public int optChosen;

	//ALL PRINT BLOCKS SHOULD PROB GO TO CONSOLE PRINTER UTIL PAGE
	
	public int introInterface() {

		System.out.println(bankName + " Welcomes You!");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		Scanner sc = new Scanner(System.in);
		optChosen = sc.nextInt();
		sc.close();
		return optChosen;
	}

	public void userInterface() throws InterruptedException {
		//this will direct to creation of new account
		if (optChosen == 1) {
			// new customer instanciation
			Customer cust = new Customer();
			
			//header for the UI
			System.out.println("Enter Details for New Account");
			
			System.out.println("Customer Name: ");
				Scanner cn = new Scanner(System.in);
				cust.custName = cn.nextLine();
				cn.close();
				//may need set methods called to later get from memory
				
			System.out.println("Customer Address: ");
				Scanner ca = new Scanner(System.in);
				cust.custAddress = ca.nextLine();
				ca.close();
			//may need set methods called to later get from memory
			
			System.out.println("Customer Contact Number: ");
				Scanner cp = new Scanner(System.in);
				cust.custPhone = cp.nextInt();
				cp.close();
			//may need set methods called to later get from memory
			
			System.out.println("Customer ID: ");
				Scanner ci = new Scanner(System.in);
				cust.custId = ci.nextInt();
				ci.close();
			//may need set methods called to later get from memory
			
			System.out.println("Customer Password: ");
				Scanner cpa = new Scanner(System.in);
				cust.custPassword = cpa.nextLine();
				cpa.close();
			//may need set methods called to later get from memory
			
			System.out.println("Customer Initial Deposit Amount: ");
				Scanner cd = new Scanner(System.in);
				cust.custDeposAmount = cd.nextInt();
				cd.close();
			//may need set methods called to later get from memory
			
			System.out.println("user successfully created, redirecting to login...");
			try {
				Thread.sleep(2000);
				//insert login console page method name();
			} catch (InterruptedException e) {
				// log the exception.
			}
		}
		//this will go to login interface
		else if (optChosen == 2) {
			loginInterface();
			

		}
		//if anything other than "1" or "2" is inserted
		else {//this will put the thread to sleep for 2 seconds, then close program
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// log the exception.
			}

			System.exit(0);
		}
	}//end of the userInterface method
	
	
	public void loginInterface() {
		Customer cust = new Customer();
		System.out.println("Enter Login Details");
		
		System.out.println("User Id: ");
			Scanner ci = new Scanner(System.in);
			cust.custDeposAmount = ci.nextInt();
			ci.close();
			
		System.out.println("Password: ");
			Scanner cpa = new Scanner(System.in);
			cust.custPassword = cpa.nextLine();
			cpa.close();
			
			//validation for success or failure
			
			//redirect to customer commands page
	}
	
	public void customerCommands() {
		
		System.out.println(welcome + " Customer!!!");
		//if function to find the option
		
		System.out.println("1. Deposit Amount");
			//insert deposit function
		
		System.out.println("2. Withdraw Amount");
			//insert withdraw function
		
		System.out.println("3. Funds Transfer");
			//insert fund transfer function
		
		System.out.println("4. View 5 Recent Transactions");
			//find 5 recent transactions using DATE() function
		
		System.out.println("5. Display Customer Information");
			//display cust information - Following Details from new Account
		
		System.out.println("Sign Out");
			//sign out function - timed redirect back to introInterface()
		
	}

}
