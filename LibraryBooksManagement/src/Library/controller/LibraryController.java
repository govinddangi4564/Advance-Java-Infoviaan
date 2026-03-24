package Library.controller;

import java.sql.Date;
import java.util.List;

import Library.model.Library;
import Library.model.LibraryDao;
import Library.view.LibraryView;

public class LibraryController {
	public LibraryView view;
	public LibraryDao dao;

	public LibraryController(LibraryView view, LibraryDao dao) {
		super();
		this.view = view;
		this.dao = dao;
	}

	public void run() {

		while (true) {
			int choice = view.LibraryMenu();

			switch (choice) {

			case 1: {

				String title = view.getBookTitle();
				String author = view.getBookAuthor();
				Date issueDate = view.getDate();
				String status = view.getBookStatus();
				int avlBook = view.getAvailableBooks();

				Library lib = new Library(title, author, issueDate, status, avlBook);

				int id = dao.addBook(lib);

				System.out.println(id != 0 ? "Success" : "Something went wrong.");

				if (id != 0) {
					System.out.println("Your Book ID : " + id);
				}
			}
				break;

			case 2: {
				String name = view.getBookTitle();

				int i = dao.issueBook(name);

				if (i != 0) {
					System.out.println("Book Issued Successfully");
				} else {
					System.out.println("Book Not Available");
				}
			}
				break;

			case 3: {
				String name = view.getBookTitle();

				int i = dao.returnBook(name);

				if (i != 0) {
					System.out.println("Book Returned Successfully");
				} else {
					System.out.println("Book Not Returned");
				}
			}
				break;

			case 4: {
				String title = view.getBookTitle();

				List<Library> list = dao.findBook(title);
				System.out.println("\n---------------------------------------------------------------------------------");
				System.out.printf("%-5s %-15s %-20s %-18s %-10s %-15s\n", "Id", "Title", "Author", "Publish_Date",
						"Total_Books", "Status");
				System.out.println("---------------------------------------------------------------------------------");

				for (Library lib : list) {
					System.out.printf("%-5s %-15s %-20s %-18s %-10s %-15s", lib.getBookId(), lib.getBookTitle(),
							lib.getAuthorName(), lib.getIssueDate(), lib.getAvailable_Books(), lib.getStatus());
				}
			}
				break;

			case 5: {
				List<Library> list = dao.listAvailable();
				
				System.out.println("\n---------------------------------------------------------------------------------");
				System.out.printf("%-5s %-15s %-20s %-18s %-10s %-15s\n", "Id", "Title", "Author", "Publish_Date",
						"Total_Books", "Status");
				System.out.println("---------------------------------------------------------------------------------");

				for (Library lib : list) {
					System.out.printf("%-5s %-15s %-20s %-18s %-10s %-15s\n", lib.getBookId(), lib.getBookTitle(),
							lib.getAuthorName(), lib.getIssueDate(), lib.getAvailable_Books(), lib.getStatus());
				}
			}
				break;

			case 6:
				System.out.println("Exit.");
				return;

			default:
				System.out.println("Exit.");
				return;
			}
		}
	}

}
