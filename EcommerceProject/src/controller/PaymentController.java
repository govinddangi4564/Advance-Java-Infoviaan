package controller;

import java.sql.Date;
import java.util.List;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.PaymentDAO;
import dao.ProductDAO;
import model.Customer;
import model.Order;
import model.OrderItem;
import model.Payment;
import view.MainMenu;

public class PaymentController {
	public MainMenu view;
	public PaymentDAO payDao;

	OrderDAO odrDao = new OrderDAO();
	CustomerDAO custDao = new CustomerDAO();
	ProductDAO proDao = new ProductDAO();

	public PaymentController(MainMenu view, PaymentDAO payDao) {
		this.view = view;
		this.payDao = payDao;
	}

	public void payRun() {
		while (true) {
			int choice = view.paymentMenu();

			switch (choice) {

			case 1: {
				int odrId = view.getOrderId();
				boolean order = payDao.orderExists(odrId);
				String payStatus = payDao.StatusExists(odrId);

				if (!order) {
					System.out.println("Order Not Found.. Please place an order");
				} else if (order && (payStatus.equalsIgnoreCase("PAID") || payStatus.equalsIgnoreCase("Complete"))) {
					System.out.println("Order is already Placed.");
				} else {
					if (payDao.getTotal(odrId) == 0.00) {
						System.out.println("Please add Items then proceed order.");
					}
//					else if (order
//							&& !(payStatus.equalsIgnoreCase("PAID") || payStatus.equalsIgnoreCase("Complete"))) {
//						String mode = view.getPaymentMethod();
//						Date dt = view.getDate();
//						double amt = payDao.getTotal(odrId);
//						String sts = "PAID";
//
//						Payment payment = new Payment(odrId, amt, mode, dt, sts);
//
//						int i = payDao.updatePayment(payment);
//						System.out.println(i != 0 ? "Payment Success" : "Something went wrong");
//					}

					else {
						String mode = view.getPaymentMethod();
						Date dt = view.getDate();
						double amt = payDao.getTotal(odrId);
						String sts = "PAID";

						Payment payment = new Payment(odrId, amt, mode, dt, sts);
						int i = payDao.makePayment(payment);

						System.out.println(i != 0 ? "Payment Success" : "Something went wrong");
					}
				}
			}
				break;

			case 2: {

				// Order Details

				int odrId = view.getOrderId();
				int custId = custDao.custId(odrId);
				int proId = odrDao.proId(odrId);

				List<Order> odrReceipt = odrDao.orderReport(odrId);
				List<Customer> custList = custDao.viewCustomer(custId);
				List<OrderItem> itemList = odrDao.orderItem(odrId);
				String productName = proDao.productName(proId);
				List<Payment> receipt = payDao.paymentReceipt(odrId);

				System.out.println("\n___________________  Receipt _______________________\n");

				for (Order o : odrReceipt) {
					System.out.println("Order Id   : " + o.getOrderId());
					System.out.println("Order Date : " + o.getOrderDate());
				}
				for (Customer c : custList) {
					System.out.println("Customer   : " + c.getCustomerName());
					System.out.println("Address    : " + c.getCustomerAddress());
					System.out.println("Number     : " + c.getCustomerNumber());
				}

				System.out.println("\n-----------------------------------------------------------");
				System.out.printf("%-20s %-10s %-15s %-12s\n", "Product Name", "Quantity", "Price", "Subtotal");
				System.out.println("-------------------------------------------------------------");

				double total = 0;
				for (OrderItem o : itemList) {
					double subtotal = o.getOrderItemPrice() * o.getOrderItemQuantity();
					System.out.printf("%-20s %-10s %-15s %-12s\n", productName, o.getOrderItemQuantity(),
							o.getOrderItemPrice(), subtotal);
					System.out.println("----------------------------------------------------------");
					total = total + subtotal;
				}
				System.out.println("Total Amount : " + total);
				System.out.println();

				for (Payment p : receipt) {
					System.out.println("Payment Method  : " + p.getPaymentMethod());
					System.out.println("Payment Status  : " + p.getPaymentStatus());
					System.out.println("Payment Date    : " + p.getPaymentDate());
				}
				System.out.println();
				System.out.println("Thankyou for shopping!");
			}
				break;

			case 3:
				System.out.println("Exit.");
				return;
				
			default:
				System.out.println("Exit.");
				return;
			}
		}
	}
}
