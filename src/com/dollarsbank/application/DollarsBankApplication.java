package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;

//import com.dollarsbank.controller.DollarsBankController;

public class DollarsBankApplication {

	public static void main(String[] args) throws InterruptedException {
			//call controller stuff forUI
		
		DollarsBankController dbc = new DollarsBankController();
		
		dbc.controllerRunner();
		//calling from controller didnt work?
		
	}

}
