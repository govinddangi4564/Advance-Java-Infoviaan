package model;

import java.sql.Date;

public class Order {
	private int orderId;
	private int customerId;
	private double orderAmount;
	private Date orderDate;
	private int orderQuantity;
	private String orderStatus;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, int customerId, double orderAmount, Date orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	public Order(int customerId, double orderAmount, Date orderDate, String orderStatus) {
		this.customerId = customerId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderAmount=" + orderAmount
				+ ", orderDate=" + orderDate + ", orderQuantity=" + orderQuantity + ", orderStatus=" + orderStatus
				+ "]";
	}

}
