package com.etc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodsController {
	//默认的经典可以执行的方法是
	//返回值是String，无参的方法
	//一个方法可以对应一个url
	@RequestMapping("/foodsAdd")
	public String add(){
		System.out.println("快看，有执行这个方法了");
		return "add";//这个就是要显示的新增页面的文件名，去掉文件夹信息，去掉扩展名信息，
	}
}
