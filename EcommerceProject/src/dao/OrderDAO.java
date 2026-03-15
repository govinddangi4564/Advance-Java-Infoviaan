package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DBConnection.DBConnection;
import model.Order;
import model.OrderItem;

public class OrderDAO {

//  Create order

	public int createOrder(Order odr) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"insert into orders (customer_id, order_date, total_amount, status) values(?,?,?,?)");
			pst.setInt(1, odr.getCustomerId());
			pst.setDate(2, odr.getOrderDate());
			pst.setDouble(3, odr.getOrderAmount());
			pst.setString(4, odr.getOrderStatus());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// Add items to order 

	public int addItems(OrderItem odrItm) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"insert into order_items (order_id, product_id, quantity, price) values(?,?,?,?)");
			pst.setInt(1, odrItm.getOrderId());
			pst.setInt(2, odrItm.getProductId());
			pst.setInt(3, odrItm.getOrderItemQuantity());
			pst.setDouble(4, odrItm.getOrderItemPrice());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// Proceed Order

	public int proceedOrder(int id, Double amount) {
		int i = 0;

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update orders set total_amount = ? where order_id = ?");
			pst.setDouble(1, amount);
			pst.setInt(2, id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// View Order Details

	public List<Order> orderDetails(int odrId) {
		List<Order> list = new LinkedList<Order>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from orders where order_id = ?");
			pst.setInt(1, odrId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("order_id");
				int cId = rs.getInt("customer_id");
				Double amt = rs.getDouble("total_amount");
				Date dt = rs.getDate("order_date");
				String sts = rs.getString("status");

				list.add(new Order(id, cId, amt, dt, sts));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// Update Status

	public int updateStatus(int id, String status) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("update Orders set status = ? where order_id = ?");
			pst.setString(1, status);
			pst.setInt(2, id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// Delete order

	public int deleteOrder(int id) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Delete from orders where order_id = ?");
			pst.setInt(1, id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

//  View Order Report

	public List<Order> orderReport() {
		List<Order> list = new LinkedList<Order>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from orders");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("order_id");
				int cId = rs.getInt("customer_id");
				Double amt = rs.getDouble("total_amount");
				Date dt = rs.getDate("order_date");
				String sts = rs.getString("status");

				list.add(new Order(id, cId, amt, dt, sts));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

//  View Order Report by OderId

	public List<Order> orderReport(int odrId) {
		List<Order> list = new LinkedList<Order>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from orders where order_id = ?");
			pst.setInt(1, odrId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("order_id");
				int cId = rs.getInt("customer_id");
				Double amt = rs.getDouble("total_amount");
				Date dt = rs.getDate("order_date");
				String sts = rs.getString("status");

				list.add(new Order(id, cId, amt, dt, sts));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// Get Product Price

	public double productPrice(int id) {
		double price = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select price from Products where product_id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				price = rs.getDouble("price");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}

// Get Total Amount for proceed order

	public double totalAmount(int id) {
		double total = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con
					.prepareStatement("SELECT SUM(quantity * price) AS total FROM order_items WHERE order_id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				total = rs.getDouble("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

// Get order items by order id

	public List<OrderItem> orderItem(int odrId) {
		List<OrderItem> list = new LinkedList<OrderItem>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con
					.prepareStatement("SELECT product_id, quantity, price FROM order_items WHERE order_id = ?");
			pst.setInt(1, odrId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int proId = rs.getInt("product_id");
				int quantity = rs.getInt("quantity");
				Double amt = rs.getDouble("price");

				list.add(new OrderItem(proId, quantity, amt));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Get payment id by order id

	public int proId(int odrId) {
		int id = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT product_id FROM order_items WHERE order_id = ?");
			pst.setInt(1, odrId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				id = rs.getInt("product_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}
}
