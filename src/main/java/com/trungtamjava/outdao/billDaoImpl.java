package com.trungtamjava.outdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.outmodel.JDBCConnection;
import com.trungtamjava.outmodel.Person;
import com.trungtamjava.outmodel.bill;

public class billDaoImpl implements billDao {

	public void create(bill p) {
		Connection conn = JDBCConnection.getConn();

		try {
			
			String sql = "INSERT INTO bill(idperson, buydate,pricetotal) VALUES(?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, p.getBuyer().getName());
			st.setString(2, p.getBuyDate());
			st.setLong(3, p.getPriceTotal());
			
			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Loi :" + ex);
		}
	}

	
	public void update(bill p) {
		try {
			String sql = "update bill SET idperson = ? , buydate = ?, pricetotal = ? WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, p.getBuyer().getId());
			ps.setString(2, p.getBuyDate());
			ps.setLong(3, p.getPriceTotal());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from bill WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate(); 
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public bill get(int id) {
		try {
			String sql = "SELECT bill.id ,person.name , bill.buydate,bill.pricetotal FROM person inner join bill ON bill.idperson = person.id WHERE bill.id LIKE ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("bill.id");
				String name = rs.getString("person.name");
				String buydate = rs.getString("bill.buydate");
				Long pricetotal = rs.getLong("bill.pricetotal");

				bill p = new bill();
				p.setId(pid);
				p.setBuyDate(buydate);
				p.setPriceTotal(pricetotal);
				
				Person pe = new Person();
				pe.setName(name);
				p.setBuyer(pe);

				return p;
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return null;
	}

	@Override
	public List<bill> search(String name) {
		List<bill> billList = new ArrayList<bill>();

		try {
			String sql = "SELECT id ,name , buyDate,pricetotal FROM  bill WHERE person.name LIKE ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("bill.id");
				String pname = rs.getString("person.name");
				String buydate = rs.getString("bill.buydate");
				Long pricetotal = rs.getLong("bill.pricetotal");

				bill p = new bill();
				p.setId(pid);
				p.setBuyDate(buydate);
				p.setPriceTotal(pricetotal);
				
				Person pe = new Person();
				pe.setName(pname);
                p.setBuyer(pe);

				billList.add(p);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return billList;
	}

	

}
