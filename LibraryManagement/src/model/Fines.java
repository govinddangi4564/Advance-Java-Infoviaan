package model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fines {
	private int FineId;
	private int IssueId;
	private double amount;

	private String name;
	private String phone;
	private String title;
	private String author;
	private Date dueDate;
	private Date returnDate;
	private int fine;

	public Fines(double amount, String name, String phone, String title, String author, Date dueDate, Date returnDate) {
		super();
		this.amount = amount;
		this.name = name;
		this.phone = phone;
		this.title = title;
		this.author = author;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
	}

	public Fines(String name, String phone, String title, String author, Date dueDate, Date returnDate, int fine) {
		super();
		this.name = name;
		this.phone = phone;
		this.title = title;
		this.author = author;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}

}
