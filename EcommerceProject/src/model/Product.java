package model;

import java.sql.Date;

public class Product {
	private int productId;
	private String productName;
	private double productPrice;
	private int productStock;
	private String productCategory;
	private Date productCreatedDate;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
	}

	public Product(int productId, String productName, double productPrice, int productStock, String productCategory,
			Date productCreatedDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productCategory = productCategory;
		this.productCreatedDate = productCreatedDate;
	}

	public Product(String productName, double productPrice, int productStock, String productCategory,
			Date productCreatedDate) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productCategory = productCategory;
		this.productCreatedDate = productCreatedDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Date getProductCreatedDate() {
		return productCreatedDate;
	}

	public void setProductCreatedDate(Date productCreatedDate) {
		this.productCreatedDate = productCreatedDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productStock=" + productStock + ", productCategory=" + productCategory + ", productCreatedDate="
				+ productCreatedDate + "]";
	}

}
