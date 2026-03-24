package Library.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LibraryDao {
	private static final String URL = "jdbc:mysql://localhost:3306/infoviaan";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Govind";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// Add books

	public int addBook(Library lib) {

		int id = 0;

		try {
			Connection con = getConnection();

			// check book already available or not
			PreparedStatement pst1 = con.prepareStatement(
					"select id, available_books from libraryManagement where title = ? and author = ?");
			pst1.setString(1, lib.getBookTitle());
			pst1.setString(2, lib.getAuthorName());

			ResultSet rs1 = pst1.executeQuery();

			if (rs1.next()) {
				int existingId = rs1.getInt("id");
				int currentBookCount = rs1.getInt("available_books");

				PreparedStatement pst2 = con
						.prepareStatement("update libraryManagement set available_books = ? where id = ?");
				pst2.setInt(1, currentBookCount + lib.getAvailable_Books());
				pst2.setInt(2, existingId);

				pst2.executeUpdate();

				return existingId;
			} else {
				// if not exists then insert book data
				PreparedStatement pst = con.prepareStatement(
						"insert into LibraryManagement (title, author, publish_date, status, available_books) values (?,?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS);

				pst.setString(1, lib.getBookTitle());
				pst.setString(2, lib.getAuthorName());
				pst.setDate(3, lib.getIssueDate());
				pst.setString(4, lib.getStatus());
				pst.setInt(5, lib.getAvailable_Books());

				pst.executeUpdate();

				ResultSet rs = pst.getGeneratedKeys();

				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	// Issue Book

	public int issueBook(String title) {
		int i = 0;

		try {
			Connection con = getConnection();

			// check book available or not
			PreparedStatement pst1 = con
					.prepareStatement("select id, available_books from libraryManagement where title = ?");
			pst1.setString(1, title);

			ResultSet rs1 = pst1.executeQuery();

			if (rs1.next()) {
				int id = rs1.getInt("id");
				int available = rs1.getInt("available_books");

				if (available <= 0) {
					return 0;
				}

				int newCount = available - 1;

				if (newCount == 0) {
					PreparedStatement pst = con.prepareStatement(
							"update libraryManagement set available_books = ?, status = 'Issued' where id = ?");
					pst.setInt(1, newCount);
					pst.setInt(2, id);

					i = pst.executeUpdate();

				} else {
					PreparedStatement pst = con.prepareStatement(
							"update libraryManagement set available_books = ?, status = 'Available' where id = ?");
					pst.setInt(1, newCount);
					pst.setInt(2, id);

					i = pst.executeUpdate();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	// Return Book

	public int returnBook(String title) {
		int i = 0;

		try {
			Connection con = getConnection();

			PreparedStatement pst = con.prepareStatement(
					"update libraryManagement set available_books = available_books + 1, status = 'Returned' where title = ?");

			pst.setString(1, title);

			i = pst.executeUpdate();

			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	// Find book by name

	public List<Library> findBook(String title) {
		List<Library> list = new LinkedList<Library>();

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from libraryManagement where title = ?");
			pst.setString(1, title);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String author = rs.getString("author");
				Date dt = rs.getDate("publish_date");
				int avlBooks = rs.getInt("available_books");
				String status = rs.getString("status");

				list.add(new Library(id, title, author, dt, avlBooks, status));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Total book list available

	public List<Library> listAvailable() {
		List<Library> list = new LinkedList<Library>();

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from libraryManagement where status = 'Available'");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date dt = rs.getDate("publish_date");
				int avlBooks = rs.getInt("available_books");
				String status = rs.getString("status");

				list.add(new Library(id, title, author, dt, avlBooks, status));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// Check Book insert book is avialable or not

	public List<Library> BookAvailable() {
		List<Library> list = new LinkedList<Library>();

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from libraryManagement where status = 'Available'");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date dt = rs.getDate("publish_date");
				int avlBooks = rs.getInt("available_books");
				String status = rs.getString("status");

				list.add(new Library(id, title, author, dt, avlBooks, status));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
