package test;

import java.util.Date;
import java.util.List;

import model.NewsInfo;
import model.NewsTypeInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.inter.INewsService;

import dao.inter.INewsTypeDao;

public class TestType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
		INewsService dao = (INewsService) ac.getBean("newsService");
		NewsInfo ni =new NewsInfo();
		ni.setTitle("ÏÂÖÜ¶ËÎç½Ú"+new Date());
		NewsTypeInfo nt2 = new NewsTypeInfo();
		nt2.setId(2);
		ni.setNewsType(nt2);
		dao.add(ni);
	}

}
