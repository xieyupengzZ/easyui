package easyui;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Header;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  

public final class HTTPHelper {

	private static final Logger logger = LoggerFactory.getLogger(HTTPHelper.class);
	private static HttpClient httpClient = new DefaultHttpClient();

	/**
	 * 获取HTTP GET请求的Body内容
	 * 
	 * @param url
	 *            :请求URL ,如：http://www.aaa.com,http://www.aaa.com/index.html;
	 * @return String
	 * */
	public static String getRequestContent(String url) throws ClientProtocolException, IOException {
		HttpResponse response = null;
		ByteArrayOutputStream baos = null;
		InputStream is = null;
		String resultContent = null;
		try {
			response = httpClient.execute(new HttpGet(url));
			baos = new ByteArrayOutputStream();
			int i = -1;
			is = response.getEntity().getContent();
			org.apache.http.Header[] header = response.getAllHeaders();
			for(int j = 0 ; j < header.length;j ++){
				System.out.println(header[j].getName()+":"+header[j].getValue());
			}
			while ((i = is.read()) != -1) {
				baos.write(i);
			}
			resultContent = baos.toString();
		} catch (Exception e) {
			logger.error("Exception:", e);
		} finally {
			is.close();
			baos.close();
			response = null;
		}
		return resultContent;
	}

	/**
	 * 获取HTTP GET请求的Body内容
	 * 
	 * @param url
	 *            :请求URL ,如：http://www.aaa.com,http://www.aaa.com/index.html;
	 * @return String
	 * */
	@SuppressWarnings("deprecation")
	public static String getRequestContent(String url, Map<String, String> params) throws ClientProtocolException, IOException {
		HttpResponse response = null;
		String resultContent = null;
		//System.out.println("************"+params.keySet());
		try {
			StringBuffer sbParams = new StringBuffer();
			if (params != null) {
				sbParams.append(url).append("?");
				for (String key : params.keySet()) {
					if (params.containsKey(key) && StringUtils.isNotEmpty(params.get(key))) {
						sbParams.append(key).append("=").append(URLEncoder.encode(params.get(key))).append("&");
					}
				}
			}
			if (sbParams != null || sbParams.length() > 0) {
				url = sbParams.delete(sbParams.length() - 1, sbParams.length()).toString();
			}
			
			System.out.println(url);
			response = httpClient.execute(new HttpGet(url));
			if (response.getStatusLine().getStatusCode() == 200) {
				resultContent = EntityUtils.toString(response.getEntity());
			} else if (response.getStatusLine().getStatusCode() == 304) {
				resultContent = EntityUtils.toString(response.getEntity());
			} else {
				if (response.getStatusLine().getStatusCode() == 404) {
					resultContent = "呀， url 找不到";
				} else if (response.getStatusLine().getStatusCode() == 400) {
					resultContent = "呀，参数错误";
				} else if (response.getStatusLine().getStatusCode() == 500) {
					resultContent = "呀，服务器错误";
				} else {
					resultContent = response.getStatusLine().toString();
				}
			}
		} catch (Exception e) {
		}

		//FDDebug.d("QQ Login (getRequestContent): -----");
		return resultContent;
	}

	/**
	 * 返回输入流,注意要回收
	 * 
	 * @param url
	 * @return InputStream
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static InputStream requestStream(String url) throws ClientProtocolException, IOException {
		HttpResponse response = httpClient.execute(new HttpGet(url));
		InputStream is = response.getEntity().getContent();
		return is;
	}

	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public static String postRequestContent(String url, Map<String, String> params) throws IllegalStateException, IOException {
		String strResult = "";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		
		List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			postData.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData, "UTF-8");
		
		System.out.println(entity.toString());
		post.setEntity(entity);
		HttpResponse response = httpClient.execute(post);
		// 若状态码为200 ok
		if (response.getStatusLine().getStatusCode() == 200) {
			//System.out.println("ok");
			// 取出回应字串
			strResult = EntityUtils.toString(response.getEntity());
		} else {
			if (response.getStatusLine().getStatusCode() == 404) {
				strResult = "url 找不到";
				logger.error("error code:404");
			} else if (response.getStatusLine().getStatusCode() == 400) {
				strResult = "参数错误";
				logger.error("error code:400");
			} else if (response.getStatusLine().getStatusCode() == 500) {
				strResult = "服务器错误";
				logger.error("error code:500");
			} else {
				strResult = response.getStatusLine().toString();
				logger.error("error code:{}", response.getStatusLine().getStatusCode());
			}
		}
		return strResult;
	}

	/**
	 * 设置common 属性
	 * */
	public static void setCommonProperty(HttpURLConnection conn) {
		final int oneMin = 60000;
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.setConnectTimeout(oneMin);
		conn.setReadTimeout(oneMin * 5);
		conn.setRequestProperty("Accept", "text/plain,text/html,application/json;q=0.9,*/*;q=0.8");
		conn.setRequestProperty("Accept-Language", "zh-CN,zh,en;q=0.8");
		conn.setRequestProperty("Accept-Charset", "utf-8;q=0.7,*;q=0.3");
		conn.setRequestProperty("Accept-Encoding", "gzip");
		conn.setRequestProperty("User-Agent", "scall scall/spider");
	}

	public static void main(String[] args) {
		Map<String,String> params = new HashMap<String, String>();
		params.put("userName", "xieyupeng");
		params.put("password", "123");
		try {
			System.out.println(getRequestContent("http://127.0.0.1:8080/easyui/login.do",params));
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException:", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException:", e);
			e.printStackTrace();
		}

	}

}
