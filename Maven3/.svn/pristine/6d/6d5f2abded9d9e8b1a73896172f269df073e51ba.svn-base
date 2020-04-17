package com.trungtamjava.outdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.outmodel.Category;
import com.trungtamjava.outmodel.JDBCConnection;
import com.trungtamjava.outmodel.Person;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public void create(Category c) {
		Connection conn = JDBCConnection.getConn();

		try {
			String sql = "INSERT INTO category (name) VALUES(?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, c.getName());
			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Loi :" + ex);
		}

	}

	@Override
	public void update(Category c) {
		try {
			String sql = "update category SET name= ?   WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(2, c.getId());
			ps.setString(1, c.getName());

			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from category  WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public Category get(int id) {
		try {
			String sql = "SELECT id ,name FROM category WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String name = rs.getString("name");
	
				Category c= new Category();
				c.setId(pid);
				c.setName(name);
		

				return c;
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return null;
	}

	@Override
	public List<Category> search(String name) {
		List<Category> categoryList = new ArrayList<Category>();

		try {
			String sql = "SELECT id ,name FROM  category WHERE name LIKE ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String pname = rs.getString("name");
				Category c = new Category();
				c.setId(pid);
				c.setName(pname);
	

				categoryList.add(c);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return categoryList;
	}
	

}
