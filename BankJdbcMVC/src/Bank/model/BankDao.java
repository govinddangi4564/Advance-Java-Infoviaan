package Bank.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BankDao {
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

	public int insert(Bank bk) {
		int i = 0;

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into bank (name, accNo, balance) values(?,?,?)");
			pst.setString(1, bk.getName());
			pst.setLong(2, bk.getAccNo());
			pst.setDouble(3, bk.getBalance());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// read

	public List<Bank> read() {
		List<Bank> list = new LinkedList<>();

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from bank");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Long accNo = rs.getLong("accNo");
				double balance = rs.getDouble("balance");

				list.add(new Bank(id, name, accNo, balance));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Withdrawal

	public int debit(Bank bk) {
		int i = 0;

		try {
			Connection con = getConnection();
			con.setAutoCommit(false);
			
			PreparedStatement pst = con.prepareStatement("update bank set balance = balance - ? where accNo = ?");
			pst.setInt(1, bk.getAmount());
			pst.setLong(2, bk.getAccNo());

			i = pst.executeUpdate();
			
			if( i != 0) {
				con.commit();
			}else {
				con.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// Credit

	public int credit(Bank bk) {
		int i = 0;

		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update bank set balance = balance + ? where accNo = ?");
			pst.setInt(1, bk.getAmount());
			pst.setLong(2, bk.getAccNo());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// Transfer

	public int transfer(Bank bk) {
		int result = 0;

		try {
			Connection con = getConnection();
			con.setAutoCommit(false);

			PreparedStatement ps1 = con.prepareStatement("update bank set balance = balance - ? where accNo = ?");
			ps1.setInt(1, bk.getAmount());
			ps1.setLong(2, bk.getFromAccNo());

			PreparedStatement ps2 = con.prepareStatement("update bank set balance = balance + ? where accNo = ?");
			ps2.setInt(1, bk.getAmount());
			ps2.setLong(2, bk.getToAccNo());
			
			int i = ps1.executeUpdate();
			int j = ps2.executeUpdate();

			if (i != 0 && j != 0) {
				con.commit();
				result = 1;
			} else {
				con.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
