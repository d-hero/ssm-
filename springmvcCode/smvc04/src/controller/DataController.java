package controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserInfoDao;
import entity.UserInfo;

@Controller
public class DataController {
	//����ͨ��modelandviewʵ������request�����ݱ����ת���Ĺ���
	//��Ҫjsp���͵���ͼ
	@RequestMapping("/listUsers")
	public ModelAndView getUsers(){
		ModelAndView mav =new ModelAndView();
		//�õ�����
		UserInfoDao dao =new UserInfoDao();
		List<UserInfo> list = dao.selectAll();
		//���浽request
		mav.addObject("list", list);
		//ת�� ,��λ����Ӧ����ͼ
		//��ͼ·��ƴ�ӽ����viewName+suffix=users.jsp
		mav.setViewName("../users");
		return mav;
	}
	@RequestMapping("/doAddUsers")
	public String doAdd(){
		//���ﴦ�����ݵ�����
		//Ҫ����ת���û��б�ҳ��		
		return "redirect:/listUsers";
	}
	//
	@RequestMapping("/listUsers02")
	public ModelAndView getUsers02(){		
		//�õ�����
		UserInfoDao dao =new UserInfoDao();
		List<UserInfo> list = dao.selectAll();	
		//���þ������������Ĺ��췽����
		//��һ����������ͼ����
		//�ڶ�����key������
		//�������ʹ�������
		return new ModelAndView("../users","list",list);
	}
	//map��ʹ��
	//��ζ�λ����ͼ��mapĬ�ϵ���ͼ������λ��prefix+���url+������url+suffix
	@RequestMapping("/listByMap")
	public Map  getUserByMap(){
		UserInfoDao dao =new UserInfoDao();
		List<UserInfo> list = dao.selectAll();
		Map map =new HashMap();
		map.put("aaa",list);//map��put��ͬ��request��setAttribute
		return map;
	}
	//����map
	@RequestMapping("/getByMap")
	public Map<String,String> getByMap(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("a", "aaaa");
		map.put("b", "bbbb");		
		
		return map;
	}
}
