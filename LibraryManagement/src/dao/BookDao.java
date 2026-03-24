package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DBConnection.DBConnection;
import model.Book;

public class BookDao {

	public int insert(Book b) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();

// update total books if already book available
			PreparedStatement pst1 = con.prepareStatement(
					"select book_id, total_copies, available_copies from books where title = ? and author = ?");
			pst1.setString(1, b.getTitle());
			pst1.setString(2, b.getAuthor());

			ResultSet rs1 = pst1.executeQuery();
			if (rs1.next()) {
				int existingId = rs1.getInt("book_id");
				int tc = rs1.getInt("total_copies");
				int ac = rs1.getInt("available_copies");

				PreparedStatement pst2 = con
						.prepareStatement("update books set total_copies = ?, available_copies = ? where book_id = ?");
				pst2.setInt(1, tc + b.getTotal_copies());
				pst2.setInt(2, ac + b.getTotal_copies());
				pst2.setInt(3, existingId);

				pst2.executeUpdate();

				return existingId;

			} else {
// insert book if not available
				PreparedStatement pst = con.prepareStatement(
						"insert into books (title, author, total_copies, available_copies) values(?,?,?,?)");
				pst.setString(1, b.getTitle());
				pst.setString(2, b.getAuthor());
				pst.setInt(3, b.getTotal_copies());
				pst.setInt(4, b.getTotal_copies());

				i = pst.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// Delete book
	public int delete(String title, String author) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("delete from books where title = ? and author = ?");
			pst.setString(1, title);
			pst.setString(2, author);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// View all books
	public List<Book> viewAllBooks() {
		List<Book> list = new LinkedList<Book>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from books");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int tc = rs.getInt("total_copies");
				int ac = rs.getInt("available_copies");

				list.add(new Book(id, title, author, tc, ac));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// Search Book 
	public List<Book> searchBook(String title) {
		List<Book> list = new LinkedList<Book>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from books where title = ?");
			pst.setString(1, title);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("book_id");
				String author = rs.getString("author");
				int tc = rs.getInt("total_copies");
				int ac = rs.getInt("available_copies");

				list.add(new Book(id, title, author, tc, ac));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// Update book
	public int update(Book b) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"update books set total_copies = total_copies + ?, available_copies = available_copies + ? where title = ? and author = ?");
			pst.setInt(1, b.getTotal_copies());
			pst.setInt(2, b.getTotal_copies());
			pst.setString(3, b.getTitle());
			pst.setString(4, b.getAuthor());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	// View all books
	public List<Book> searchAvailableBooks() {
		List<Book> list = new LinkedList<Book>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from books where available_copies > 0");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int tc = rs.getInt("total_copies");
				int ac = rs.getInt("available_copies");

				list.add(new Book(id, title, author, tc, ac));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
