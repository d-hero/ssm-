package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.UserInfo;

@Controller
@SessionAttributes(value={"ui"})
public class ServletObjectController {
	//得到Request
	//url:/testReq?id=&name
	@RequestMapping("/testReq")
	public String testReq(HttpServletRequest request){
		//可以通过url传递参数，让request获得参数
		//可以利用这个request保存数据，在页面上去获取数据
		//
		System.out.println("id"+request.getParameter("id"));
		System.out.println("name"+request.getParameter("name"));
		request.setAttribute("req", "from request");
		return "../index";
	}
	//得到session
	@RequestMapping("/testSession")
	public String testSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("sess", "from session");
		return "../index";
	}
	//sessionAttributes配合ModelAndview
	//返回值必须用modelAndview
	//处理登录，并且登录成功了
	//会得到一个用户对象
	@RequestMapping("/testSession2")
	public ModelAndView testSession(){
		ModelAndView mav =new ModelAndView();
		UserInfo ui =new UserInfo();
		ui.setuName("admin");
		ui.setPwd("123");
		mav.addObject("ui", ui);//这个方法把对象保存在哪里？？？哪个内置对象里面？
		mav.setViewName("../index");
		return mav;
	}
}
