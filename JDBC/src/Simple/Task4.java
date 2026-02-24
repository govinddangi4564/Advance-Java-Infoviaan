package Simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task4 {
	private static final String URL = "jdbc:mysql://localhost:3306/infoviaan";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Govind";
	
	public static void main(String[] args) {
		try {
			Class.forName(DRIVER);
			
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
//			PreparedStatement pstmt = con.prepareStatement("insert into student (name, age, roll) values(?,?,?)");
//			pstmt.setString(1, "Govind");
//			pstmt.setInt(2, 20);
//			pstmt.setInt(3, 108);
			
//			PreparedStatement pstmt = con.prepareStatement("update student set name = ? where roll = ?");
//			pstmt.setString(1, "Sunil");
//			pstmt.setInt(2, 108);
			
			PreparedStatement pstmt = con.prepareStatement("delete from student where roll = ?");
			pstmt.setInt(1, 108);
			
			int i = pstmt.executeUpdate();
			System.out.println(i != 0 ? "Success.." : "Something went wrong..");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
