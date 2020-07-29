package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class DollarsBankController {
	// this is the controller
	
	SavingsAccount save;
	
	//these are just for the fun capitals used in some UIs
	private static final String businessName = "DOLLARSBANK";
	public static final String welcome = "WELCOME";

	public final String bankName = businessName;
	
	public int optChosen;
	public int commChosen;
	public double balance;
	public double withdraw;
	public double deposit;
	
	Scanner sc = new Scanner(System.in);
	
	static List<Customer> jeeves = new ArrayList<Customer>();
	static {
		jeeves.add(new Customer("Josh", "Dimmsdale Dimmadome", "928-888-4203", 117, "jeeves", 
				320223, 1, "[117-J]"));
	}

	//ALL PRINT BLOCKS SHOULD PROB GO TO CONSOLE PRINTER UTIL PAGE
	
	public void controllerRunner() throws InterruptedException {
		
		while(true) {
			introInterface();
			creationInterface();
		}
		
	}
	
	public void introInterface() {

		System.out.println(bankName + " Welcomes You!");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		optChosen = sc.nextInt();
		sc.nextLine();
		System.out.println("help");
		//return optChosen;
	}

	public void creationInterface() throws InterruptedException {
		//this will direct to creation of new account
		if (optChosen == 1) {
			
			Customer cust = new Customer();
			System.out.println("custom created");
			
			//header for the UI
			System.out.println("Enter Details for New Account");
			
			System.out.println("Customer Name: ");
				//Scanner cn = new Scanner(System.in);
				//cust.custName = cn.nextLine();
				String name = "";
				System.out.println(name);
				name = sc.nextLine();
				System.out.println(name);
				cust.setCustName(name);
				System.out.println("name set");
				
			System.out.println("Customer Address: ");
				cust.custAddress = sc.nextLine();
				cust.setCustAddress(cust.custAddress);
			//may need set methods called to later get from memory
			
			System.out.println("Customer Contact Number: ");
				cust.custPhone = sc.nextLine();
				cust.setCustPhone(cust.custPhone);
			//may need set methods called to later get from memory
			
			System.out.println("Customer ID: ");
				cust.custId = sc.nextInt();
				sc.nextLine();
				cust.setCustId(cust.custId);
			//may need set methods called to later get from memory
			
			System.out.println("Customer Password: ");
				cust.custPassword = sc.nextLine();
				cust.setCustPassword(cust.custPassword);
			//may need set methods called to later get from memory
			
			System.out.println("Customer Initial Deposit Amount: ");
				cust.custDeposAmount = sc.nextInt();
				sc.nextLine();
				cust.setCustDeposAmount(cust.custDeposAmount);
				
				//add all the setters into a customer object from a list
				jeeves.add(new Customer(cust.getCustName(), cust.getCustAddress(), cust.getCustPhone(),
						cust.getCustId(), cust.getCustPassword(), cust.getCustDeposAmount(),
						cust.getCustBalance(), cust.getCustAccName()));
				
				System.out.println(jeeves.toString());
				
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
			custCommInterface();
		}
		//if anything other than "1" or "2" is inserted
		else {//this will put the thread to sleep for 2 seconds, then close program
			try {
				System.out.println("Exiting Program...");
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
		
		System.out.println("User Name: ");
			cust.custName = sc.nextLine();
			cust.setCustName(cust.custName);
			
		System.out.println("Password: ");
			cust.custPassword = sc.nextLine();
			cust.setCustPassword(cust.custPassword);
			
			//this needs to search by the name and password
			
			for(Customer customer : jeeves) {
				//insert login checks for userid, username, and userpass
				//maybe create boolean for check if a user is logged in = 1, and out =0
			}
			
			
			
			//redirect to customer commands page
	}
	
	public void custCommInterface() {
		
		System.out.println(welcome + " Customer!!!");
		//if function to find the option
		commChosen = sc.nextInt();
		sc.nextLine();
		Customer cust = new Customer();
		//these will be in the printer utility
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
		
		System.out.println("6. Sign Out");
			//sign out function - timed redirect back to introInterface()
		
		//this is the find which method to call
		if (commChosen == 1) {
			balance = cust.getCustBalance();
			
			save.depositAmounts(balance, deposit);
			
			save.transHistory();
		}
		else if(commChosen == 2) {
			balance = cust.getCustBalance();
			
			save.withdrawAmounts(balance, deposit);
			
			save.transHistory();
		}
		else if(commChosen == 3) {
			save.fundTransfer(balance, withdraw, deposit, cust.getCustAccName());
		}
		//this one needs to associate the timestamp with the transaction time
		else if(commChosen == 4) {
			save.transHistory();
		}
		else if(commChosen == 5) {
			save.transList(cust.getCustAccName());
		}
		else if(commChosen == 6) {
			try {
				System.out.println("Singing out of current user...");
				Thread.sleep(2000);
				loginInterface();
				//insert login console page method name();
			} catch (InterruptedException e) {
				// log the exception.
			}
		}
		else {
			try {
				System.out.println("No valid option chosen. Refreshing...");
				Thread.sleep(2000);
				custCommInterface();
				//insert login console page method name();
			} catch (InterruptedException e) {
				// log the exception.
			}
		}
	}

}
