package com.dollarsbank.model;

public class Customer {
	
	public String custName;
	public String custAddress;
	public String custPhone;
	public int custId;
	public String custPassword;
	//this is the initial deposit amount made with customer creation
	public double custDeposAmount;
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


	public double getCustDeposAmount() {
		return custDeposAmount;
	}


	public void setCustDeposAmount(double custDeposAmount) {
		this.custDeposAmount = custDeposAmount;
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


	public Customer(String custName, String custAddress, String custPhone, int custId, String custPassword,
			double custDeposAmount, double custBalance, String custAccName) {
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.custPhone = custPhone;
		this.custId = custId;
		this.custPassword = custPassword;
		this.custDeposAmount = custDeposAmount;
		this.custBalance = custBalance;
		this.custAccName = custAccName;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", custAddress=" + custAddress + ", custPhone=" + custPhone
				+ ", custId=" + custId + ", custPassword=" + custPassword + ", custDeposAmount=" + custDeposAmount
				+ ", custBalance=" + custBalance + ", custAccName=" + custAccName + "]";
	}
	
	
}