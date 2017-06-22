package easyui.iyunmai.module;

import java.util.Date;

public class restaurant {
		
	private int id;
	private String name;
	private String address;
	private String phone;
	private Date creattime;
	
	
	public restaurant() {
		super();
	}
	public restaurant(int id, String name, String address, String phone,
			Date creattime) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.creattime = creattime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	
	
}
