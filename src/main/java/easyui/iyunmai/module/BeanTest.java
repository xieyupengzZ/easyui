package easyui.iyunmai.module;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanTest {

	private int num;
	
	private user userTest;

	@Autowired(required=false)
	public BeanTest(int num){
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public user getUserTest() {
		return userTest;
	}

	public void setUserTest(user userTest) {
		this.userTest = userTest;
	}

	@Override
	public String toString() {
		return "BeanTest [num=" + num + ", userTest=" + userTest + "]";
	}
}
