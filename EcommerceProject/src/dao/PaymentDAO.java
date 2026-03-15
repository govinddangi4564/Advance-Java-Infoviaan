package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DBConnection.DBConnection;
import model.Payment;

public class PaymentDAO {

// Make Payment

	public int makePayment(Payment p) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"insert into payments (order_id, payment_method, payment_date, amount, payment_status) values(?,?,?,?,?)");
			pst.setInt(1, p.getOrderId());
			pst.setString(2, p.getPaymentMethod());
			pst.setDate(3, p.getPaymentDate());
			pst.setDouble(4, p.getPaymentAmount());
			pst.setString(5, p.getPaymentStatus());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// Payment Receipt

	public List<Payment> paymentReceipt(int odrId){
		List<Payment> list = new LinkedList<Payment>();
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT payment_id, payment_method, payment_date, payment_status, amount FROM payments WHERE order_id = ?");
			pst.setInt(1, odrId);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int payId = rs.getInt("payment_id");
				String mode = rs.getString("payment_method");
				Date dt = rs.getDate("payment_date");
				double amt = rs.getDouble("amount");
				String status = rs.getString("payment_status");
				
				list.add(new Payment(payId, odrId, amt, mode, dt, status));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

// Check Order Id Present or not in

	public boolean orderExists(int odrId) {
		boolean exists = false;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select total_amount from orders where order_id = ?");
			pst.setInt(1, odrId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				exists = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}

// Check Payment Status

	public String StatusExists(int odrId) {
		String status = "";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select payment_status from Payments where order_id = ?");
			pst.setInt(1, odrId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				status = rs.getString("payment_status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

// Get Order Amount Total Bill from order table

	public double getTotal(int odrId) {
		double total = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select total_amount from Orders where order_id = ?");
			pst.setDouble(1, odrId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				total = rs.getDouble("total_amount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

// Update payment status if payment is not proceed;

	public int updatePayment(Payment pay) {
		int i = 0;

		Connection con = DBConnection.getConnection();
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(
					"UPDATE payments SET payment_method=?, payment_date=?, amount=?, payment_status=? WHERE order_id=?");

			pst.setString(1, pay.getPaymentMethod());
			pst.setDate(2, pay.getPaymentDate());
			pst.setDouble(3, pay.getPaymentAmount());
			pst.setString(4, pay.getPaymentStatus());
			pst.setInt(5, pay.getOrderId());

			i = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
