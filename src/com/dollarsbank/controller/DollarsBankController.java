package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.dao.CustomerDaoImpl;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankController {
	// this is the controller

	SavingsAccount save;

	CustomerDaoImpl daoimpl = new CustomerDaoImpl();

	public int optChosen;
	public int commChosen;
	public double balance;
	public double withdraw;
	public double deposit;
	public int iterator;

	// displays output to user
	public static ConsolePrinterUtility cpu = new ConsolePrinterUtility();

	Scanner sc = new Scanner(System.in);

	static List<Customer> jeeves = new ArrayList<Customer>();
	static {
		CustomerDaoImpl daoimpl = new CustomerDaoImpl();
		
		jeeves.add(new Customer("Josh", "Dimmsdale Dimmadome", "928-888-4203", "jeeves", 320223, "[117-J]"));
		
	}
	public void controllerRunner() throws InterruptedException {

		while (true) {
			CustomerDaoImpl.getConnection();
			//create database needs to be worked, for now working with an empty local
			//daoimpl.createDatabase();
			cpu.mainMenu();
			try {
				optChosen = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {

			}
			if (optChosen == 1) {
				creationInterface();
			} else if (optChosen == 2) {
				loginInterface();
				custCommInterface(iterator);
			} else if (optChosen == 3) {
				daoimpl.shutdownDatabase();
				System.exit(0);
			} else {
				System.out.println("invalid option, please choose from the menu");
				cpu.mainMenu();
			}
		}

	}

	public void creationInterface() throws InterruptedException {
		Customer cust = new Customer();
		
		System.out.println("Enter Details for New Account");

		System.out.println("Customer Name: ");
		cust.custName = sc.nextLine();
		cust.setCustName(cust.getCustName());

		System.out.println("Customer Address: ");
		cust.custAddress = sc.nextLine();
		cust.setCustAddress(cust.custAddress);

		System.out.println("Customer Contact Number: ");
		cust.custPhone = sc.nextLine();
		cust.setCustPhone(cust.custPhone);

		/*
		 * System.out.println("Customer ID: "); cust.custId = sc.nextInt();
		 * sc.nextLine(); cust.setCustId(cust.custId);
		 */

		System.out.println("Customer Password: ");
		cust.custPassword = sc.nextLine();
		cust.setCustPassword(cust.custPassword);

		System.out.println("Customer Initial Deposit Amount: ");
		cust.custBalance = sc.nextDouble();
		sc.nextLine();
		cust.setCustBalance(cust.custBalance);

		System.out.println("Customer Account Name: ");
		cust.custAccName = sc.nextLine();
		cust.setCustAccName(cust.custAccName);

		// add all the setters into a customer object list of jeeves
		jeeves.add(new Customer(cust.getCustName(), cust.getCustAddress(), cust.getCustPhone(),
				cust.getCustPassword(), cust.getCustBalance(), cust.getCustAccName()));
		
		//this saves the new user into the database
		daoimpl.saveCustomer(cust);
		System.out.println(cust);

		System.out.println("user successfully created, redirecting to login...");
		try {
			Thread.sleep(2000);
			loginInterface();
		} catch (InterruptedException e) {
			// log the exception.
		}
	}/*
		 * // this will go to login interface else if (optChosen == 2) {
		 * loginInterface(); } // if anything other than "1" or "2" is inserted else {//
		 * this will put the thread to sleep for 2 seconds, then close program try {
		 * System.out.println("Exiting Program..."); Thread.sleep(2000); } catch
		 * (InterruptedException e) { // log the exception. }
		 * 
		 * System.exit(0); } }// end of the userInterface method
		 */

	public void loginInterface() {
		Customer cust = new Customer();
		List<Customer> jeeves = daoimpl.findAllCustomers();
		String userName = "";
		String userPass = "";
		Boolean isLogged = false;
		iterator = 0;

		System.out.println("Enter Login Details");

		System.out.println("User Name: ");
		userName = sc.nextLine();
		cust.setCustName(userName);

		System.out.println("Password: ");
		userPass = sc.nextLine();
		cust.setCustPassword(userPass);
		
		//daoimpl.findAllCustomers();
		
		//this should find customers in DB and iterate through
		/*
		 * for(Customer custo : daoimpl.findAllCustomers()) { System.out.println(custo);
		 * if (custo.getCustName().equalsIgnoreCase(userName) &&
		 * custo.getCustPassword().equalsIgnoreCase(userPass)) { isLogged = true;
		 * System.out.println("is logged is true in the loop"); break; } else { isLogged
		 * = false; System.out.println("is logged is false in the loop"); } iterator++;
		 * }
		 */
		

		for (Customer customer : jeeves) {

			System.out.println(customer);

			if (customer.getCustName().equalsIgnoreCase(userName)
					&& customer.getCustPassword().equalsIgnoreCase(userPass)) {
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
		Customer customer = new Customer();
		SavingsAccount save = new SavingsAccount();

		List<Customer> jeeves = daoimpl.findAllCustomers();
		jeeves.get(iterator).toString();

		double bal;
		double amount;
		int custId;

		cpu.customerMenu();

		commChosen = sc.nextInt();
		sc.nextLine();

		if (commChosen == 1) {
			System.out.println("How much would you like to deposit?");

			amount = sc.nextDouble();

			System.out.println("current balance is: " + jeeves.get(iterator).getCustBalance());
			// balance = jeeves.get(iterator).getCustBalance();

			if (amount >= 0) {

				bal = jeeves.get(iterator).getCustBalance();
				bal += save.deposit(amount);
				jeeves.get(iterator).setCustBalance(bal);
				
				//this uses the person in the DB - test
				daoimpl.updateBalance(jeeves.get(iterator).custBalance, customer.getCustId());
				
				System.out.println("success, your new balance is: " + jeeves.get(iterator).getCustBalance());
				save.printList();

				custCommInterface(iterator);
			}
			else {
				System.out.println("there was an issue with the transaction.");
				custCommInterface(iterator);
			}

		} else if (commChosen == 2) {

			System.out.println("How much would you like to withdraw?");

			amount = sc.nextDouble();

			System.out.println("current balance is: " + jeeves.get(iterator).getCustBalance());

			if (amount >= 0 && amount <= jeeves.get(iterator).getCustBalance()) {

				bal = jeeves.get(iterator).getCustBalance();
				bal += save.withdraw(amount);
				jeeves.get(iterator).setCustBalance(bal);
				//this uses the person in the DB - test
				daoimpl.updateBalance(jeeves.get(iterator).getCustBalance(), customer.getCustId());
				
				System.out.println("success, your new balance is: " + jeeves.get(iterator).getCustBalance());
				save.printList();
				custCommInterface(iterator);
			} else {

				try {
					System.out.println(
							"invalid input, current funds available: " + jeeves.get(iterator).getCustBalance());
					System.out.println("Returning to customer options...");
					Thread.sleep(2000);
					custCommInterface(iterator);
				} catch (InterruptedException e) {
					// log the exception.
				}
			}

		} else if (commChosen == 3) {

			String receiverName = "";
			Boolean userExists = false;

			System.out.println("What user are you willing to transfer funds to? User Name: ");
			receiverName = sc.nextLine().toLowerCase();

			for (Customer cust : jeeves) {

				if (customer.getCustName().equals(receiverName)) {
					userExists = true;
				}

			}
			
			if(!userExists) {
				System.out.println("User doesn't exist");
				custCommInterface(iterator);
			}

			System.out.println("How much are you willing to send over to " + receiverName + "?");
			amount = sc.nextDouble();
			sc.nextLine();

			if (amount >= 0 && amount <= jeeves.get(iterator).custBalance) {

				if (jeeves.get(iterator).getCustName().equals(receiverName)) {
					save.fundTransfer(amount, receiverName);
					System.out.println("your current balance is: " + jeeves.get(iterator).getCustBalance());
					custCommInterface(iterator);
				} else {
					System.out.println("the user name you entered isn't correct");
					custCommInterface(iterator);
				}

			}
			else {
				System.out.println("there was issue with your current balance and the amount entered");
				custCommInterface(iterator);
			}

		}

		//fix output. its only outputting one record at a time
		else if (commChosen == 4) {
			save.getTransHistory();
			System.out.println(save.getTransHistory());

			save.printList();
			
			custCommInterface(iterator);
		}

		else if (commChosen == 5) {
			System.out.println("What ID are you looking for? ");
			custId = sc.nextInt();
			sc.nextLine();
			daoimpl.findById(custId);
			
			//daoimpl.findById(customer.getCustId());
			//daoimpl.findAllCustomers();
			custCommInterface(iterator);
		}

		else if (commChosen == 6) {
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
