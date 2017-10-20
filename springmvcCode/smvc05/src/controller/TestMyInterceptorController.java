package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class TestMyInterceptorController {
	@RequestMapping("/doLogin")
	public String test01(){
		System.out.println("终于进入到控制器了"+new Date());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("终于处理完毕了"+new Date());
		return "main";
	}
	//这个方法用来验证登录拦截器的
	//登录拦截器的效果，url直接输入main，会跳转到登录
	@RequestMapping("/main")
	public String testLogin(){
		System.out.println("验证html可以进入控制器"+new Date());
		return "main";
	}
}
