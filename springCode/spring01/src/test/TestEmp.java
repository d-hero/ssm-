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
		//�������ļ����ؽ���
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
		//ͨ��getBean�õ���Ӧ�Ķ���
		EmpInfoDao dao = (EmpInfoDao) ac.getBean("empDao");
		dao.select();
	}

}
