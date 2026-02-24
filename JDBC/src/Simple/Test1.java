package Simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test1 {

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

	public static Scanner sc = new Scanner(System.in);

	public static int showMenu() {
		System.out.println("---------------------------------");
		System.out.println(
				"Enter 1 for insertion : \nEnter 2 for Updation : \nEnter 3 for Deletion : \nEnter 4 for read data : \nEnter 5 for sort by rollno \nEnter 6 for sort by percentage \nEnter 7 for read with total percentage \nEnter 8 for Exit : ");
		System.out.println("---------------------------------");
		return sc.nextInt();
	}

	public static void insert() {

		System.out.println("Enter student id : ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter student name : ");
		String nm = sc.nextLine();

		System.out.println("Enter age : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter student rollno : ");
		String roll = sc.nextLine();

		System.out.println("Enter Hindi Marks : ");
		int hM = sc.nextInt();

		System.out.println("Enter English Marks : ");
		int eM = sc.nextInt();

		System.out.println("Enter Maths Marks : ");
		int mM = sc.nextInt();

		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();

			String query = String.format(
					"insert into students(id, name, age, rollno, hindiMarks, englishMarks, mathsMarks) values (%d, '%s', %d, '%s', %d, %d, %d)",
					id, nm, age, roll, hM, eM, mM);

			int i = stmt.executeUpdate(query);

			System.out.println(i != 0 ? "Success" : "Something went wrong");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update() {
		sc.nextLine();
		System.out.println("Enter Rollno : ");
		String roll = sc.nextLine();

		System.out.println("Enter new name : ");
		String name = sc.nextLine();

		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();

			String query = String.format("update students set name = '%s' where rollno = '%s'", name, roll);

			int i = stmt.executeUpdate(query);

			System.out.println(i != 0 ? "Success.." : "Something went wrong");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete() {
		sc.nextLine();
		System.out.println("Enter Rollno : ");
		String roll = sc.nextLine();

		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();

			String query = String.format("delete from students where rollno = '%s'", roll);

			int i = stmt.executeUpdate(query);

			System.out.println(i != 0 ? "Success.." : "Something went wrong");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void read() {

		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from students");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String roll = rs.getString("rollno");
				int age = rs.getInt("age");
				int hM = rs.getInt("hindiMarks");
				int eM = rs.getInt("englishMarks");
				int mM = rs.getInt("mathsMarks");

				System.out.println(id + "\t" + name + "\t" + age + "\t" + roll + "\t" + hM + "\t" + eM + "\t" + mM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void sortByRoll() {
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from students order by rollno asc");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String roll = rs.getString("rollno");
				int age = rs.getInt("age");
				int hM = rs.getInt("hindiMarks");
				int eM = rs.getInt("englishMarks");
				int mM = rs.getInt("mathsMarks");

				System.out.println(id + "\t" + name + "\t" + age + "\t" + roll + "\t" + hM + "\t" + eM + "\t" + mM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void sortByPer() {
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();

			String query = "select *, (hindiMarks + englishMarks + mathsMarks)/3.0 AS per FROM students ORDER BY per DESC";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String roll = rs.getString("rollno");
				int age = rs.getInt("age");
				int hM = rs.getInt("hindiMarks");
				int eM = rs.getInt("englishMarks");
				int mM = rs.getInt("mathsMarks");
				double per = rs.getDouble("per");

				System.out.println(
						id + "\t" + name + "\t" + age + "\t" + roll + "\t" + hM + "\t" + eM + "\t" + mM + "\t" + per);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void totalAndPer() {
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(
					"select name, rollno, (hindiMarks + englishMarks + mathsMarks) as total, (hindiMarks + englishMarks + mathsMarks) / 3.0 as per FROM students order by per desc");

			while (rs.next()) {
				String name = rs.getString("name");
				String roll = rs.getString("rollno");
				double total = rs.getDouble("total");
				double per = rs.getDouble("per");

				System.out.println(name + "\t" + roll + "\t" + total + "\t" + per);
			}

		} catch (SQLException e) {

		}
	}

	public static void main(String[] args) {

		boolean f = true;
		while (f) {

			int choice = showMenu();
			switch (choice) {

			case 1:
				insert();
				break;

			case 2:
				update();
				break;

			case 3:
				delete();
				break;

			case 4:
				read();
				break;

			case 5:
				sortByRoll();
				break;

			case 6:
				sortByPer();
				break;

			case 7:
				totalAndPer();
				break;

			case 8:
				System.out.println("Exit....");
				f = false;
				break;

			default:
				System.out.println("Exit....");
			}
		}
	}

}
