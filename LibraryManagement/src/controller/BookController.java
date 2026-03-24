package controller;

import java.util.List;

import dao.BookDao;
import model.Book;
import view.MainView;

public class BookController {
	public MainView view;
	public BookDao dao;

	public BookController(MainView view, BookDao dao) {
		super();
		this.view = view;
		this.dao = dao;
	}

	public void run() {
		while (true) {
			int choice = view.bookMenu();
			switch (choice) {

			case 1: {
				String title = view.getBookTitle();
				String author = view.getBookAuthor();
				int tc = view.getTotalCopies();

				Book b = new Book(title, author, tc);

				int i = dao.insert(b);

				if (i != 0) {
					System.out.println("Books Successfully Added.");
				} else {
					System.out.println("Something went wrong.");
				}
			}
				break;

			case 2: {
				String title = view.getBookTitle();
				String author = view.getBookAuthor();

				int i = dao.delete(title, author);

				if (i != 0) {
					System.out.println("Book Successfully Deleted.");
				} else {
					System.out.println("Something went wrong.");
				}
			}
				break;

			case 3: {
				List<Book> list = dao.viewAllBooks();

				System.out
						.println("\n---------------------------------------------------------------------------------");
				System.out.printf("%-5s %-18s %-18s %-18s %-18s\n", "Id", "Title", "Author", "Total_copies",
						"Available_copies");
				System.out.println("---------------------------------------------------------------------------------");

				for (Book b : list) {
					System.out.printf("%-5s %-18s %-18s %-18s %-18s\n", b.getBookId(), b.getTitle(), b.getAuthor(),
							b.getTotal_copies(), b.getAvailable_copies());
				}
			}
				break;

			case 4: {
				String title = view.getBookTitle();

				List<Book> list = dao.searchBook(title);

				System.out
						.println("\n---------------------------------------------------------------------------------");
				System.out.printf("%-5s %-18s %-18s %-18s %-18s\n", "Id", "Title", "Author", "Total_copies",
						"Available_copies");
				System.out.println("---------------------------------------------------------------------------------");

				for (Book b : list) {
					System.out.printf("%-5s %-18s %-18s %-18s %-18s\n", b.getBookId(), b.getTitle(), b.getAuthor(),
							b.getTotal_copies(), b.getAvailable_copies());
				}
			}
				break;

			case 5: {
				String title = view.getBookTitle();
				String author = view.getBookAuthor();
				int ac = view.getTotalCopies();

				int i = dao.update(new Book(title, author, ac));

				if (i != 0) {
					System.out.println("Book Successfully Updated.");
				} else {
					System.out.println("Something went wrong.");
				}
			}
				break;

			case 6: {
				List<Book> list = dao.searchAvailableBooks();

				System.out
						.println("\n---------------------------------------------------------------------------------");
				System.out.printf("%-5s %-18s %-18s %-18s %-18s\n", "Id", "Title", "Author", "Total_copies",
						"Available_copies");
				System.out.println("---------------------------------------------------------------------------------");

				for (Book b : list) {
					System.out.printf("%-5s %-18s %-18s %-18s %-18s\n", b.getBookId(), b.getTitle(), b.getAuthor(),
							b.getTotal_copies(), b.getAvailable_copies());
				}
			}
				break;

			case 7:
				System.out.println("Exit.");
				return;

			default:
				System.out.println("Invalid Choice.");
				break;
			}
		}
	}
}
