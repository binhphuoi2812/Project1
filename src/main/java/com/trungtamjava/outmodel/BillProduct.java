package com.trungtamjava.outmodel;

public class BillProduct {
	private int id;
	private long unitPrice;
	private int quantity;
	private bill bill1;
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public bill getBill() {
		return bill1;
	}

	public void setBill(bill bill) {
		this.bill1 = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
