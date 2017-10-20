package mytest;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.impl.GoodsInfoService;
import service.inter.IGoodsInfoService;

import controller.GoodsController;
import entity.GoodsInfo;

public class TestGoods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
		GoodsController gc =(GoodsController) ac.getBean("goodsController");
		/*List<GoodsInfo> list = gc.select();
		System.out.println(list.size());*/
	}
	@Test
	public void testAdd(){
		try{
			ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
			IGoodsInfoService gc =(IGoodsInfoService) ac.getBean("goodsInfoService");
			//GoodsInfoService gc =(GoodsInfoService) ac.getBean("goodsInfoService");
			gc.add(null);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
