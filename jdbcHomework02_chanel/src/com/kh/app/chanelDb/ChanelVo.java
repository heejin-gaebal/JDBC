package com.kh.app.chanelDb;

public class ChanelVo {
	private String no;
	private String product;
	private String price;
	private int quantity;
	private String create_date;
	private String del_yn;
	
	public ChanelVo(){
	
	}

	public ChanelVo(String no, String product, String price, int quantity, String create_date, String del_yn) {
		super();
		this.no = no;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.create_date = create_date;
		this.del_yn = del_yn;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	@Override
	public String toString() {
		return "ChanelVo [no=" + no + ", product=" + product + ", price=" + price + ", quantity=" + quantity
				+ ", create_date=" + create_date + ", del_yn=" + del_yn + "]";
	}
}
