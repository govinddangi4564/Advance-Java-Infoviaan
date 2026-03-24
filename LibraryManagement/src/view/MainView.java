package view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class MainView {
	private Scanner sc = new Scanner(System.in);

	public int MainMenu() {
		System.out.println("1. Book : ");
		System.out.println("2. Student : ");
		System.out.println("3. Issue Book : ");
		System.out.println("4. Fines : ");
		System.out.println("5. Exit.");

		return sc.nextInt();
	}

	public int bookMenu() {
		System.out.println("\n1. Add Book : ");
		System.out.println("2. Delete Book : ");
		System.out.println("3. View All Books : ");
		System.out.println("4. Search Book : ");
		System.out.println("5. Update Book : ");
		System.out.println("6. Show Available Books : ");
		System.out.println("7. Previous Section  : ");

		return sc.nextInt();
	}

	public int studentMenu() {
		System.out.println("\n1. Register Student : ");
		System.out.println("2. View Students : ");
		System.out.println("3. Search Student : ");
		System.out.println("4. Update Student : ");
		System.out.println("5. Delete Student : ");
		System.out.println("6. Exit : ");

		return sc.nextInt();
	}

	public int issue_booksMenu() {
		System.out.println("\n1. Issue Book : ");
		System.out.println("2. Return Book : ");
		System.out.println("3. View Issued Books : ");
		System.out.println("4. View All Records : ");
		System.out.println("5. Exit : ");

		return sc.nextInt();
	}

	public int finesMenu() {
		System.out.println("\n1. Add Fine : ");
		System.out.println("2. View All Fines : ");
		System.out.println("3. View Fine Details : ");
		System.out.println("4. Exit : ");

		return sc.nextInt();
	}
	
	public int getIssueId() {
		System.out.println("Enter Issue Id : ");
		return sc.nextInt();
	}

	public int getBookId() {
		System.out.println("Enter Book Id : ");
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

	public int getTotalCopies() {
		System.out.println("Total Books : ");
		return sc.nextInt();
	}

	public int getStudentId() {
		System.out.println("Enter Student Id : ");
		return sc.nextInt();
	}

	public String getStudentName() {
		sc.nextLine();
		System.out.println("Enter Student Name : ");
		return sc.nextLine();
	}

	public String getStudentEmail() {
		System.out.println("Enter Student Email Id : ");
		return sc.nextLine();
	}

	public String getStudentPhone() {
		System.out.println("Enter Student Phone Number : ");
		return sc.nextLine();
	}

	public void getNextLine() {
		sc.nextLine();
	}

	public Date getCurrentDate() {
	    return Date.valueOf(LocalDate.now());
	}

	public Date getDueDate() {
	    LocalDate due = LocalDate.now().plusDays(7);
	    return Date.valueOf(due);
	}
	
	

}
