package model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueBook {
	private int issueId;
	private int StudentId;
	private int bookId;
	private Date issueDate;
	private Date dueDate;
	private Date returnDate;
	private String status;

	private String name;
	private String title;
	private String author;
	private String phone;

	public IssueBook(int studentId, int bookId, Date issueDate, Date dueDate) {
		super();
		StudentId = studentId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
	}

	public IssueBook(int issueId, Date issueDate, Date dueDate, String status, String name, String title, String author,
			String phone) {
		super();
		this.issueId = issueId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.status = status;
		this.name = name;
		this.title = title;
		this.author = author;
		this.phone = phone;
	}

	public IssueBook(int issueId, Date issueDate, Date dueDate, Date returnDate, String status, String name,
			String title, String author, String phone) {
		super();
		this.issueId = issueId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.status = status;
		this.name = name;
		this.title = title;
		this.author = author;
		this.phone = phone;
	}

}
