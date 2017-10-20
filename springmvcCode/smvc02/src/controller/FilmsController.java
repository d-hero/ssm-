package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmsController {
	//这个地方将电影列表数据分页显示出来
	//分页基本的信息：每页显示的记录数pageSize，当前页数pageNum
	//基本的url
	@RequestMapping(value="/films",params={"oper=list"})
	public String  select(@RequestParam(value="pageSize") int pageSize,@RequestParam(value="pageNum") int pageNum){
		System.out.println("当前显示的记录数"+pageSize+"当前的页数"+pageNum);
		return "../films/list";
	}
	@RequestMapping(value="/films",params={"oper=add"})
	public String add(){
		System.out.println("这里是定位到新增页面");
		return "../films/add";
	}
	@RequestMapping(value="/films",params={"oper=doadd"})
	public String doAdd(){
		System.out.println("这里进行电影数据的保存");
		//保存完毕返回列表页面
		return "../films/list";
	}
}
