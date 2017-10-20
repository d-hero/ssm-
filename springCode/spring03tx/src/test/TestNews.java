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
		//���ʵ����������newsType����������������
		NewsTypeInfo nt = new NewsTypeInfo();
		nt.setTypeName("����"+new Date());
		//ʵ����news
		NewsInfo ni =new NewsInfo();
		ni.setTitle("��������"+new Date());
		NewsTypeInfo nt2 = new NewsTypeInfo();
		nt2.setId(1);
		ni.setNewsType(nt2);
		//����service�۲��������
		service.add(ni,nt);
		System.out.println("�����ɹ�");
	}
	@Test
	public void addNews(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
		INewsDao service =  (INewsDao) ac.getBean("newsDao");
		/*NewsTypeInfo nt = new NewsTypeInfo();
		nt.setTypeName("����");*/
		//ʵ����news
		NewsInfo ni =new NewsInfo();
		ni.setTitle("��������"+new Date());
		NewsTypeInfo nt2 = new NewsTypeInfo();
		nt2.setId(1);
		ni.setNewsType(nt2);
		//����service�۲��������
		service.add(ni);
		System.out.println("�����ɹ�");
	}

}
