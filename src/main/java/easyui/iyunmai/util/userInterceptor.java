package easyui.iyunmai.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import easyui.iyunmai.controller.queryContro;
import easyui.iyunmai.module.user;

public class userInterceptor extends HandlerInterceptorAdapter{
	 	
	private static final Logger logger = LoggerFactory.getLogger(queryContro.class);
	
		public boolean preHandler (HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
			System.out.println("11111111111111111");
			logger.info("拦截成功");
			/*if (handler instanceof HandlerMethod) {
				HandlerMethod handlerMethod = (HandlerMethod) handler;
				
				if(handlerMethod.getBean() instanceof userInterceptor) {
					user loginUser = (user)request.getSession().getAttribute("usersession");
					
					if(loginUser == null) {
						response.sendRedirect(request.getContextPath() + "/timeOut.html" );
						return false;
					}
			
				}
			}*/
			System.out.println("22222222222222222");
			return true;
		}
}
