package com.dollarsbank.utility;

import com.dollarsbank.model.Customer;

public class DataGeneratorStubUtil {

	public static FileStorageUtility fs = new FileStorageUtility();
	
	
	
	public boolean stubGeneration(Customer cust) {
		
		String stubHeader = "Thank you for using DOLLARSBANK services " + cust.getCustName() +", we hope to see you again really soon!";
	
	String stubMessage = 
			"ID: " + cust.getCustId() +
			"\nName: " + cust.getCustName() + 
			"\nAddress: "+ cust.getCustAddress() + 
			"\nContact Info: " + cust.getCustPhone() +
			"\nBalance: " + cust.getCustBalance();
	
	fs.fSave(cust.getCustName(), stubHeader + stubMessage);
	
	return false;
		
	}
	
	
}
