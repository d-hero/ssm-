package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import dao.UserInfoDao;
import entity.UserInfo;

@Controller
public class AjaxController {
	//利用ajax方式处理登录
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	@ResponseBody
	public String doLogin(String uName,String pwd){
		//用户名admin，密码123成功
		String result = "用户名或者密码错误,请重新输入";
		if("admin".equals(uName) && "123".equals(pwd)){
			result = "ok";
		}
		return result;
	}
	//利用ajax请求得到User数据，填充在页面上
	@RequestMapping("/getUsers")
	@ResponseBody
	public String getUserByAjax(){
		String result =null;
		//
		UserInfoDao dao =new UserInfoDao();
		List<UserInfo> list = dao.selectAll();
		Gson gson = new Gson();
		result =gson.toJson(list);
		System.out.println("result"+result);
		return result;
	}
	@RequestMapping("/getUsers02")
	public void getUsers(HttpServletResponse response) throws IOException{
		String result =null;
		//
		UserInfoDao dao =new UserInfoDao();
		List<UserInfo> list = dao.selectAll();
		Gson gson = new Gson();
		result =gson.toJson(list);
		System.out.println("result"+result);
		//要将结果让resposne输出
		//设置输出的编码
		response.setContentType("text/html;charset=utf-8");
		//
		response.getWriter().print(result);
	}
}
