package controller;

import java.sql.Date;
import java.util.List;

import dao.ProductDAO;
import model.Customer;
import model.Product;
import view.MainMenu;

public class ProductController {
	public MainMenu view;
	public ProductDAO proDao;
//	public Product pro = new Product();

	public ProductController(MainMenu view, ProductDAO proDao) {
		super();
		this.view = view;
		this.proDao = proDao;
	}

	public void proRun() {
		while (true) {
			int proChoice = view.productMenu();

			switch (proChoice) {

			case 1: {
				String name = view.getProductName();
				double price = view.getAmount();
				int stock = view.getOrderQuantity();
				String cat = view.getProductCategory();
				Date dt = view.getDate();

				Product pro = new Product(name, price, stock, cat, dt);

				int proId = proDao.addProduct(pro);
				System.out.println(proId != 0 ? "Success" : "Something went wrong.");
				System.out.println("Your Product id : " + proId);
			}
				break;

			case 2: {
			    int id = view.getProductId();
			    int stock = proDao.getStock(id);

			    System.out.println("Total Available Stock : " + stock);

			    int choice = view.getOrderQuantity();

			    if (choice > stock) {
			        System.out.println("Not enough stock available!");
			        break;
			    }

			    int i = proDao.removeProduct(id, choice);

			    System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 3: {
				int id = view.getProductId();

				List<Product> productList = proDao.viewProduct(id);
				System.out.println("\n----------------------------------------------------------------------------");
				System.out.printf("%-5s %-15s %-15s %-8s %-20s %-12s\n", "ID", "Product Name", "Price", "Stock",
						"Category", "Created Date");
				System.out.println("-------------------------------------------------------------------------------");

				for (Product p : productList) {
					System.out.printf("%-5s %-15s %-15s %-8s %-20s %-12s\n", p.getProductId(), p.getProductName(),
							p.getProductPrice(), p.getProductStock(), p.getProductCategory(),
							p.getProductCreatedDate());
				}
			}
				break;

			case 4: {
				String name = view.getProductName();

				List<Product> productList = proDao.viewProduct(name);
				System.out.println("\n---------------------------------------------------------------------");
				System.out.printf("%-5s %-15s %-15s %-8s %-20s %-12s\n", "ID", "Product Name", "Price", "Stock",
						"Category", "Created Date");
				System.out.println("-----------------------------------------------------------------------");

				for (Product p : productList) {
					System.out.printf("%-5s %-15s %-15s %-8s %-20s %-12s\n", p.getProductId(), p.getProductName(),
							p.getProductPrice(), p.getProductStock(), p.getProductCategory(),
							p.getProductCreatedDate());
				}
				System.out.println("\nTotal Products : " + productList.size());
				System.out.println();
			}
				break;

			case 5: {

				String cate = view.getProductCategory();

				List<Product> productList = proDao.viewProductCategory(cate);
				System.out.println("\n----------------------------------------------------------------------------");
				System.out.printf("%-5s %-15s %-15s %-8s %-20s %-12s\n", "ID", "Product Name", "Price", "Stock",
						"Category", "Created Date");
				System.out.println("-------------------------------------------------------------------------------");

				for (Product p : productList) {
					System.out.printf("%-5s %-15s %-15s %-8s %-20s %-12s\n", p.getProductId(), p.getProductName(),
							p.getProductPrice(), p.getProductStock(), p.getProductCategory(),
							p.getProductCreatedDate());
				}
				System.out.println("\nTotal Products : " + productList.size());
				System.out.println();

			}
				break;

			case 6: {
				int id = view.getProductId();
				int choice = view.updateProduct();
				String value = view.newValue();

				int i = proDao.update(id, choice, value);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 7:
				System.out.println("Exit..");
				return;

			default:
				System.out.println("Invalid choice.");
				return;
			}
		}
	}

}
