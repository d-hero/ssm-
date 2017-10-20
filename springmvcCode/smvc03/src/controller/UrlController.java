package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {
	//·ÖÒ³ /datas?pageNum=xxx&pageSize=xxx
	@RequestMapping("/datas")
	public String getDataByPage(int pageNum,int pageSize){
		System.out.println("pageNum"+pageNum +"pageSize"+pageSize);
		return "list";
	}
}
