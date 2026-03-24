package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private int bookId;
	private String title;
	private String author;
	private int total_copies;
	private int available_copies;

	public Book(String title, String author, int total_copies) {
		super();
		this.title = title;
		this.author = author;
		this.total_copies = total_copies;
	}

}
