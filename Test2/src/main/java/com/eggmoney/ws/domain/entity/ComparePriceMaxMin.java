package com.eggmoney.ws.domain.entity;

public class ComparePriceMaxMin {
	private int pid;
	private int min_price;
	private int max_price;
	private String product_title;
	private String mart_name;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getMin_price() {
		return min_price;
	}
	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}
	public int getMax_price() {
		return max_price;
	}
	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public String getMart_name() {
		return mart_name;
	}
	public void setMart_name(String mart_name) {
		this.mart_name = mart_name;
	}
}
