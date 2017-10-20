package anno.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("anno/mvc/beans.xml");
		OrderService os = (OrderService) ac.getBean("orderService");
		os.addOrder();
	}

}
