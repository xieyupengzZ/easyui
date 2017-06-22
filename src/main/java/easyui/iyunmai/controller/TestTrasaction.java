package easyui.iyunmai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import easyui.iyunmai.serviceimpl.TestTrasactionServiceImpl;

@Controller("TestTrasaction")
@RequestMapping("/test-trasaction")
public class TestTrasaction extends BaseConto{

		private static final Logger logger = LoggerFactory.getLogger(TestTrasaction.class);
		
		@Autowired
		TestTrasactionServiceImpl testTrasactionServiceImpl;
		
		@RequestMapping(value="/insert-test.d",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String insertTest(@RequestParam(value="id")Integer id){
			JSONObject server = new JSONObject();
			JSONObject output = new JSONObject();
			output.put("result", server);
			try {
				boolean result = testTrasactionServiceImpl.saveInfo(id);
				if (result) {
					setInfo(server, result);
				} else {
					setInfo(server, result);
				}
			} catch (Exception e) {
				logger.error("{}",e);
				setInfo(server, false);
			}
			return output.toJSONString();
		}
}
