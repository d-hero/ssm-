package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingController {
	@RequestMapping(value="/req01",method=RequestMethod.GET)
 public String setVal(){
		System.out.println("这边是请求了request的控制器");
	 return "../../index";
 }
	@RequestMapping(value="/req01",params={"id","oper=edit"})
	public String getEdit(){
		System.out.println("这里根据id读取到值");
		return "../../index";
	}
	
}

