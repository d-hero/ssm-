package DIObject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("DIObject/beans.xml");
		UserController u=(UserController) ac.getBean("userController");
		u.add();
	}
	@Test
	public void listref(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("DIObject/beans.xml");
		CollectionObject co = (CollectionObject) ac.getBean("co");
		co.show();
	}
}
