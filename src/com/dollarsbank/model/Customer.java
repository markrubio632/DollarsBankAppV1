package com.dollarsbank.model;

public class Customer {
	
	public String custName;
	public String custAddress;
	public int custPhone;
	public int custId;
	public String custPassword;
	public double custDeposAmount;
	public double custBalance;
	public String custAccName;
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return custAddress;
	}
	public void setAddress(String address) {
		this.custAddress = address;
	}
	public int getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(int custPhone) {
		this.custPhone = custPhone;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getPassword() {
		return custPassword;
	}
	public void setPassword(String password) {
		this.custPassword = password;
	}
	public double getInitDeposAmount() {
		return custDeposAmount;
	}
	public void setInitDeposAmount(double initDeposAmount) {
		this.custDeposAmount = initDeposAmount;
	}
	public double getBalance() {
		return custBalance;
	}
	public void setBalance(double balance) {
		this.custBalance = balance;
	}
	
	public String getAccName() {
		return custAccName;
	}
	public void setAccName(String accName) {
		this.custAccName = accName;
	}
	public Customer(String custName, String address, int custPhone, int custId, String password, double initDeposAmount,
			double balance, String accName) {
		super();
		this.custName = custName;
		this.custAddress = address;
		this.custPhone = custPhone;
		this.custId = custId;
		this.custPassword = password;
		this.custDeposAmount = initDeposAmount;
		this.custBalance = balance;
		this.custAccName = accName;
	}
	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", address=" + custAddress + ", custPhone=" + custPhone + ", custId="
				+ custId + ", password=" + custPassword + ", initDeposAmount=" + custDeposAmount + ", balance=" + custBalance
				+ ", accName=" + custAccName + "]";
	}
	public Customer() {
		super();
	}
	
	
}