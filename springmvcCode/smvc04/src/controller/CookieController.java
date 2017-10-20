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
	//��Cookieд��
	@RequestMapping("writeCk")
	public String writeCookie(HttpServletResponse response){
		//response����cookie
		Cookie ck =new Cookie("ck1","my cookie 01");
		response.addCookie(ck);
		return "redirect:/readCk";//�ض���
	}
	//��Cookie��ȡ
	@RequestMapping("/readCk")
	public String readCookie(@CookieValue(value="ck1",required=false) String ck1){
		System.out.println("�ղű����Cookie��ֵ"+ck1);
		return "../readCk";
	}
	/***
	 * �������ʵ�ֶ�ȡCookie��ֵ�Ժ�Ĭ�ϵ�¼
	 */
	@RequestMapping("/welcome")
	public String defaultDoLogin(@CookieValue(value="uName",required=false) String uName,@CookieValue(value="pwd",required=false) String pwd){
		//����dao
		UserInfoDao dao =new UserInfoDao();
		UserInfo ui = dao.doLogin(uName, pwd);
		String url="../login";
		//��¼�ɹ������뵽��ҳ
		if(ui!=null){
			url = "../index";
		}
		return url; 
	}
}
