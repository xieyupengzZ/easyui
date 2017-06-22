package easyui.iyunmai.module;

import java.util.Date;


public class usersinfo {

	private int id;
	private int userId;
	private String nickName;
	private String realName;
	private String description;
	private String avatarUrl;
	private int birthday = 0;
	private short sex = 1;
	private short unit = 1;
	private int height = 170;
	private int waistLine = 85;
	private int bust = 90;
	private float basisWeight = 0.0f;
	private float firstWeight = 0.0f;
	private float firstFat = 0.0f;
	private Date createTime = new Date();
	private Date updatTime = new Date();
	private String ip;

	
		
	public usersinfo() {
		super();
	}



	public usersinfo(int id, int userId, String nickName, String realName,
			String description, String avatarUrl, int birthday, short sex,
			short unit, int height, int waistLine, int bust, float basisWeight,
			float firstWeight, float firstFat, Date createTime, Date updatTime,
			String ip) {
		super();
		this.id = id;
		this.userId = userId;
		this.nickName = nickName;
		this.realName = realName;
		this.description = description;
		this.avatarUrl = avatarUrl;
		this.birthday = birthday;
		this.sex = sex;
		this.unit = unit;
		this.height = height;
		this.waistLine = waistLine;
		this.bust = bust;
		this.basisWeight = basisWeight;
		this.firstWeight = firstWeight;
		this.firstFat = firstFat;
		this.createTime = createTime;
		this.updatTime = updatTime;
		this.ip = ip;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public String getRealName() {
		return realName;
	}



	public void setRealName(String realName) {
		this.realName = realName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getAvatarUrl() {
		return avatarUrl;
	}



	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}



	public int getBirthday() {
		return birthday;
	}



	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}



	public short getSex() {
		return sex;
	}



	public void setSex(short sex) {
		this.sex = sex;
	}



	public short getUnit() {
		return unit;
	}



	public void setUnit(short unit) {
		this.unit = unit;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public int getWaistLine() {
		return waistLine;
	}



	public void setWaistLine(int waistLine) {
		this.waistLine = waistLine;
	}



	public int getBust() {
		return bust;
	}



	public void setBust(int bust) {
		this.bust = bust;
	}



	public float getBasisWeight() {
		return basisWeight;
	}



	public void setBasisWeight(float basisWeight) {
		this.basisWeight = basisWeight;
	}



	public float getFirstWeight() {
		return firstWeight;
	}



	public void setFirstWeight(float firstWeight) {
		this.firstWeight = firstWeight;
	}



	public float getFirstFat() {
		return firstFat;
	}



	public void setFirstFat(float firstFat) {
		this.firstFat = firstFat;
	}



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public Date getUpdatTime() {
		return updatTime;
	}



	public void setUpdatTime(Date updatTime) {
		this.updatTime = updatTime;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	@Override
	public String toString() {
		return "UsersInfo [id=" + id + ", userId=" + userId + ", nickName=" + nickName + ", realName=" + realName
				+ ", avatarUrl=" + avatarUrl + ", birthday=" + birthday + ", sex=" + sex + ", unit=" + unit
				+ ", height=" + height + ", waistLine=" + waistLine + ", bust=" + bust
				+ ", basisWeight=" + basisWeight + ", firstWeight=" + firstWeight
				+ ", createTime=" + createTime +"]";
	}

}
