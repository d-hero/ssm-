package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class RestFulController {
	//这里利用restful风格处理请求
	///films/{这里是每页显示的记录数}/{这里是当前的页码}
	@RequestMapping(value="/rfilms/{pageSize}/{pageNum}",method=RequestMethod.GET)
	public String  select(@PathVariable(value="pageSize") int pageSize,@PathVariable(value="pageNum") int pageNum){
		System.out.println("当前显示的记录数"+pageSize+"当前的页数"+pageNum);
		return "../films/list";
	}
	//这里处理的是新增界面的显示
	///rfilms/filmType
	@RequestMapping(value="/rfilms",method=RequestMethod.GET)
	public String add(){
		System.out.println("这里是定位到新增页面");
		return "../films/add";
	}
	//处理保存新增的电影数据
	@RequestMapping(value="/rfilms",method=RequestMethod.POST)
	public String doAdd(){
		System.out.println("这里进行电影数据的保存");
		//保存完毕返回列表页面
		return "../films/list";
	}
	//根据id获得编辑数据
	// /rfilms?id=xxx
	// rfilms/2
	@RequestMapping(value="/rfilms/{id}",method=RequestMethod.GET)
	public String getById(@PathVariable(value="id") int id){
		System.out.println("这里进入数据库查询，查询到对应的数据，输出到页面上");
		return "../films/edit";
	}
	//根据id保存编辑数据
	@RequestMapping(value="/rfilms/{id}",method=RequestMethod.PUT)
	public String saveById(@PathVariable(value="id") int id){
			System.out.println("这里完成用户提交的数据，进行保存");
			return "../films/list";
	}
	//根据id进行删除
	@RequestMapping(value="/rfilms/{id}",method=RequestMethod.DELETE)
	public String delById(@PathVariable(value="id") int id){
			System.out.println("这里进行数据的删除，删除成功");
			return "../films/list";
	}
}
