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
	//���������ѯ�����е��û�����
	@RequestMapping("users")
	public ModelAndView selectAll(){
		
	  	 return new ModelAndView("user/list","list",list);
	}
	//����id��ѯ�������û�����
	@RequestMapping("users/{id}")
	public ModelAndView getUserById(@PathVariable(value="id") Integer id){
		 //ע���Բ���������dao		 
		 return new ModelAndView("user/edit","ui",list.get(id));
	}
	
	//����Ϊmap
	//mapֻЯ�����ݣ�view��Ĭ��ֵ��Ĭ�ϵ�view·����prefix+��·��/����·��+suffix
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
