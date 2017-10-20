package beanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
	public static void main(String[] args) {
		ApplicationContext ac =new ClassPathXmlApplicationContext("beanscope/beans.xml");
		Class01 c =(Class01) ac.getBean("class01");
		Class01 c1 =(Class01) ac.getBean("class01");
		System.out.println(c+":"+c1);
	}
}
