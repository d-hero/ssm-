package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestUserController {
	//列表显示
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String select(@PathVariable("type") String type){
		System.out.println("读取出所有用户信息休息休息"+new Date());
		return "../../myuser/list";
	}
	//修改	 
	//根据id获得编辑数据
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String getById(@PathVariable(value = "id") int id) {
		System.out.println("这里进入数据库查询，查询到对应的数据，输出到页面上");
		return "../../myuser/edit";
	}
	//save data
	//根据id保存编辑数据
	@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
	public String saveById(@PathVariable(value = "id") int id) {
		System.out.println("这里完成用户提交的数据，进行保存" + id);
		return "../../myuser/list";
	}
	//保存注册用户的信息
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public String doReg(){
		System.out.println("这里完成用户的注册"+new Date());
		return "../../login";
	}
	
}
