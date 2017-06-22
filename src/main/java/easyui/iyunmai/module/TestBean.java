package easyui.iyunmai.module;

public class  TestBean {

	private int num = 1;
	private BeanTest beanTest;
	
	public void out(){
		System.out.println();
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BeanTest getBeanTest() {
		return beanTest;
	}

	public void setBeanTest(BeanTest beanTest) {
		this.beanTest = beanTest;
	}

	public static void main(String[] args){
		TestBean b = new TestBean();
		System.out.println(b.getBeanTest());
		System.out.println(b.getBeanTest().getNum());
	}
}
