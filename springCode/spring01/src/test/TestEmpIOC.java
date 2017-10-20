package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.IEmpInfoDao;

public class TestEmpIOC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
		IEmpInfoDao dao = (IEmpInfoDao) ac.getBean("empDao");
		dao.select();
	}

}
