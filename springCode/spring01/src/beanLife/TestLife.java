package beanLife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 

public class TestLife {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beanLife/beans.xml");
		System.out.println("----ac:-----"+ac);
		EmpInfo ei =  (EmpInfo) ac.getBean("emp");
		ei.show();
		//ei = null;
		ac.close();//对象交给spring以后，销毁也是由spring容器销毁的
	}

}
