package controller;

import java.sql.Date;
import java.util.List;

import dao.CustomerDAO;
import model.Customer;
import view.MainMenu;

public class CustomerController {
	public MainMenu view;
	public CustomerDAO custDao;

	public CustomerController(MainMenu view, CustomerDAO custDao) {
		super();
		this.view = view;
		this.custDao = custDao;
	}

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}

	public void custRun() {

		while (true) {

			int customerChoice = view.customerMenu();

			switch (customerChoice) {

			case 1: {
				String name = view.getCustomerName();
				String phNo = view.getCustomerMobile();
				String add = view.getCustomerAddress();
				Date dt = view.getDate();

				Customer cust = new Customer(name, phNo, add, dt);

				int custId = custDao.addCustomer(cust);
				System.out.println(custId != 0 ? "Success" : "Something went wrong.");
				System.out.println("Your Customer Id : " + custId);
			}
				break;

			case 2: {
				int id = view.getCustomerId();
				int i = custDao.removeCustomer(id);
				System.out.println(i != 0 ? "Success" : "Something went Wrong.");
			}
				break;

			case 3: {
				int id = view.getCustomerId();

				List<Customer> custList = custDao.viewCustomer(id);
				System.out.println("\n----------------------------------------------------------------------------");
				System.out.printf("%-5s %-15s %-15s %-20s %-12s\n", "ID", "Name", "Phone", "Address", "Created Date");
				System.out.println("------------------------------------------------------------------------------");

				for (Customer c : custList) {
					System.out.printf("%-5d %-15s %-15s %-20s %-12s\n", c.getCustomerId(), c.getCustomerName(),
							c.getCustomerNumber(), c.getCustomerAddress(), c.getCustomerCreatedDate());
				}
				System.out.println("\nTotal Customers : " + custList.size());
			}
				break;
			case 4: {

				String name = view.getCustomerName();

				List<Customer> custList = custDao.viewCustomer(name);
				System.out.println("\n----------------------------------------------------------------------------");
				System.out.printf("%-5s %-15s %-15s %-20s %-12s\n", "ID", "Name", "Phone", "Address", "Created Date");
				System.out.println("------------------------------------------------------------------------------");

				for (Customer c : custList) {
					System.out.printf("%-5d %-15s %-15s %-20s %-12s\n", c.getCustomerId(), c.getCustomerName(),
							c.getCustomerNumber(), c.getCustomerAddress(), c.getCustomerCreatedDate());
				}
				System.out.println("\nTotal Customers : " + custList.size());
			}
				break;

			case 5: {
				int id = view.getCustomerId();
				int choice = view.updateCustomer();
				String value = view.newValue();

				int i = custDao.updateCustomer(id, choice, value);

				System.out.println(i != 0 ? "Success" : "Something Went Wrong.");
			}
				break;

			case 6:
				System.out.println("Exit..");
				return;

			default:
				System.out.println("Invalid choice.");
				return;

			}
		}
	}
}
