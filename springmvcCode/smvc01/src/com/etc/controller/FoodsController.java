package com.etc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodsController {
	//Ĭ�ϵľ������ִ�еķ�����
	//����ֵ��String���޲εķ���
	//һ���������Զ�Ӧһ��url
	@RequestMapping("/foodsAdd")
	public String add(){
		System.out.println("�쿴����ִ�����������");
		return "add";//�������Ҫ��ʾ������ҳ����ļ�����ȥ���ļ�����Ϣ��ȥ����չ����Ϣ��
	}
}
