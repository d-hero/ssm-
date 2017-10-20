package TwoContent;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext ac =new ClassPathXmlApplicationContext("TwoContent/beans.xml");
		//ac.getBean("myClass");//即使没有被要求要做事情，这个对象也马上被生成。
	
	ClassPathResource resource = new ClassPathResource(
				"TwoContent/beans.xml");
		// 然后生成bf对象
	System.out.println("到底会不会生成");
		BeanFactory bf = new XmlBeanFactory(resource);
		//
		bf.getBean("myClass");
		//bf.getBean("myClass02");
	}

}
