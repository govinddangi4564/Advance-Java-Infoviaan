package model;

public class OrderItem {
	private int orderItemId;
	private int orderId;
	private int productId;
	private int orderItemQuantity;
	private double orderItemPrice;

	public OrderItem(int orderId, int productId, int orderItemQuantity, double orderItemPrice) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.orderItemQuantity = orderItemQuantity;
		this.orderItemPrice = orderItemPrice;
	}

	public OrderItem(int orderItemId, int orderItemQuantity, double orderItemPrice) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemQuantity = orderItemQuantity;
		this.orderItemPrice = orderItemPrice;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}

	public double getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(double orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", orderItemQuantity=" + orderItemQuantity + ", orderItemPrice=" + orderItemPrice + "]";
	}

}
