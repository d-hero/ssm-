package anno.mvc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("anno/mvc/beans.xml");
		UserInfoDao dao = (UserInfoDao) ac.getBean("dao");
		System.out.println(dao);
	}
	@Test
	public void tService(){
		try{
			ApplicationContext ac =new ClassPathXmlApplicationContext("anno/mvc/beans.xml");
			UserInfoService service = (UserInfoService) ac.getBean("userInfoService");
			service.show();
			System.out.println("---下面显示创建的dao---------");
			UserInfoDao dao = (UserInfoDao) ac.getBean("dao");
			System.out.println(dao);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	@Test
	public void tController(){
		
		ApplicationContext ac =new ClassPathXmlApplicationContext("anno/mvc/beans.xml");
		UserController c = (UserController) ac.getBean("userController");
		c.show();
	}
}
