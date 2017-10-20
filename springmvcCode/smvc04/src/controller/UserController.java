package controller;

import java.util.*;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import entity.*;

@Controller
public class UserController {
	private static List<UserInfo> list;
	static {
		list = new ArrayList<UserInfo>();
		UserInfo ui = new UserInfo();
		ui.setId(0);
		
		UserInfo ui2 = new UserInfo();
		ui2.setId(1);
		
		list.add(ui);
		list.add(ui2);
	}
	//这个方法查询出所有的用户数据
	@RequestMapping("users")
	public ModelAndView selectAll(){
		
	  	 return new ModelAndView("user/list","list",list);
	}
	//根据id查询出单个用户数据
	@RequestMapping("users/{id}")
	public ModelAndView getUserById(@PathVariable(value="id") Integer id){
		 //注意脑补出调用用dao		 
		 return new ModelAndView("user/edit","ui",list.get(id));
	}
	
	//返回为map
	//map只携带数据，view是默认值，默认的view路径：prefix+类路径/方法路径+suffix
	//jsp/userMap.jsp
	@RequestMapping("/userMap")
	public Map getMap(){
		Map<String,UserInfo> map = new HashMap<String,UserInfo>();
		for(UserInfo ui:list){
			map.put(ui.getId()+"", ui);
		}
		return map;
	}
	
	
}
