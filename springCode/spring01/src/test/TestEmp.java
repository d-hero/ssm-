package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpInfoDao;

public class TestEmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//将配置文件加载进来
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
		//通过getBean得到对应的对象
		EmpInfoDao dao = (EmpInfoDao) ac.getBean("empDao");
		dao.select();
	}

}
