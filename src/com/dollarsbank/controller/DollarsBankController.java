package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.dao.CustomerDaoImpl;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;

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
	
	public static DataGeneratorStubUtil dgsu = new DataGeneratorStubUtil();

	Scanner sc = new Scanner(System.in);
	
	int user = 0;

	static List<Customer> jeeves = new ArrayList<Customer>();
	static {
		CustomerDaoImpl daoimpl = new CustomerDaoImpl();
		
		jeeves.add(new Customer(0,"Josh", "Dimmsdale Dimmadome", "928-888-4203", "jeeves", 320223, "[117-J]"));
		
	}
	
	
	public void controllerRunner() throws InterruptedException {

		while (true) {
			CustomerDaoImpl.getConnection();
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
				custCommInterface(user, iterator);
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
		
		try {
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
		jeeves.add(new Customer(cust.getCustId(),cust.getCustName(), cust.getCustAddress(), cust.getCustPhone(),
				cust.getCustPassword(), cust.getCustBalance(), cust.getCustAccName()));
		
		//this saves the new user into the database
		daoimpl.saveCustomer(cust);

		System.out.println("user successfully created, redirecting to login...");
			
		}catch (Exception e) {
			System.out.println("User creation had an error, please check your inputs");
			Thread.sleep(2000);
			loginInterface();
		}
		
		//redirects to the login phase
		try {
			Thread.sleep(2000);
			loginInterface();
		} catch (InterruptedException e) {
			// log the exception.
		}
	}

	// this needs to find the created IDs and pull from those
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
		
		for (Customer customer : jeeves) {

			System.out.println(customer);
			

			if (customer.getCustName().equalsIgnoreCase(userName)
					&& customer.getCustPassword().equalsIgnoreCase(userPass)) {
				isLogged = true;
				user = customer.getCustId();
				
				//used for testing purposes to test if user and iterator were properly imported
				//System.out.println("user is: "+user);
				//System.out.println("iterator is "+iterator);
				break;
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
			custCommInterface(user, iterator);
		} else if (isLogged == false) {
			System.out.println("The user login failed, check username and password");
			loginInterface();
		}
	}

	public void custCommInterface(int user, int iterator) {
		Customer customer = new Customer();
		SavingsAccount save = new SavingsAccount();

		List<Customer> jeeves = daoimpl.findAllCustomers();
		//jeeves.get(iterator).toString();

		double bal = jeeves.get(iterator).getCustBalance();
		double recBal;
		double amount;
		int custId;
		
		int recPos = 0;
		int transIt = 0;
		
		List<String> tList;

		cpu.customerMenu();

		commChosen = sc.nextInt();
		sc.nextLine();

		if (commChosen == 1) {
			System.out.println("How much would you like to deposit?");

			amount = sc.nextDouble();

			System.out.println("current balance is: " + jeeves.get(iterator).getCustBalance());
			// balance = jeeves.get(iterator).getCustBalance();

			if (amount >= 0) {
				
				bal += save.deposit(amount);
				jeeves.get(iterator).setCustBalance(bal);
				
				jeeves.get(iterator).custBalance = bal;
				
				//this uses the person in the DB - test
				daoimpl.updateBalance(jeeves.get(iterator).custBalance, user);
				
				System.out.println("success, your new balance is: " + jeeves.get(iterator).getCustBalance());
				save.printList();
				

				//for testing in DB
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				custCommInterface(user, iterator);
			}
			else {
				System.out.println("there was an issue with the transaction.");
				custCommInterface(user, iterator);
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
				daoimpl.updateBalance(bal, user);
				
				System.out.println("success, your new balance is: " + jeeves.get(iterator).getCustBalance());
				save.printList();
				//for testing in DB
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				custCommInterface(user, iterator);
			} else {

				try {
					System.out.println(
							"invalid input, current funds available: " + jeeves.get(iterator).getCustBalance());
					System.out.println("Returning to customer options...");
					Thread.sleep(2000);
					custCommInterface(user, iterator);
				} catch (InterruptedException e) {
					// log the exception.
				}
			}

		} else if (commChosen == 3) {
			
			recBal = jeeves.get(recPos).getCustBalance();

			int receiverId = 0;
			boolean userExists = false;

			System.out.println("What user are you willing to transfer funds to? User Id: ");
			receiverId = sc.nextInt();
			sc.nextLine();

			for (Customer cust : jeeves) {

				if (cust.getCustId() == receiverId) {
					recPos = transIt;
					userExists = true;
				}
				transIt++;
			}
			if(!userExists) {
					System.out.println("user doesnt exist");
					custCommInterface(user, iterator);
				}

			System.out.println("How much are you willing to send over to " + receiverId + "?");
			amount = sc.nextDouble();
			sc.nextLine();
			
			recBal = jeeves.get(recPos).getCustBalance();

			if (amount >= 0 && amount <= jeeves.get(recPos).getCustBalance()) {

				if (jeeves.get(recPos).getCustId() == receiverId) {
					
					//this withdraw function is working normally
					bal += save.withdraw(amount);
					jeeves.get(iterator).setCustBalance(bal);
					jeeves.get(iterator).custBalance = bal;
					daoimpl.updateBalance(bal, user);
					
					
					recBal = recBal + save.depositTrans(amount);
					jeeves.get(recPos).setCustBalance(recBal);
					jeeves.get(recPos).custBalance = recBal;
					
					//this uses the person in the DB - test
					daoimpl.updateBalance(recBal, receiverId);
					System.out.println("transfer successful. user id " + receiverId + " received " + amount);
					
					custCommInterface(user, iterator);
				} else {
					System.out.println("the user id you entered isn't correct");
					custCommInterface(user, iterator);
				}

			}
			else {
				System.out.println("there was issue with your current balance and the amount entered");
				custCommInterface(user, iterator);
			}

		}
		else if (commChosen == 4) {
			
			tList = save.getTransHistory();
			System.out.println(tList);
			
			custCommInterface(user, iterator);
		}

		else if (commChosen == 5) {
			System.out.println("What ID are you looking for? ");
			custId = sc.nextInt();
			sc.nextLine();
			daoimpl.findById(custId);
			
			custCommInterface(user, iterator);
		}

		else if (commChosen == 6) {
			try {
				System.out.println("Generating Account Stub...");
				dgsu.stubGeneration(jeeves.get(iterator));
				System.out.println("refreshing...");
				Thread.sleep(2000);
				custCommInterface(user, iterator);
			} catch (InterruptedException e) {
				// log the exception.
			}
		}
		else if (commChosen == 7) {
			try {
				System.out.println("Signing out of current user...");
				Thread.sleep(2000);
				loginInterface();
			} catch (InterruptedException e) {
				// log the exception.
			}
		}
		if (commChosen == 8) {
			try {
				System.out.println("Closing Application...");
				Thread.sleep(2000);
				System.exit(0);
			} catch (InterruptedException e) {
				// log the exception.
			}
		}
		else {
			try {
				System.out.println("No valid option chosen. Refreshing...");
				Thread.sleep(2000);
				custCommInterface(user, iterator);
			} catch (InterruptedException e) {
				// log the exception.
			}
		}
		
		
	}

}
