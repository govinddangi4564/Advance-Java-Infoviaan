package Simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task2 {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/infoviaan";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Govind";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName(DRIVER);
			
			Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			Statement stmt = con.createStatement();
			
			System.out.println("Enter name : ");
			String name = sc.nextLine();
			
			System.out.println("Enter age : ");
			int age = sc.nextInt();
			
			System.out.println("Enter Rollno : ");
			int rollno = sc.nextInt();
			
			String query = String.format("insert into student(name, roll,age) values ('%s','%d','%d')", name, rollno, age);
			
			int i = stmt.executeUpdate(query);
			
			System.out.println(i != 0 ? "Success.." : "Somethng went wrong");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
