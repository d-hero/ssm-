package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.GoodsInfo;
import entity.GoodsTypeInfo;

@Controller
public class FormController {
	@RequestMapping("/doLogin")
	public String doLogin(String userName,String pwd){
		System.out.println("�û���"+userName+"����"+pwd);
		return "../index";
	}
	//���������Ʒ������
	@RequestMapping("/doAdd")
	public  String doAddd(String gName,double price,String remark,String kdate){
		System.out.println(gName +":"+price+":"+remark+":"+kdate);
		return "../index";
	}
	//����ͨ�����������Ʒ������
	@RequestMapping("/doAdd2")
	public String doGoods(GoodsInfo goodsInfo){
		System.out.println(goodsInfo);
		return "../index";
	}
	@RequestMapping("/doAdd3")
	public String doGoodsByType(GoodsInfo goodsInfo){	
		
		System.out.println(goodsInfo);
		return "../index";
	}
	@RequestMapping(value="/addByJson",method=RequestMethod.POST)
	public String addGoodsByJson(GoodsInfo goodsInfo){
		System.out.println(goodsInfo);
		return "../index";
	}
}
