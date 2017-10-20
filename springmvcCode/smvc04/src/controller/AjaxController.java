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
	//����ajax��ʽ�����¼
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	@ResponseBody
	public String doLogin(String uName,String pwd){
		//�û���admin������123�ɹ�
		String result = "�û��������������,����������";
		if("admin".equals(uName) && "123".equals(pwd)){
			result = "ok";
		}
		return result;
	}
	//����ajax����õ�User���ݣ������ҳ����
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
		//Ҫ�������resposne���
		//��������ı���
		response.setContentType("text/html;charset=utf-8");
		//
		response.getWriter().print(result);
	}
}
