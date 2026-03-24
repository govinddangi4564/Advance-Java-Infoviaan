package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DBConnection.DBConnection;
import model.Student;

public class StudentDao {

// Add student
	public int addStudent(Student s) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("insert into students (name, email, phone) values(?,?,?)");
			pst.setString(1, s.getStudentName());
			pst.setString(2, s.getEmail());
			pst.setString(3, s.getPhone());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// View Student
	public List<Student> viewStudent() {
		List<Student> list = new LinkedList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from students");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("student_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phno = rs.getString("phone");

				list.add(new Student(id, name, email, phno));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// View Student
	public List<Student> searchStudent(String name) {
		List<Student> list = new LinkedList<>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from students where name = ?");
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("student_id");
				String email = rs.getString("email");
				String phno = rs.getString("phone");

				list.add(new Student(id, name, email, phno));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

// Update student
	public int updateStudent(int id, String phone) {
		int i = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("update students set phone = ? where student_id = ?");
			pst.setString(1, phone);
			pst.setInt(2, id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

// Delete Student
	public int deleteStudent(int id) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("delete from students where student_id = ?");
			pst.setInt(1, id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}
}
