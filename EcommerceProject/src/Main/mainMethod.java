package Main;

import controller.CustomerController;
import controller.OrderController;
import controller.PaymentController;
import controller.ProductController;
import controller.ReportController;
import dao.CustomerDAO;
import dao.OrderDAO;
import dao.PaymentDAO;
import dao.ProductDAO;
import view.MainMenu;

public class mainMethod {
	public static void main(String[] args) {

		MainMenu view = new MainMenu();
		CustomerDAO custDao = new CustomerDAO();
		ProductDAO proDao = new ProductDAO();
		OrderDAO odrDao = new OrderDAO();
		PaymentDAO payDao = new PaymentDAO();

		CustomerController custController = new CustomerController(view, custDao);
		ProductController proController = new ProductController(view, proDao);
		OrderController odrController = new OrderController(view, odrDao);
		ReportController reportController = new ReportController(view);
		PaymentController payController = new PaymentController(view, payDao);

		while (true) {

			int choice = view.showMenu();

			switch (choice) {

			case 1:
				custController.custRun();
				break;

			case 2:
				proController.proRun();
				break;

			case 3:
				odrController.odrRun();
				break;

			case 4:
				payController.payRun();
				break;

			case 5:
				reportController.reportRun();
				break;

			case 6:
				System.out.println("Exiting...");
				return;

			default:
				System.out.println("Invalid choice");
				return;
			}
		}

	}
}
