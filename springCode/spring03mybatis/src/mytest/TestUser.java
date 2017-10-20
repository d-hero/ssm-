package mytest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserInfoDao;
import entity.UserInfo;

public class TestUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("config/beans.xml");
		UserInfoDao dao =(UserInfoDao) ac.getBean("userInfoDao");
		List<UserInfo> list = dao.getAll();
		System.out.println(list.size());
	}

}
