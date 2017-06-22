package easyui.iyunmai.module;

public class user {
	private int  id;
	private String username;
	private String password;
	private String account;
	private int type;
	
	public user() {
		super();
	}
	public user(int id, String username, String password, String account,int type) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.account = account;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
