package easyui.iyunmai.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

import easyui.iyunmai.module.TestBean;

public class BaseConto {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseConto.class);
	public void setInfo(JSONObject info,boolean result){
		
		if(result){
			info.put("code", 0);
			info.put("mes", "操作成功！");
		}else{
			info.put("code",	 -1);
			info.put("mes", "操作失败！");
		}
	}
	public void uploadFile(InputStream filestream,String path,String filename){
		FileOutputStream outputStream = null;
		try {
			 outputStream = new FileOutputStream(path+filename);
			byte[] bytes = new byte[1024*1024];
			int byteread;
			while((byteread = filestream.read(bytes))!=-1){
				outputStream.write(bytes,0,byteread);
				outputStream.flush();
			}
			outputStream.close();
			filestream.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("upload error : "+e);
		}
	}
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		TestBean testBean = (TestBean) ac.getBean("testBean");
		testBean.out();
	}
}
