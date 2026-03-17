package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DBConnection.DBConnection;
import model.Product;

public class ProductDAO {

// Add product

	public int addProduct(Product pro) {
		int proId = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"insert into products (product_name, price, stock_quantity, category,created_at) values(?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, pro.getProductName());
			pst.setDouble(2, pro.getProductPrice());
			pst.setInt(3, pro.getProductStock());
			pst.setString(4, pro.getProductCategory());
			pst.setDate(5, pro.getProductCreatedDate());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();

			while (rs.next()) {
				proId = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proId;
	}

// Remove Product

	public int removeProduct(int id, int qty) {
		int i = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Update products set stock_quantity = stock_quantity - ? where product_id = ?");
			pst.setInt(1, qty);
			pst.setInt(2, id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

// View Products by id

	public List<Product> viewProduct(int productId) {
		List<Product> list = new LinkedList<Product>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from products where product_id = ?");
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				Double price = rs.getDouble("price");
				int stock = rs.getInt("stock_quantity");
				String cate = rs.getString("category");
				Date dt = rs.getDate("created_at");

				list.add(new Product(id, name, price, stock, cate, dt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

// View Products by Name

	public List<Product> viewProduct(String proName) {
		List<Product> list = new LinkedList<Product>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from products where product_name = ?");
			pst.setString(1, proName);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				Double price = rs.getDouble("price");
				int stock = rs.getInt("stock_quantity");
				String cate = rs.getString("category");
				Date dt = rs.getDate("created_at");

				list.add(new Product(id, name, price, stock, cate, dt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

// View Products by Category

	public List<Product> viewProductCategory(String category) {
		List<Product> list = new LinkedList<Product>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from products where category = ?");
			pst.setString(1, category);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				Double price = rs.getDouble("price");
				int stock = rs.getInt("stock_quantity");
				String cate = rs.getString("category");
				Date dt = rs.getDate("created_at");

				list.add(new Product(id, name, price, stock, cate, dt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

// Update Product

	public int update(int id, int choice, String value) {
		int i = 0;

		String query = "";

		try {
			Connection con = DBConnection.getConnection();

			if (choice == 1) {
				query = "update Products set product_name = ? where product_id = ?";
			} else if (choice == 2) {
				query = "update Products set price = ? where product_id = ?";
			} else if (choice == 3) {
				query = "update Products set category = ? where product_id = ?";
			}
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, value);
			pst.setInt(2, id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

// Product Report

	public List<Product> productReport() {
		List<Product> list = new LinkedList<Product>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from products");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				Double price = rs.getDouble("price");
				int stock = rs.getInt("stock_quantity");
				String cate = rs.getString("category");
				Date dt = rs.getDate("created_at");

				list.add(new Product(id, name, price, stock, cate, dt));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// get Product name by product id

	public String productName(int proId) {
		String name = "";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT product_name FROM products WHERE product_id = ?");

			pst.setInt(1, proId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				name = rs.getString("product_name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return name;
	}

// get stock

	public int getStock(int proId) {
		int stock = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select stock_quantity from products where product_id = ?");
			pst.setInt(1, proId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				stock = rs.getInt("stock_quantity");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}
}
