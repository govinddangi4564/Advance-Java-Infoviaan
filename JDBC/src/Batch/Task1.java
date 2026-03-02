package Batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task1 {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/infoviaan";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Govind";

	public static void main(String[] args) {
		PreparedStatement pst = null;
		try {
			Class.forName(DRIVER);

			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			pst = con.prepareStatement("insert into student(name, age,roll) values(?,?,?)");
			pst.setString(1, "Govind");
			pst.setInt(2, 20);
			pst.setInt(3, 101);
			pst.addBatch();

			pst.setString(1, "Shyam");
			pst.setInt(2, 19);
			pst.setInt(3, 102);
			pst.addBatch();

			pst.setString(1, "Sunil");
			pst.setInt(2, 18);
			pst.setInt(3, 103);
			pst.addBatch();

			int[] arr = pst.executeBatch();

			for (int a : arr) {
				System.out.println(a);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
