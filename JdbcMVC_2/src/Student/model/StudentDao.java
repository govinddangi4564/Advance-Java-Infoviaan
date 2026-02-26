package Student.model;

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

	// insertion

	public int insert(Student st) {
		int i = 0;

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(
					"insert into students (name, age, rollno, hindiMarks, englishMarks, mathsMarks) values(?,?,?,?,?,?)");
			pst.setString(1, st.getName());
			pst.setInt(2, st.getAge());
			pst.setString(3, st.getRollno());
			pst.setInt(4, st.getHindiMarks());
			pst.setInt(5, st.getEnglishMarks());
			pst.setInt(6, st.getMathsMarks());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// update

	public int update(Student st) {
		int i = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update students set name = ? where rollno = ?");
			pst.setString(1, st.getName());
			pst.setString(2, st.getRollno());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// delete

	public int delete(String roll) {
		int i = 0;

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from students where rollno = ?");
			pst.setString(1, roll);

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
			PreparedStatement pst = con.prepareStatement("select * from students");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String roll = rs.getString("rollno");
				int hM = rs.getInt("hindiMarks");
				int eM = rs.getInt("englishMarks");
				int mM = rs.getInt("mathsMarks");

				list.add(new Student(id, name, age, roll, hM, eM, mM));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// sort by percentage

	public List<Student> sortByPer() {
		List<Student> list = new LinkedList<>();

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(
					"select *, (hindiMarks + englishMarks + mathsMarks)/3.0 AS percentage FROM students ORDER BY percentage DESC");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String roll = rs.getString("rollno");
				int hM = rs.getInt("hindiMarks");
				int eM = rs.getInt("englishMarks");
				int mM = rs.getInt("mathsMarks");
				Double per = rs.getDouble("percentage");

				list.add(new Student(id, name, age, roll, hM, eM, mM, per));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	//  sort by rollNo
	
	public List<Student> sortByRoll() {
		List<Student> list = new LinkedList<>();

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(
					"select * from students order by rollno asc");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String roll = rs.getString("rollno");
				int hM = rs.getInt("hindiMarks");
				int eM = rs.getInt("englishMarks");
				int mM = rs.getInt("mathsMarks");

				list.add(new Student(id, name, age, roll, hM, eM, mM));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
