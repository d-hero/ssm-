package test;

import java.util.Date;

import model.NewsInfo;
import model.NewsTypeInfo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.impl.NewsDao;
import dao.inter.INewsDao;

import service.inter.INewsService;
import service.inter.INewsTypeService;

public class TestNews {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
		INewsService service =   (INewsService) ac.getBean("newsService");
		//这个实例化出来的newsType对象，是用来新增的
		NewsTypeInfo nt = new NewsTypeInfo();
		nt.setTypeName("八卦"+new Date());
		//实例化news
		NewsInfo ni =new NewsInfo();
		ni.setTitle("下雨下雨"+new Date());
		NewsTypeInfo nt2 = new NewsTypeInfo();
		nt2.setId(1);
		ni.setNewsType(nt2);
		//调用service观察事务管理
		service.add(ni,nt);
		System.out.println("新增成功");
	}
	@Test
	public void addNews(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
		INewsDao service =  (INewsDao) ac.getBean("newsDao");
		/*NewsTypeInfo nt = new NewsTypeInfo();
		nt.setTypeName("八卦");*/
		//实例化news
		NewsInfo ni =new NewsInfo();
		ni.setTitle("下雨下雨"+new Date());
		NewsTypeInfo nt2 = new NewsTypeInfo();
		nt2.setId(1);
		ni.setNewsType(nt2);
		//调用service观察事务管理
		service.add(ni);
		System.out.println("新增成功");
	}

}
