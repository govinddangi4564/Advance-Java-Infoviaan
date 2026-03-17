package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DBConnection.DBConnection;
import controller.CustomerController;
import model.Customer;

public class CustomerDAO {

// Add Customers

	public int addCustomer(Customer cust) {
		int custId = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con
					.prepareStatement("insert into customers(name, phone_number, address, created_at) values(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);

			pst.setString(1, cust.getCustomerName());
			pst.setString(2, cust.getCustomerNumber());
			pst.setString(3, cust.getCustomerAddress());
			pst.setDate(4, cust.getCustomerCreatedDate());

			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			while(rs.next()) {
				custId = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return custId;
	}

// Remove Customer

	public int removeCustomer(int id) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Delete from Customers where customer_id = ?");
			pst.setInt(1, id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

// View Customers by id

	public List<Customer> viewCustomer(int customerId) {
		List<Customer> list = new LinkedList<Customer>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from Customers where customer_id = ?");
			pst.setInt(1, customerId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("customer_id");
				String name = rs.getString("name");
				String phNo = rs.getString("phone_number");
				String add = rs.getString("address");
				Date dt = rs.getDate("created_at");

				list.add(new Customer(id, name, phNo, add, dt));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// View Customers by Name

	public List<Customer> viewCustomer(String customerName) {
		List<Customer> list = new LinkedList<Customer>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from Customers where name = ?");
			pst.setString(1, customerName);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("customer_id");
				String name = rs.getString("name");
				String phNo = rs.getString("phone_number");
				String add = rs.getString("address");
				Date dt = rs.getDate("created_at");

				list.add(new Customer(id, name, phNo, add, dt));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// Update customer

	public int updateCustomer(int id, int choice, String value) {
		int i = 0;
		String query = "";

		try {
			Connection con = DBConnection.getConnection();

			if (choice == 1) {
				query = "update Customers set name = ? where customer_id = ?";
			} else if (choice == 2) {
				query = "update Customers set phone_number = ? where customer_id = ?";
			} else if (choice == 3) {
				query = "update Customers set address = ? where customer_id = ?";
			}
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, value);
			pst.setInt(2, id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// Customers Report

	public List<Customer> customerReport() {
		List<Customer> list = new LinkedList<Customer>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from Customers");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("customer_id");
				String name = rs.getString("name");
				String phNo = rs.getString("phone_number");
				String add = rs.getString("address");
				Date dt = rs.getDate("created_at");

				list.add(new Customer(id, name, phNo, add, dt));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// Get customer id by order id

	public int custId(int odrId) {
		int id = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT customer_id FROM Orders WHERE order_id = ?");
			pst.setInt(1, odrId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				id = rs.getInt("customer_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

}
