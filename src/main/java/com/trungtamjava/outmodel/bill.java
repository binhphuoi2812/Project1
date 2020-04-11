package com.trungtamjava.outmodel;

import java.io.Serializable;


public class bill implements Serializable {
	private int id;
	private Person buyer;// nguoi mua
	private String buyDate;// ngay mua
	private long priceTotal;// tong tien
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getBuyer() {
		return buyer;
	}

	public void setBuyer(Person buyer) {
		this.buyer = buyer;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public long getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(long priceTotal) {
		this.priceTotal = priceTotal;
	}

}

