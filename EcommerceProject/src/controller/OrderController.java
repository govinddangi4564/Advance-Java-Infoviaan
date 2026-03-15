package controller;

import java.sql.Date;
import java.util.List;

import dao.OrderDAO;
import model.Customer;
import model.Order;
import model.OrderItem;
import view.MainMenu;

public class OrderController {

	public MainMenu view;
	public OrderDAO odrDao;
	public OrderItem odrItm;

	public OrderController(MainMenu view, OrderDAO odrDao) {
		this.view = view;
		this.odrDao = odrDao;
	}

	public double calculateAmount(int quantity, double price) {
		double total = quantity * price;
		return total;
	}

	public void odrRun() {

		while (true) {

			int odrChoice = view.orderMenu();

			switch (odrChoice) {

			case 1: {
				int custId = view.getCustomerId();
				Date dt = view.getDate();
				String sts = view.getOrderStatus();

				Order ord = new Order(custId, 0, dt, sts);

				int i = odrDao.createOrder(ord);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
				System.out.println("Your order Id : ");
			}
				break;

			case 2: {
				int odrId = view.getOrderId();
				int proId = view.getProductId();
				int quantity = view.getOrderQuantity();
				double price = odrDao.productPrice(proId);

				double subtotal = calculateAmount(quantity, price);

				OrderItem item = new OrderItem(odrId, proId, quantity, price);

				int i = odrDao.addItems(item);
				System.out.println("Subtotal = " + subtotal);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 3: {
				int id = view.getOrderId();
				double amt = odrDao.totalAmount(id);

				int i = odrDao.proceedOrder(id, amt);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 4: {
				int id = view.getOrderId();

				List<Order> list = odrDao.orderDetails(id);
				System.out
						.println("\n--------------------------------------------------------------------------------");
				System.out.printf("%-11s %-15s %-15s %-15s %-12s\n", "Order Id", "Customer Id", "Total Amount",
						"Order Date", "Status");
				System.out
						.println("----------------------------------------------------------------------------------");

				for (Order o : list) {
					System.out.printf("%-11d %-15s %-15s %-15s %-8s\n", o.getOrderId(), o.getCustomerId(),
							o.getOrderAmount(), o.getOrderDate(), o.getOrderStatus());
				}
			}
				break;

			case 5: {
				System.out.println("Please complete Payment..");
			}
				break;

			case 6: {
				int id = view.getOrderId();
				int i = odrDao.deleteOrder(id);
				System.out.println(i != 0 ? "Success" : "Something Wnt Wrong");
			}
				break;

			case 7: {
				System.out.println("Exit.");
			}
				break;

			default:
				System.out.println("Invalid choice.");
				return;
			}
		}
	}

}
