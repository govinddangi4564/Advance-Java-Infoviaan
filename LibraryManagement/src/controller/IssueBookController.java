package controller;

import java.sql.Date;
import java.util.List;

import dao.IssueBookDao;
import model.IssueBook;
import view.MainView;

public class IssueBookController {
	public MainView view;
	public IssueBookDao dao;

	public IssueBookController(MainView view, IssueBookDao dao) {
		super();
		this.view = view;
		this.dao = dao;
	}

	public void run() {
		while (true) {
			int choice = view.issue_booksMenu();

			switch (choice) {

			case 1: {
				int stdId = view.getStudentId();
				int bookId = view.getBookId();
				Date issueDate = view.getCurrentDate();
				Date dueDate = view.getDueDate();

				IssueBook ib = new IssueBook(stdId, bookId, issueDate, dueDate);

				int i = dao.issueBook(ib);

				if (i != 0) {
					System.out.println("Books Successfully Issued.");
				} else {
					System.out.println("Something went wrong.");
				}
			}
				break;

			case 2: {
				int issueId = view.getIssueId();
				int bookId = view.getBookId();
				Date returnDate = view.getCurrentDate();

				int i = dao.returnBook(issueId, bookId, returnDate);

				if (i != 0) {
					System.out.println("Books Successfully Returned.");
				} else {
					System.out.println("Something went wrong.");
				}
			}
				break;

			case 3: {
				List<IssueBook> list = dao.viewIssueBooks();

				System.out.println(
						"\n-------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-5s %-12s %-12s %-14s %-18s %-16s %-15s %-15s\n", "Id", "Name", "Title", "Author",
						"Issue Date", "Due Date", "Phone", "Status");
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------");

				for (IssueBook b : list) {
					System.out.printf("%-5s %-12s %-12s %-14s %-18s %-16s %-15s %-15s\n", b.getIssueId(), b.getName(),
							b.getTitle(), b.getAuthor(), b.getIssueDate(), b.getDueDate(), b.getPhone(), b.getStatus());
				}
			}
				break;

			case 4: {
				List<IssueBook> list = dao.viewIssueRecords();

				System.out.println(
						"\n----------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-5s %-12s %-12s %-14s %-18s %-16s %-17s %-15s %-15s\n", "Id", "Name", "Title",
						"Author", "Issue Date", "Due Date", "Return Date", "Phone", "Status");
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------");

				for (IssueBook b : list) {
					System.out.printf("%-5s %-12s %-12s %-14s %-18s %-16s %-17s %-15s %-15s\n", b.getIssueId(),
							b.getName(), b.getTitle(), b.getAuthor(), b.getIssueDate(), b.getDueDate(),
							b.getReturnDate(), b.getPhone(), b.getStatus());
				}
			}
				break;

			case 5:
				System.out.println("Exit.");
				return;

			default:
				System.out.println("Invalid Choice.");
				break;
			}
		}
	}

}
