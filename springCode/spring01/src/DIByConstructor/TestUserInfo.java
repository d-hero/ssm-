package DIByConstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DIObject.CollectionObject;

public class TestUserInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("DIByConstructor/beans.xml");
		UserInfo co = (UserInfo) ac.getBean("u1");
		System.out.println(co);
	}

}
