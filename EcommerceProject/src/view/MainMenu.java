package view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);

	public int showMenu() {
		System.out.println("---------Menu---------");
		System.out.println("Customer : 1 ");
		System.out.println("Product  : 2 ");
		System.out.println("Order    : 3 ");
		System.out.println("Payment  : 4 ");
		System.out.println("Reports  : 5 ");
		System.out.println("Exit     : 6 ");

		return sc.nextInt();
	}

//  Customer

	public int customerMenu() {
		System.out.println("\n----------- Customer Menu ------------\n");
		System.out.println("1 Add Customers : ");
		System.out.println("2 Remove Customers : ");
		System.out.println("3 Search customer by Id : ");
		System.out.println("4 Search customer by Name : ");
		System.out.println("5 Update customer : ");
		System.out.println("6 Previous Menu : ");

		return sc.nextInt();
	}

	public void getNextLine() {
		sc.nextLine();
	}

	public int getCustomerId() {
		System.out.println("Enter Customer Id : ");
		return sc.nextInt();
	}

	public String getCustomerName() {
		sc.nextLine();
		System.out.println("Enter Customer Name : ");
		return sc.nextLine();
	}

	public String getCustomerMobile() {
		System.out.println("Enter Mobile Number : ");
		return sc.nextLine();
	}

	public String getCustomerAddress() {
		System.out.println("Enter Customer Address : ");
		return sc.nextLine();
	}

	public Date getDate() {
		return Date.valueOf(LocalDate.now());
	}

//  Products

	public int productMenu() {
		System.out.println("\n----------- Product Menu ------------\n");
		System.out.println("1 Add Product : ");
		System.out.println("2 Remove Product : ");
		System.out.println("3 View Product by Id : ");
		System.out.println("4 View Product by Name : ");
		System.out.println("5 View Product by category : ");
		System.out.println("6 Update Product : ");
		System.out.println("7 Previous Menu : ");

		return sc.nextInt();
	}

	public int getProductId() {
		System.out.println("Enter Product Id : ");
		return sc.nextInt();
	}

	public String getProductName() {
		sc.nextLine();
		System.out.println("Enter Product Name : ");
		return sc.nextLine();
	}

	public double getPrice() {
		System.out.println("Enter Price : ");
		return sc.nextDouble();
	}

	public String getProductCategory() {
		sc.nextLine();
		System.out.println("Enter Product Category : ");
		return sc.nextLine();
	}

// Order

	public int orderMenu() {
		System.out.println("\n----------- Order Menu ------------\n");
		System.out.println("1 Create Order : ");
		System.out.println("2 Add Items to Order : ");
		System.out.println("3 Proceed Order : ");
		System.out.println("4 View Order Details : ");
		System.out.println("5 Update Order Status : ");
		System.out.println("6 Delete Order : ");
		System.out.println("7 Previous Menu : ");

		return sc.nextInt();
	}

	public int getOrderId() {
		System.out.println("Enter Order ID : ");
		return sc.nextInt();
	}

	public String getOrderStatus() {
		sc.nextLine();
		String status = "Pending";
		return status;
	}

	public int getOrderQuantity() {
		System.out.println("Enter Quantity : ");
		return sc.nextInt();
	}

// Payment

	public int paymentMenu() {
		System.out.println("\n----------- Payment Menu ------------\n");
		System.out.println("Enter 1 for Make Payment : ");
		System.out.println("Enter 2 for Payment Receipt : ");
		System.out.println("Enter 3 for Previous Menu : ");

		return sc.nextInt();
	}

	public int getPaymentId() {
		System.out.println("Enter Payment ID : ");
		return sc.nextInt();
	}

	public String getPaymentMethod() {
		sc.nextLine();
		System.out.println("Enter Payment Mode : ");
		return sc.nextLine();
	}

	public double getAmount() {
		System.out.println("Enter Amount : ");
		return sc.nextDouble();
	}

// Report

	public int reportMenu() {
		System.out.println("\n----------- Reports Menu ------------\n");
		System.out.println("1 Customer Report : ");
		System.out.println("2 Product Report : ");
		System.out.println("3 Order Report : ");
		System.out.println("4 Previous Menu : ");

		return sc.nextInt();
	}

// Customer Update Menu

	public int updateCustomer() {
		System.out.println("\n----------- Update Menu ------------\n");
		System.out.println("1 Update Name");
		System.out.println("2 Update Phone");
		System.out.println("3 Update Address");

		return sc.nextInt();
	}

// Product Update Menu

	public int updateProduct() {
		System.out.println("\n----------- Update Menu ------------\n");
		System.out.println("1 Update Name");
		System.out.println("2 Update Price");
		System.out.println("3 Update Category");

		return sc.nextInt();
	}

// New Value for update

	public String newValue() {
		sc.nextLine();
		System.out.println("Enter New Value : ");

		return sc.nextLine();
	}
}
