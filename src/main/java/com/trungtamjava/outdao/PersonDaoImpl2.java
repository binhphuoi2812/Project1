package com.trungtamjava.outdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.outmodel.JDBCConnection;
import com.trungtamjava.outmodel.Person;

//import com.ttjava.dao.JDBCConnection;
//import com.ttjava.dao.JDBCStatement;

public class PersonDaoImpl2 implements PersonDao {

	@Override
	public void create(Person p) {
		Connection conn = JDBCConnection.getConn();

		try {
			
			String sql = "INSERT INTO client(name, role,imageurl) VALUES(?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, p.getName());
			st.setString(2, p.getRole());
			st.setString(3, p.getImageurl());
			
			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Loi :" + ex);
		}
	}

	@Override
	public void update(Person p) {
		try {
			String sql = "update client SET name = ? , role = ?, imageurl = ? WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, p.getName());
			ps.setString(2, p.getRole());
			ps.setString(3, p.getImageurl());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from client WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate(); // ko truyen sql o day nua
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public Person get(int id) {
		try {
			String sql = "SELECT id ,name , role,imageurl FROM  client WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String name = rs.getString("name");
				String role = rs.getString("role");
				String imageurl = rs.getString("imageurl");

				Person p = new Person();
				p.setId(pid);
				p.setName(name);
				p.setRole(role);
				p.setImageurl(imageurl);

				return p;
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return null;
	}

	@Override
	public List<Person> search(String name) {
		List<Person> personList = new ArrayList<Person>();

		try {
			String sql = "SELECT id ,name , role,imageurl FROM  client WHERE name LIKE ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String pname = rs.getString("name");
				String role = rs.getString("role");
				String imageurl = rs.getString("imageurl");

				Person p = new Person();
				p.setId(pid);
				p.setName(pname);
				p.setRole(role);
				p.setImageurl(imageurl);


				personList.add(p);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return personList;
	}

	@Override
	public Person getByUsername(String username) {
		try {
			String sql = "SELECT * FROM  client WHERE username = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String name = rs.getString("name");
				String role = rs.getString("role");
				String imageurl = rs.getString("imageurl");

				String pusername = rs.getString("username");
				String password = rs.getString("password");
				Person p = new Person();
				p.setId(pid);
				p.setName(name);
				p.setRole(role);
				p.setImageurl(imageurl);
                p.setUsername(pusername);
                p.setPassword(password);
				return p;
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return null;
	}

}
