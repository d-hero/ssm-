package test;

import model.NewsTypeInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.inter.IDeptService;
import service.inter.INewsTypeService;

public class TestNewsType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
		INewsTypeService service =  (INewsTypeService) ac.getBean("newsTypeService");
		NewsTypeInfo nt = new NewsTypeInfo();
		nt.setTypeName("АЫид");
		service.add(nt);
	}

}
