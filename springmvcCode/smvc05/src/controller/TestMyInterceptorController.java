package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class TestMyInterceptorController {
	@RequestMapping("/doLogin")
	public String test01(){
		System.out.println("���ڽ��뵽��������"+new Date());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���ڴ��������"+new Date());
		return "main";
	}
	//�������������֤��¼��������
	//��¼��������Ч����urlֱ������main������ת����¼
	@RequestMapping("/main")
	public String testLogin(){
		System.out.println("��֤html���Խ��������"+new Date());
		return "main";
	}
}
