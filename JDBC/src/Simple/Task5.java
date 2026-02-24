package Simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task5 {
	private static final String URL = "jdbc:mysql://localhost:3306/infoviaan";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Govind";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter age : ");
		int age = sc.nextInt();
		
		System.out.println("Enter rollNo : ");
		int roll = sc.nextInt();
		
		try {
			Class.forName(DRIVER);
			
			Connection con = DriverManager.getConnection(URL, USERNAME,PASSWORD);
			
			PreparedStatement pstmt = con.prepareStatement("insert into student (name, age, roll) values(?,?,?)");
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, roll);
			
//			PreparedStatement pstmt = con.prepareStatement("update student set name = ? where roll = ?");
//			pstmt.setString(1, name);
//			pstmt.setInt(2, roll);
			
//			PreparedStatement pstmt = con.prepareStatement("delete from student where roll = ?");
//			pstmt.setInt(1, roll);
			
			int i = pstmt.executeUpdate();
			System.out.println(i != 0 ? "Success.." : "Something went wrong..");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
