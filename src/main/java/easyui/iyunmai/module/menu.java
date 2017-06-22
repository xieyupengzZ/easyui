package easyui.iyunmai.module;

import java.util.Date;

public class menu {
	 private int id;
	 private String food;
	 private double extrafee;
	 private  double price;
	 private int  restaurantid;
	 private Date createtime;
	 
	 
	public menu() {
		super();
	}
	
	public menu(int id, String food, double extrafee, double price,int restaurantid, Date createtime) {
		super();
		this.id = id;
		this.food = food;
		this.extrafee = extrafee;
		this.price = price;
		this.restaurantid = restaurantid;
		this.createtime = createtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public double getExtrafee() {
		return extrafee;
	}
	public void setExtrafee(double extrafee) {
		this.extrafee = extrafee;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	 
	 
}
