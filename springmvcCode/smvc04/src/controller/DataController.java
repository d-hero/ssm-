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
	//可以通过modelandview实现类似request的数据保存和转发的功能
	//需要jsp类型的视图
	@RequestMapping("/listUsers")
	public ModelAndView getUsers(){
		ModelAndView mav =new ModelAndView();
		//得到数据
		UserInfoDao dao =new UserInfoDao();
		List<UserInfo> list = dao.selectAll();
		//保存到request
		mav.addObject("list", list);
		//转发 ,定位到对应的视图
		//视图路径拼接结果：viewName+suffix=users.jsp
		mav.setViewName("../users");
		return mav;
	}
	@RequestMapping("/doAddUsers")
	public String doAdd(){
		//这里处理数据的新增
		//要求跳转到用户列表页面		
		return "redirect:/listUsers";
	}
	//
	@RequestMapping("/listUsers02")
	public ModelAndView getUsers02(){		
		//得到数据
		UserInfoDao dao =new UserInfoDao();
		List<UserInfo> list = dao.selectAll();	
		//采用具有三个参数的构造方法，
		//第一个是设置视图名称
		//第二设置key的名称
		//第三个就传递数据
		return new ModelAndView("../users","list",list);
	}
	//map的使用
	//如何定位到视图：map默认的视图：保存位置prefix+类的url+方法的url+suffix
	@RequestMapping("/listByMap")
	public Map  getUserByMap(){
		UserInfoDao dao =new UserInfoDao();
		List<UserInfo> list = dao.selectAll();
		Map map =new HashMap();
		map.put("aaa",list);//map。put等同于request。setAttribute
		return map;
	}
	//测试map
	@RequestMapping("/getByMap")
	public Map<String,String> getByMap(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("a", "aaaa");
		map.put("b", "bbbb");		
		
		return map;
	}
}
