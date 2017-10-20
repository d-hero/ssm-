package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods") //url的起始位置根路径：http://ip地址:端口号/项目名称/
public class GoodsController {
	//负责商品的新增，修改，删除，查询操作
	@RequestMapping("list") //这个方法的访问路径：http://ip地址:端口号/项目名称/goods/list
	public String list(){
		System.out.println("经过了各种查询，得到数据，输出商品数据到页面");
		return "list";
	}
	@RequestMapping("add") 
	public String add(){
		System.out.println("这里处理新增");
		return "add";
	}
	@RequestMapping("edit") 
	public String edit(){
		System.out.println("这里显示修改页面");
		return "edit";
	}
	//这个方法希望返回到首页
	@RequestMapping("index")
	public String toIndex(){
		System.out.println("这个方法返回首页");
		return "../../index";
	}
}
