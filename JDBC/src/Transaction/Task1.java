package Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task1 {
	private static final String URL = "jdbc:mysql://localhost:3306/infoviaan";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Govind";

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;

		int amount = 500;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			con.setAutoCommit(false);
			
			ps1 = con.prepareStatement("update bank set balance = balance - ? where accno = ?");
			ps1.setInt(1, amount);
			ps1.setLong(2, 10001);
			
			ps2 = con.prepareStatement("update bank set balance = balance + ? where accno = ?");
			ps2.setInt(1, amount);
			ps2.setLong(2, 10002);
			
			int i = ps1.executeUpdate();
			int j = ps2.executeUpdate();
			
			if(i != 0 && j != 0) {
				con.commit();
				System.out.println("Transaction Complete...");
			}else {
				System.out.println("Transaction Failed...");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
