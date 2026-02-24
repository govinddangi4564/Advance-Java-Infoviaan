package Simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task3 {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/infoviaan";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Govind";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {

			Class.forName(DRIVER);

			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			Statement stmt = con.createStatement();

			System.out.println(
					"Enter 1 for insertion : \nEnter 2 for Updation : \nEnter 3 for Deletion : \nEnter 4 for retrive data : \nEnter 5 for Exit : ");

			int choice = sc.nextInt();
			sc.nextLine();

			while (choice != 5) {
				switch (choice) {

				case 1: {
					System.out.println("Enter name : ");
					String name = sc.nextLine();

					System.out.println("Enter age : ");
					int age = sc.nextInt();

					System.out.println("Enter Rollno : ");
					int rollno = sc.nextInt();

					String query = String.format("insert into student(name, roll,age) values ('%s', %d, %d)", name,
							rollno, age);

					int i = stmt.executeUpdate(query);

					System.out.println(i != 0 ? "Success.." : "Somethng went wrong");

					break;
				}

				case 2: {
					System.out.println("Enter Rollno : ");
					int rollno = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter new name : ");
					String name = sc.nextLine();

					String query = String.format("update student set name = '%s' where roll = %d", name, rollno);

					int i = stmt.executeUpdate(query);

					System.out.println(i != 0 ? "Success.." : "Something went wrong");

					break;
				}

				case 3: {
					System.out.println("Enter Rollno : ");
					int rollno = sc.nextInt();
					sc.nextLine();

					String query = String.format("delete from student where roll = %d", rollno);

					int i = stmt.executeUpdate(query);

					System.out.println(i != 0 ? "Success.." : "Something went wrong");

					break;
				}

				case 4: {
					ResultSet rs = stmt.executeQuery("select * from student order by roll asc");

					while (rs.next()) {
						String name = rs.getString("name");
						int roll = rs.getInt("roll");
						int age = rs.getInt("age");

						System.out.println(name + "\t" + roll + "\t" + age);
					}
					break;
				}

				default:
					System.out.println("Invalid Choice");
				}

				System.out.println("----------------------------------");
				System.out.println(
						"Enter 1 for insertion : \nEnter 2 for Updation : \nEnter 3 for Deletion : \nEnter 4 for retrive data : \nEnter 5 for Exit : ");

				choice = sc.nextInt();
				sc.nextLine();
			}
			System.out.println("Closed...");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		sc.close();
	}
}
