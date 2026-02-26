package student.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentDao {
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

	// Insertion

	public int insert(Student st) {
		int i = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into student(name, age, roll) values(?,?,?)");
			pst.setString(1, st.getName());
			pst.setInt(2, st.getAge());
			pst.setInt(3, st.getRoll());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// update
	public int update(int roll, String name) {
		int i = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update student set name = ? where roll = ?");
			pst.setString(1, name);
			pst.setInt(2, roll);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	// delete

	public int delete(int roll) {
		int i = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from student where roll = ?");
			pst.setInt(1, roll);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// read

	public List<Student> read() {
		List<Student> list = new LinkedList<>();
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int roll = rs.getInt("roll");

				list.add(new Student(name, age, roll));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
