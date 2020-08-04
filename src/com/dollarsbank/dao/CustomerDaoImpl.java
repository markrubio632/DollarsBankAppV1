package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Connection conn;
	PreparedStatement stmt;
	PreparedStatement dc;
	PreparedStatement tc;
	static Statement tabCreate;
	ResultSet rs;

	List<Customer> cList = new ArrayList<Customer>();
	
	private static final String CREATE_TABLE_SQL="CREATE TABLE BANK (custId int auto_increment, custName VARCHAR(20), custAddress VARCHAR(20), custPhone VARCHAR(10), custPassword VARCHAR(20), custBalance DOUBLE, custAccName VARCHAR(20))";

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			
			return conn;
		} catch (Exception e) {
			System.out.println("issue with connection");
		}
		return conn;
	}

	//this isnt working, look it over
	public void createDatabase() {
		try {
			getConnection();
			System.out.println("in create db");
			stmt = conn.prepareStatement(CREATE_TABLE_SQL);
			System.out.println("stmt saved and filled");
			stmt.executeUpdate();
			System.out.println("stmt executed");
			//tabCreate = conn.createStatement();
			//System.out.println("create statement saved into tabcreate");
			//tabCreate.executeUpdate(CREATE_TABLE_SQL);
			
			//tc = conn.prepareStatement("create table bank_customers(custId int auto_increment, custName varchar(20), custAddress varchar(20), custPhone varchar(10), custPassword varchar(20), custBalance decimal(8,2), custAccName varchar(20))");
			//tc.executeUpdate();
			System.out.println("table created");
			System.out.println("database created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("issue creating db");
			e.printStackTrace();
		}
	}
	
	public void shutdownDatabase() {
		getConnection();
		try {
			dc = conn.prepareStatement(
					"drop table bank_customers");
			dc.executeUpdate();
			System.out.println("database dropped");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("database drop unsuccessful, still exists");
			e.printStackTrace();
		}
	}

	@Override
	public int saveCustomer(Customer cust) {

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("insert into bank_customers(custName, custAddress, custPhone, custPassword, custBalance, custAccName) values (?,?,?,?,?,?)");
			
			stmt.setString(1, cust.getCustName());
			stmt.setString(2, cust.getCustAddress());
			stmt.setString(3, cust.getCustPhone());
			stmt.setString(4, cust.getCustPassword());
			stmt.setDouble(5, cust.getCustBalance());
			stmt.setString(6, cust.getCustAccName());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBalance(double bal, int user) {

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("update bank_customers set custBalance=? where custId= " + user);
			stmt.setDouble(1,bal);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCustomer(int CustId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from bank_customers");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer(rs.getInt("custId"),rs.getString("custName"),
						rs.getString("custAddress"), rs.getString("custPhone"), rs.getString("custPassword"),
						rs.getDouble("custBalance"), rs.getString("custAccName"));
				
				cList.add(customer);
				//System.out.println(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public Customer findById(int custId) {
		
		Customer cu = new Customer();
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from bank_customers where custId=?");
			stmt.setInt(1, custId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				//formats the output to the console
				System.out.println("User Id: " + rs.getInt(1)+"\n User Name: "+rs.getString(2)+"\n Address: "+rs.getString(3)+"\n Contact Number: "
				+rs.getString(4)+"\n Password"+rs.getString(5)+"\n Balance: "+rs.getDouble(6)+"\n Account Name: "+rs.getString(7));
				 				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cu;
	}
}
