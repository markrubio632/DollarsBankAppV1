package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class DollarsBankController {
	// this is the controller

	SavingsAccount save;

	// these are just for the fun capitals used in some UIs
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
		jeeves.add(new Customer("Josh", "Dimmsdale Dimmadome", "928-888-4203", 117, "jeeves", 320223, 1020201, "[117-J]"));
	}

	// ALL PRINT BLOCKS SHOULD PROB GO TO CONSOLE PRINTER UTIL PAGE

	public void controllerRunner() throws InterruptedException {

		while (true) {
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
	}

	public void creationInterface() throws InterruptedException {
		// this will direct to creation of new account
		if (optChosen == 1) {

			Customer cust = new Customer();
			System.out.println("custom created");

			// header for the UI
			System.out.println("Enter Details for New Account");

			System.out.println("Customer Name: ");
			// Scanner cn = new Scanner(System.in);
			// cust.custName = cn.nextLine();
			String name = "";
			// System.out.println(name);
			name = sc.nextLine();
			// System.out.println(name);
			cust.setCustName(name);
			// System.out.println("name set");

			System.out.println("Customer Address: ");
			cust.custAddress = sc.nextLine();
			cust.setCustAddress(cust.custAddress);
			// may need set methods called to later get from memory

			System.out.println("Customer Contact Number: ");
			cust.custPhone = sc.nextLine();
			cust.setCustPhone(cust.custPhone);
			// may need set methods called to later get from memory

			System.out.println("Customer ID: ");
			cust.custId = sc.nextInt();
			sc.nextLine();
			cust.setCustId(cust.custId);
			// may need set methods called to later get from memory

			System.out.println("Customer Password: ");
			cust.custPassword = sc.nextLine();
			cust.setCustPassword(cust.custPassword);
			// may need set methods called to later get from memory

			System.out.println("Customer Initial Deposit Amount: ");
			cust.custDeposAmount = sc.nextInt();
			cust.custBalance = cust.custDeposAmount;
			sc.nextLine();
			cust.setCustDeposAmount(cust.custDeposAmount);

			// add all the setters into a customer object from a list
			jeeves.add(new Customer(cust.getCustName(), cust.getCustAddress(), cust.getCustPhone(), cust.getCustId(),
					cust.getCustPassword(), cust.getCustDeposAmount(), cust.getCustBalance(), cust.getCustAccName()));
			
			
			System.out.println(jeeves.toString());

			// may need set methods called to later get from memory
			System.out.println("user successfully created, redirecting to login...");
			try {
				Thread.sleep(2000);
				loginInterface();
			} catch (InterruptedException e) {
				// log the exception.
			}
		}
		// this will go to login interface
		else if (optChosen == 2) {
			loginInterface();
		}
		// if anything other than "1" or "2" is inserted
		else {// this will put the thread to sleep for 2 seconds, then close program
			try {
				System.out.println("Exiting Program...");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// log the exception.
			}

			System.exit(0);
		}
	}// end of the userInterface method

	public void loginInterface() {
		Customer cust = new Customer();

		String userName = "";
		String userPass = "";
		Boolean isLogged = false;
		int iterator = 0;

		System.out.println("Enter Login Details");

		System.out.println("User Name: ");
		userName = sc.nextLine();
		cust.setCustName(userName);

		System.out.println("Password: ");
		userPass = sc.nextLine();
		cust.setCustPassword(userPass);

		for (Customer customer : jeeves) {

			System.out.println(customer);

			if (customer.getCustName().equalsIgnoreCase(userName) && customer.getCustPassword().equalsIgnoreCase(userPass)) {
				isLogged = true;
				System.out.println("is logged is true in the loop");
				break;
			} else {
				isLogged = false;
				System.out.println("is logged is false in the loop");
			}
			iterator++;
		}

		if (isLogged == true) {
			try {
				System.out.println("Login sucessful, redirecting to customer interface...");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// log the exception.
			}
			custCommInterface(iterator);
		} else if (isLogged == false) {
			System.out.println("The user login failed, check username and password");
			loginInterface();
		}
	}

	public void custCommInterface(int iterator) {
		Customer cust = new Customer();
		SavingsAccount save = new SavingsAccount();
		
		jeeves.get(iterator).toString();
		
		double amount = 0;
		System.out.println(welcome + " Customer!!!");

		System.out.println("1. Deposit Amount");

		System.out.println("2. Withdraw Amount");

		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign Out");

		commChosen = sc.nextInt();
		sc.nextLine();

		if (commChosen == 1) {
			System.out.println("How much would you like to deposit?");
			
			amount = sc.nextDouble();
			
			System.out.println("current balance is: " + balance);
			
			
			if(amount >=0) {
				balance += save.deposit(amount);
				jeeves.get(iterator).setCustBalance(balance);
				System.out.println("your new balance is: "+ jeeves.get(iterator).getCustBalance());
				save.transHistory(bankName);
				custCommInterface(iterator);
			}
			
			
		} else if (commChosen == 2) {
			
			System.out.println("How much would you like to withdraw?");
			
			amount = sc.nextDouble();
			
			System.out.println("current balance is: " + balance);
			
			if(amount >=0 && amount <= jeeves.get(iterator).getCustBalance()) {
				balance += save.withdraw(amount);
				jeeves.get(iterator).setCustBalance(balance);
				System.out.println("withdraw success, your new balance is: "+ jeeves.get(iterator).getCustBalance());
				save.printList();
				custCommInterface(iterator);
			}
			else {
				
				try {
					System.out.println("invalid input, current funds available: " + jeeves.get(iterator).getCustBalance());
					System.out.println("Returning to customer options...");
					Thread.sleep(2000);
					custCommInterface(iterator);
				} catch (InterruptedException e) {
					// log the exception.
				}
			}
			
		} else if (commChosen == 3) {
			save.fundTransfer(balance, withdraw, deposit, cust.getCustAccName());
		}
		//this needs to properly save the timestamp and write to the list
		else if (commChosen == 4) {
			save.printList();
			
			
			
		} else if (commChosen == 5) {
			save.printList();
		} else if (commChosen == 6) {
			try {
				System.out.println("Singing out of current user...");
				Thread.sleep(2000);
				loginInterface();
				// insert login console page method name();
			} catch (InterruptedException e) {
				// log the exception.
			}
		} else {
			try {
				System.out.println("No valid option chosen. Refreshing...");
				Thread.sleep(2000);
				custCommInterface(iterator);
				// insert login console page method name();
			} catch (InterruptedException e) {
				// log the exception.
			}
		}
	}

}
