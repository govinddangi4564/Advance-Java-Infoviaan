package controller;

import java.util.List;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Customer;
import model.Order;
import model.Product;
import view.MainMenu;

public class ReportController {

	public MainMenu view;

	CustomerDAO cd = new CustomerDAO();
	ProductDAO pd = new ProductDAO();
	OrderDAO od = new OrderDAO();

	public ReportController(MainMenu view) {
		super();
		this.view = view;
	}

	public void reportRun() {

		while (true) {

			int choice = view.reportMenu();
			switch (choice) {

			case 1: {
				List<Customer> customersReport = cd.customerReport();
				System.out.println("\n----------------------------------------------------------------------------");
				System.out.printf("%-5s %-15s %-15s %-20s %-12s\n", "ID", "Name", "Phone", "Address", "Created Date");
				System.out.println("------------------------------------------------------------------------------");

				for (Customer c : customersReport) {
					System.out.printf("%-5d %-15s %-15s %-20s %-12s\n", c.getCustomerId(), c.getCustomerName(),
							c.getCustomerNumber(), c.getCustomerAddress(), c.getCustomerCreatedDate());
				}
				System.out.println("\nTotal Customers : " + customersReport.size());
				System.out.println();

			}
				break;

			case 2: {
				List<Product> productsReport = pd.productReport();
				System.out.println("\n---------------------------------------------------------------------");
				System.out.printf("%-5s %-15s %-15s %-8s %-20s %-12s\n", "ID", "Product Name", "Price", "Stock",
						"Category", "Created Date");
				System.out.println("-----------------------------------------------------------------------");

				for (Product p : productsReport) {
					System.out.printf("%-5s %-15s %-15s %-8s %-20s %-12s\n", p.getProductId(), p.getProductName(),
							p.getProductPrice(), p.getProductStock(), p.getProductCategory(),
							p.getProductCreatedDate());
				}
				System.out.println("\nTotal Products : " + productsReport.size());
				System.out.println();
			}
				break;

			case 3: {
				List<Order> ordersReport = od.orderReport();
				ordersReport.forEach(System.out::println);
				System.out.println();
			}
				break;

			case 4:
				return;

			default:
				System.out.println("Invalid choice.");
				return;
			}
		}
	}
}
