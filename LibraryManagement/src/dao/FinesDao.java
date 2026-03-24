package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DBConnection.DBConnection;
import model.Fines;

public class FinesDao {

	public int calculateFine(int IssueId) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"SELECT due_date, return_date, DATEDIFF(return_date, due_date) as dd FROM issue_books where issue_id = ?");
			pst.setInt(1, IssueId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Date returnDate = rs.getDate("return_date");

				if (returnDate != null) {

					int dd = rs.getInt("dd");

					if (dd > 0) {
						int fine = dd * 5;

						PreparedStatement pst2 = con.prepareStatement("select * from fines where issue_id = ?");
						pst2.setInt(1, IssueId);
						ResultSet rs2 = pst2.executeQuery();

						if (!rs2.next()) {
							PreparedStatement pst1 = con
									.prepareStatement("insert into fines (issue_id, amount) values (?,?)");
							pst1.setInt(1, IssueId);
							pst1.setInt(2, fine);

							i = pst1.executeUpdate();
						}
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public List<Fines> viewAllFines() {
		List<Fines> list = new LinkedList<>();

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(
					"select s.name, s.phone, b.title, b.author, i.due_date, i.return_date, f.amount from students s inner join issue_books i on s.student_id = i.student_id inner join books b on i.book_id = b.book_id inner join fines f on i.issue_id = f.issue_id");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date iDate = rs.getDate("due_date");
				Date rDate = rs.getDate("return_date");
				int fine = rs.getInt("amount");

//				list.add(new Fines(fine, name, phone, title, author, iDate, rDate));
			
				list.add(new Fines(name, phone, title, author, iDate, rDate, fine));
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
