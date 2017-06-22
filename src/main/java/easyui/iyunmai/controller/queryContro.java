package easyui.iyunmai.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import easyui.iyunmai.util.EncoderUtil;
import easyui.iyunmai.module.menu;
import easyui.iyunmai.module.restaurant;
import easyui.iyunmai.module.user;
import easyui.iyunmai.service.queryService;

@Controller("queryContro")
@RequestMapping("/user")
public class queryContro extends BaseConto {
	
	private static final Logger logger = LoggerFactory.getLogger(queryContro.class);
		@Autowired
	    private queryService queryservice;
		
		
		@RequestMapping(value="/uploadFile.do",produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String uploadfile(@RequestParam("fileup") MultipartFile file){
			JSONObject result = new JSONObject();
			JSONObject info = new JSONObject();
			result.put("info", info);
			if(file == null){
				System.out.println("文件空");
				setInfo(info,false);
			}else{
				try {
					file.getName();
					uploadFile(file.getInputStream(),"/upload/",file.getOriginalFilename());
					setInfo(info,true);
					System.out.println("文件上传成功");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return JSONObject.toJSONString(result);
		}
		
		@RequestMapping(value="/queryRes.do",produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String queryre(){
			
			List<restaurant> reslist = new ArrayList<restaurant>();
			reslist = queryservice.queryrestaurant();
			List<JSONObject> Creslist = new ArrayList<JSONObject>();
			for(int  i = 0 ; i < reslist.size(); i ++){
				JSONObject res = new JSONObject();
				res.put("text",reslist.get(i).getName());
				res.put("id",reslist.get(i).getId());
				Creslist.add(res);
			}
			logger.info(JSONArray.toJSONString(Creslist));
			return JSONArray.toJSONString(Creslist); //返回tree结构必须要是一个list
			
		}
		@RequestMapping(value="/queryRestree.do",method = { RequestMethod.POST,RequestMethod.GET }, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String queryRes(){ 
			List<restaurant> reslist = new ArrayList<restaurant>();
			reslist = queryservice.queryrestaurant();
			List<JSONObject> Creslist = new ArrayList<JSONObject>();
			List<JSONObject> Preslist = new ArrayList<JSONObject>();
			JSONObject Pres = new JSONObject();
			for(int  i = 0 ; i < reslist.size(); i ++){
				JSONObject res = new JSONObject();
				res.put("text",reslist.get(i).getName());
				res.put("attributes",reslist.get(i).getId());
				Creslist.add(res);
			}
			Pres.put("text", "菜馆");
			Pres.put("children", Creslist);
			Preslist.add(Pres);
			logger.info(JSONArray.toJSONString(Preslist));
			return JSONArray.toJSONString(Preslist); //返回tree结构必须要是一个list
		}
		@RequestMapping(value="/queryFoodByResid.do",method = { RequestMethod.POST,RequestMethod.GET }, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String queryFoodByResid(@RequestParam(value = "resid",required = false) Integer resId,@RequestParam("page") int page, @RequestParam("rows") int rows){
			System.out.println("resid:"+resId);
			JSONObject menupage = new JSONObject();
			List<menu> menulist = new ArrayList<menu>();
			int beginOffset = (page-1)*rows;
			logger.info(page+"@@@@"+rows);
			menulist = queryservice.queryFoodByResid(resId,beginOffset,rows);
			int countmenu = queryservice.queryMenuCountByResid(resId);
			menupage.put("total", countmenu);
			menupage.put("rows", menulist);
			logger.info("总记录数"+countmenu);
			logger.info(JSON.toJSONString(menupage));
			return menupage.toJSONString();
			//return JSONObject.toJSONString(menulist);
		}
		
		//通过model向jsp页面返回数据
		@RequestMapping(value="/test2.do")
		public String test2(HttpServletRequest request,Model model){
			List<menu> menulist = new ArrayList<menu>();
			menulist = queryservice.queryMenu();
			String name = request.getParameter("name");
			System.out.println("hello , "+name);
			model.addAttribute("name", name);
			model.addAttribute("foodname", menulist.get(0).getFood());
			return "test1";
		}
		//返回json数据
		@RequestMapping(value="/tijiao.do",method = { RequestMethod.POST,RequestMethod.GET }, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String querymenu(HttpServletRequest request,Model model,HttpServletResponse response){
			
			List<restaurant> reslist = new ArrayList<restaurant>();
			reslist = queryservice.queryrestaurant();
			JSONObject pres = new JSONObject();
			JSONObject pres2 = new JSONObject();
			JSONObject pres3 = new JSONObject();
			List<JSONObject> clist = new ArrayList<JSONObject>();
			List<JSONObject> plist = new ArrayList<JSONObject>();
			for(restaurant resau : reslist){
				JSONObject cres = new JSONObject();
				cres.put("text", resau.getName());
				cres.put("attributes", resau.getId());
				clist.add(cres);
			}
			pres.put("text", "餐馆");
			pres.put("children", clist);
			pres2.put("text", "查询");
			pres2.put("attributes","query.html");
			pres3.put("text", "对象设计页面");
			pres3.put("attributes","objectDesign.html");
			plist.add(pres);
			plist.add(pres2);
			plist.add(pres3);
			
			logger.info(JSON.toJSONString(plist));
			return JSONArray.toJSONString( plist); //返回tree结构必须要是一个list
		}
		//登陆
		@RequestMapping(value = "/login.do",method = { RequestMethod.POST,RequestMethod.GET }, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String login(@RequestParam("userName") String userName,@RequestParam("password") String password,HttpServletResponse response,HttpServletRequest request){
			
			JSONObject out = new JSONObject();
			JSONObject info = new JSONObject();
			JSONObject data = new JSONObject();
			out.put("info", info);
			out.put("data", data);
			String encodePwd =EncoderUtil.encodePassword(password, userName);
			user loginuser = queryservice.queryuserBynameAndword(userName, encodePwd);
			logger.info(JSON.toJSONString(loginuser));
			if(loginuser!=null){
						data.put("user", loginuser);
						setInfo(info, true);
			}else{
				setInfo(info, false);
			}
			addSessionAndCookie(request.getSession(),response,loginuser);
			return out.toJSONString();
		}

		public void addSessionAndCookie(HttpSession session,HttpServletResponse response, user users) {
			session.setAttribute("user", users);
			session.setMaxInactiveInterval(30*60);//半小时过期
			String sessionId = session.getId();
			Cookie easyuiUserCookie = new Cookie("easyuiUser", "{'id':'" + users.getId() + "','userName':'" + users.getUsername() + "'}");
			Cookie easyuiSessionIdCookie = new Cookie("easyuiSessionId", "{'id':'" + sessionId + "'}");
			if (!(System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1)) {
				//easyuiUserCookie.setDomain("easyui");//跨域是把cookie设置在某个域名下
			}
			easyuiUserCookie.setMaxAge(30*60);//半个小时过期
			easyuiSessionIdCookie.setMaxAge(30*60);
			easyuiUserCookie.setPath("/");
			easyuiSessionIdCookie.setPath("/easyui/");
			response.addCookie(easyuiUserCookie);//把cookie加入到响应报文中，可以在Set-Cookie属性中看到
			response.addCookie(easyuiSessionIdCookie);
		}
	
}
