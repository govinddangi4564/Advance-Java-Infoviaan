package model;

import java.sql.Date;

public class Customer {
	private int customerId;
	private String customerName;
	private String customerNumber;
	private String customerAddress;
	private Date customerCreatedDate;

	public Customer() {

	}

	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public Customer(int customerId, String customerName, String customerNumber, String customerAddress,
			Date customerCreatedDate) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.customerAddress = customerAddress;
		this.customerCreatedDate = customerCreatedDate;
	}

	public Customer(String customerName, String customerNumber, String customerAddress, Date customerCreatedDate) {
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.customerAddress = customerAddress;
		this.customerCreatedDate = customerCreatedDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Date getCustomerCreatedDate() {
		return customerCreatedDate;
	}

	public void setCustomerCreatedDate(Date customerCreatedDate) {
		this.customerCreatedDate = customerCreatedDate;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerNumber="
				+ customerNumber + ", customerAddress=" + customerAddress + ", customerCreatedDate="
				+ customerCreatedDate + "]";
	}

}
