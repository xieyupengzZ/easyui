package jedis;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

public class JedisTest {

	public static void main(String[] args) {
		String key = "mq_comment_paste_to_[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
		String HOST = "20ae6bea2700418a.m.cnqda.kvstore.aliyuncs.com";
		int PORT = 6379;
		String PASSWORD = "20ae6bea2700418a:HO9letest";
		Jedis jedis = new Jedis(HOST, PORT);
		//jedis.auth(PASSWORD);
		
		ScanParams params = new ScanParams();
		params.match(key);
		
		ScanResult<String> scanResult = jedis.scan("0", params);
		List<String> results = scanResult.getResult();
		
		List<String> lists = new ArrayList<String>();
		lists.addAll(results);
		System.out.println(JSONObject.toJSONString(lists));
	}

}
