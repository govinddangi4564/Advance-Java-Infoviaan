package model;

import java.sql.Date;

public class Payment {
	private int paymentId;
	private int orderId;
	private double paymentAmount;
	private String paymentMethod;
	private Date paymentDate;
	private String paymentStatus;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int paymentId, int orderId, double paymentAmount, String paymentMethod, Date paymentDate,
			String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.paymentAmount = paymentAmount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}

	public Payment(int orderId, double paymentAmount, String paymentMethod, Date paymentDate, String paymentStatus) {
		super();
		this.orderId = orderId;
		this.paymentAmount = paymentAmount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMethod=" + paymentMethod + ", paymentDate=" + paymentDate
				+ ", paymentAmount=" + paymentAmount + ", paymentStatus=" + paymentStatus + "]";
	}

}
