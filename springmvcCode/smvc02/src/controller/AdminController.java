package controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("show")
	public String select(){
		System.out.println("这里查询出管理员的数据");
		return "../admin/list";
	}
}
