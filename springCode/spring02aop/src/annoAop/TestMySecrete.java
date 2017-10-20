package annoAop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMySecrete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext ac =new ClassPathXmlApplicationContext("annoAop/beans.xml");
		 MySecrete ms = (MySecrete) ac.getBean("mySecrete");
		 ms.say();
	}
	@Test
	public void add(){
		try{
			ApplicationContext ac =new ClassPathXmlApplicationContext("annoAop/beans.xml");
			 UserInfoDao ms = (UserInfoDao) ac.getBean("userInfoDao");
			 //System.out.println(ms);
			 ms.addUser();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		 
	}
}
