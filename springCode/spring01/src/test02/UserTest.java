package test02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	
	@Test
	public void test02(){
		try {
			ApplicationContext ac =new ClassPathXmlApplicationContext("test02/test02.xml");
			UserInfoService userInfoService =(UserInfoService)ac.getBean("userInfoService");
			userInfoService.show();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
