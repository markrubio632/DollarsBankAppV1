package com.dollarsbank.model;

public class Customer extends SavingsAccount{
	public int custId;
	public String custName;
	public String custAddress;
	public String custPhone;
	public String custPassword;
	//this is the current balance in their account
	public double custBalance;
	//the name of their account
	public String custAccName;
	

	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getCustAddress() {
		return custAddress;
	}


	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}


	public String getCustPhone() {
		return custPhone;
	}


	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getCustPassword() {
		return custPassword;
	}


	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}


	public double getCustBalance() {
		return custBalance;
	}


	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}


	public String getCustAccName() {
		return custAccName;
	}


	public void setCustAccName(String custAccName) {
		this.custAccName = custAccName;
	}
	public Customer() {
		super();
	}


	public Customer(int custId, String custName, String custAddress, String custPhone, String custPassword,
			double custBalance, String custAccName) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custPhone = custPhone;
		this.custPassword = custPassword;
		this.custBalance = custBalance;
		this.custAccName = custAccName;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress + ", custPhone="
				+ custPhone + ", custPassword=" + custPassword + ", custBalance=" + custBalance + ", custAccName="
				+ custAccName + "]";
	}

	
}