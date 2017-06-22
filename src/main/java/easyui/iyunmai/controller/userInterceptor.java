package easyui.iyunmai.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import easyui.iyunmai.module.user;

public class userInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(userInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("进入拦截器");
		String requestPath = request.getServletPath();
		String menuAction = requestPath.split("/")[requestPath.split("/").length - 1];
		logger.info("menuAction：" + menuAction);
		if(!menuAction.contains("login.do")){
			user loginUser = (user)request.getSession().getAttribute("user");
			
			if(loginUser == null){
				String cookieName = "easyuiSessionId";
			    Cookie cookies[] = request.getCookies();
			    
			    if (cookies!=null){
			    	for(Cookie c : cookies){
					    if (cookieName.equals(c.getName())){
					    	System.out.println(c.getValue());
					    	JSONObject cookieJson  = JSON.parseObject(c.getValue());
					    	HttpSessionContext SessCon= request.getSession(false).getSessionContext();
					    	System.out.println(cookieJson.getString("id"));
					    	//HttpSession Sess = SessCon.getSession(cookieJson.getString("id"));
					    	//System.out.println(Sess.getAttribute("user").toString());
					    	return super.preHandle(request, response, handler); 
					    }
			        }
			        System.out.println(">>>>>>>loginUser==null");
					//如果是ajax请求响应头会有，x-requested-with；  
					if(request.getHeader("x-requested-with") != null&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
						response.setHeader("sessionstatus", "timeout");//在响应头设置session状态 在js中判断响应状态
					}else{
						request.getRequestDispatcher("/timeOut.html").forward(request, response);
					}
			        return false;
			    }else{
				    	System.out.println(">>>>>>>loginUser==null");
						//如果是ajax请求响应头会有，x-requested-with；  
						if(request.getHeader("x-requested-with") != null&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
							response.setHeader("sessionstatus", "timeout");//在响应头设置session状态 在js中判断响应状态
						}else{
							request.getRequestDispatcher("/timeOut.html").forward(request, response);
						}
						return false;
			    	}
			    
			}else{
				System.out.println(">>>>>>>loginUser ："+loginUser.getUsername());
				return super.preHandle(request, response, handler);
			}
		}else{
			return super.preHandle(request, response, handler);
		}
	}
	
}
