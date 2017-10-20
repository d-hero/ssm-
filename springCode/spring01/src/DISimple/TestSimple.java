package DISimple;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSimple {
	@Test
	public void emp(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("DISimple/beans.xml");
		EmpInfo ei = (EmpInfo) ac.getBean("empInfo");
		System.out.println(ei);
	}
	@Test
	public void dbutil(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("DISimple/beans.xml");
		DBUtil ei = (DBUtil) ac.getBean("dBUtil");
		System.out.println(ei);
	}
}
