package Library.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Library {
	private int bookId;
	private String bookTitle;
	private String authorName;
	private Date issueDate;
	private String status;
	private int available_Books;

	public Library(String bookTitle, String authorName, Date issueDate, String status, int available_Books) {
		super();
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.issueDate = issueDate;
		this.status = status;
		this.available_Books = available_Books;
	}

	public Library(int bookId, String bookTitle, String authorName, Date issueDate,int available_Books, String status) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.issueDate = issueDate;
		this.available_Books = available_Books;
		this.status = status;
	}

}
