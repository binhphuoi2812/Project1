package com.trungtamjava.outdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.outmodel.BillProduct;
import com.trungtamjava.outmodel.JDBCConnection;
import com.trungtamjava.outmodel.Product;
import com.trungtamjava.outmodel.bill;

public class BillProductDaoImpl implements BillProductDao {

	@Override
	public void create(BillProduct p) {
		Connection conn = JDBCConnection.getConn();

		try {
			
			String sql = "INSERT INTO billproduct(unitprice, quantity,idbill,idproduct) VALUES(?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setLong(1, p.getUnitPrice());
			st.setInt(2, p.getQuantity());
			st.setLong(3, p.getBill().getId());
			st.setLong(3, p.getProduct().getId());

			
			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Loi :" + ex);
		}
	}

	@Override
	public void update(BillProduct p) {
		try {
			String sql = "update billproduct SET unitprice = ? , quantity = ?, idbill = ?,idproduct = ? WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, p.getUnitPrice());
			ps.setInt(2, p.getQuantity());
			ps.setInt(3, p.getBill().getId());
			ps.setInt(4, p.getProduct().getId());

			ps.setInt(5, p.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from billproduct WHERE id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate(); 
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public BillProduct get(int id) {
		try {
			String sql = "SELECT b.id, b.idbill,b.idproduct,b.unitprice,b.quantity,bill.buydate,product.name from billproduct as b inner join bill\r\n" + 
					"on b.idbill = bill.id inner join product on b.idproduct = product.id WHERE b.id=?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("b.id");
				Long unitprice = rs.getLong("b.unitprice");
				int quantity = rs.getInt("b.quantity");
				Long pricetotal = rs.getLong("bill.pricetotal");

				BillProduct p = new BillProduct();
				p.setId(pid);
				p.setUnitPrice(unitprice);
				p.setQuantity(quantity);
				
				bill pe = new bill();
				pe.setBuyDate(rs.getString("bill.buydate"));
				p.setBill(pe);
				
				Product pr = new Product();
				pr.setName(rs.getString("product.name"));
				p.setProduct(pr);

				return p;
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return null;
	}

	@Override
	public List<BillProduct> search(String name) {
		List<BillProduct> billList = new ArrayList<BillProduct>();

		try {
			String sql = "SELECT b.id, b.idbill,b.idproduct,b.unitprice,b.quantity,bill.buydate,product.name from billproduct as b inner join bill\r\n" + 
					"on b.idbill = bill.id inner join product on b.idproduct = product.id WHERE b.id LIKE ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("b.id");
				Long unitprice = rs.getLong("b.unitprice");
				int quantity = rs.getInt("b.quantity");
				Long pricetotal = rs.getLong("bill.pricetotal");

				BillProduct p = new BillProduct();
				p.setId(pid);
				p.setUnitPrice(unitprice);
				p.setQuantity(quantity);
				
				bill pe = new bill();
				pe.setBuyDate(rs.getString("bill.buydate"));
				p.setBill(pe);
				
				Product pr = new Product();
				pr.setName(rs.getString("product.name"));
				p.setProduct(pr);
				
				billList.add(p);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return billList;
	}

	

}

