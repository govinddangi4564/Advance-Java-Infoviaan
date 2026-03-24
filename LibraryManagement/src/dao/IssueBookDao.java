package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DBConnection.DBConnection;
import model.IssueBook;

public class IssueBookDao {

	public int issueBook(IssueBook ib) {
		int i = 0;
		int j = 0;
		int result = 0;

		try {
			Connection con = DBConnection.getConnection();
			con.setAutoCommit(false);

			PreparedStatement pst = con.prepareStatement("select available_copies from books where book_id = ?");
			pst.setInt(1, ib.getBookId());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				int Copies = rs.getInt("available_copies");

				if (Copies > 0) {
					PreparedStatement pst1 = con.prepareStatement(
							"insert into issue_books (student_id, book_id, issue_date, due_date, status) values(?,?,?,?,?)");
					pst1.setInt(1, ib.getStudentId());
					pst1.setInt(2, ib.getBookId());
					pst1.setDate(3, ib.getIssueDate());
					pst1.setDate(4, ib.getDueDate());
					pst1.setString(5, "Issued");

					i = pst1.executeUpdate();

					PreparedStatement pst2 = con.prepareStatement(
							"update books set available_copies = available_copies - 1 where book_id = ?");
					pst2.setInt(1, ib.getBookId());

					j = pst2.executeUpdate();

					if (i > 0 && j > 0) {
						con.commit();
						result = 1;
					} else {
						con.rollback();
					}

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

// Return book
	public int returnBook(int issueId, int bookId, Date returnDate) {
		int i = 0;
		int j = 0;
		int result = 0;

		try {
			Connection con = DBConnection.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pst = con
					.prepareStatement("update issue_books set status = 'Returned', return_date = ? where issue_id = ? and status = 'Issued'");
			pst.setDate(1, returnDate);
			pst.setInt(2, issueId);

			i = pst.executeUpdate();

			PreparedStatement pst1 = con
					.prepareStatement("update books set available_copies = available_copies + 1 where book_id = ?");
			pst1.setInt(1, bookId);

			j = pst1.executeUpdate();

			if (i > 0 && j > 0) {
				con.commit();
				result = 1;
			} else {
				con.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

// View issue books
	public List<IssueBook> viewIssueBooks() {
		List<IssueBook> list = new LinkedList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"SELECT i.issue_id, i.issue_date, i.due_date, i.status,b.title, b.author, s.name, s.phone FROM issue_books i LEFT JOIN books b ON i.book_id = b.book_id INNER JOIN students s ON i.student_id = s.student_id WHERE i.status = 'Issued'");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int issueId = rs.getInt("issue_id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date issueDate = rs.getDate("issue_date");
				Date dueDate = rs.getDate("due_date");
				String phone = rs.getString("phone");
				String status = rs.getString("status");

				list.add(new IssueBook(issueId, issueDate, dueDate, status, name, title, author, phone));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// View issue books
	public List<IssueBook> viewIssueRecords() {
		List<IssueBook> list = new LinkedList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"SELECT i.issue_id, i.issue_date, i.due_date, i.return_date, i.status,b.title, b.author, s.name, s.phone FROM issue_books i LEFT JOIN books b ON i.book_id = b.book_id INNER JOIN students s ON i.student_id = s.student_id");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int issueId = rs.getInt("issue_id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date issueDate = rs.getDate("issue_date");
				Date dueDate = rs.getDate("due_date");
				Date returnDate = rs.getDate("return_date");
				String phone = rs.getString("phone");
				String status = rs.getString("status");

				list.add(new IssueBook(issueId, issueDate, dueDate, returnDate, status, name, title, author, phone));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
