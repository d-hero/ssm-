package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.UserInfoDao;
import entity.UserInfo;
@Controller
@SessionAttributes(value={"ui"})
public class LoginController {
	//掌握SessionAttribute的使用
	//验证保存成功
	//在index.jsp页面里面，如果没有登录信息，显示登录，有登录信息就显示用户名
	@RequestMapping("/myLogin")
	public ModelAndView myLogin(HttpServletResponse response,String uName,String pwd){
		//调用dao
		UserInfoDao dao =new UserInfoDao();
		UserInfo ui = dao.doLogin(uName, pwd);
		//用户名密码出错
		//返回到页面上，传递的是错误信息
		ModelAndView mav =new ModelAndView();
		String viewName = "../login";
		//这里添加上Cookie的保存
		Cookie ck =new Cookie("uName",uName);
		response.addCookie(ck);
		ck =new Cookie("pwd",pwd);
		response.addCookie(ck);
		//这里Cookie添加完毕，这里的Cookie代码是配合后面的读取
		if(ui!=null){
			viewName="../index";
			mav.addObject("ui", ui);
		}else{
			mav.addObject("msg","用户名或者密码错误");
		}
		mav.setViewName(viewName);
		return mav;
	}
}
