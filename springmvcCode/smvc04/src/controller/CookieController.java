package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserInfoDao;
import entity.UserInfo;

@Controller
public class CookieController {
	//将Cookie写入
	@RequestMapping("writeCk")
	public String writeCookie(HttpServletResponse response){
		//response保存cookie
		Cookie ck =new Cookie("ck1","my cookie 01");
		response.addCookie(ck);
		return "redirect:/readCk";//重定向
	}
	//将Cookie读取
	@RequestMapping("/readCk")
	public String readCookie(@CookieValue(value="ck1",required=false) String ck1){
		System.out.println("刚才保存的Cookie的值"+ck1);
		return "../readCk";
	}
	/***
	 * 这个方法实现读取Cookie的值以后默认登录
	 */
	@RequestMapping("/welcome")
	public String defaultDoLogin(@CookieValue(value="uName",required=false) String uName,@CookieValue(value="pwd",required=false) String pwd){
		//调用dao
		UserInfoDao dao =new UserInfoDao();
		UserInfo ui = dao.doLogin(uName, pwd);
		String url="../login";
		//登录成功，进入到首页
		if(ui!=null){
			url = "../index";
		}
		return url; 
	}
}
