package Library.view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class LibraryView {
	private Scanner sc = new Scanner(System.in);

	public int LibraryMenu() {
		System.out.println("\n1 Add Book : ");
		System.out.println("2 Issue Book : ");
		System.out.println("3 Return Book : ");
		System.out.println("4 Find Book by title : ");
		System.out.println("5 List Available Books : ");
		System.out.println("6 Exit.");

		return sc.nextInt();
	}

	public String getBookTitle() {
		sc.nextLine();
		System.out.println("Enter Book title : ");
		return sc.nextLine();
	}

	public String getBookAuthor() {
		System.out.println("Enter Author Name : ");
		return sc.nextLine();
	}

	public Date getDate() {
		return Date.valueOf(LocalDate.now());
	}

	public String getBookStatus() {
		String status = "Available";
		return status;
	}
	
	public int getAvailableBooks() {
		System.out.println("Total Books : ");
		return sc.nextInt();
	}
}
