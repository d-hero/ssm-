package mytest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.GoodsInfo;

import service.inter.IGoodsInfoService;

public class TestGoods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
		IGoodsInfoService gs = (IGoodsInfoService) ac.getBean("goodsInfoService");
		List<GoodsInfo> list =gs.select();
		System.out.println(list.get(0).getGoodsTypeInfo().getTypeName());
	}

}
