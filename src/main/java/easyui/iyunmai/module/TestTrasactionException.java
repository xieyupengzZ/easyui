package easyui.iyunmai.module;

public class TestTrasactionException extends RuntimeException{
		
	public TestTrasactionException(){
		super("插入异常");
	}
	public TestTrasactionException(String mesg){
		super(mesg);
	}
}
