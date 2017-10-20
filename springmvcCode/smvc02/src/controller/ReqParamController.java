package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReqParamController {
	@RequestMapping("/goods") //url：根路径/goods?id=xx&cz=edit
	public String getGoodsById(@RequestParam(value="cz") String cz,@RequestParam(value="id") int id){
		System.out.println("要查找的商品的id"+id);
		return "edit";
	}
	//分页
	//传统的分页 pageSize=10，currPage=3
	@RequestMapping("/goods/list2") //url goods/list?pageSize=10&currpage=3
	public String selectByPage(@RequestParam(value="pageSize") int pSize,@RequestParam(value="currPage") int nowPage){
		System.out.println("每页显示的记录数"+pSize+"当前页"+nowPage);
		return "list";
	}
}
