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
		//ac.getBean("myClass");//��ʹû�б�Ҫ��Ҫ�����飬�������Ҳ���ϱ����ɡ�
	
	ClassPathResource resource = new ClassPathResource(
				"TwoContent/beans.xml");
		// Ȼ������bf����
	System.out.println("���׻᲻������");
		BeanFactory bf = new XmlBeanFactory(resource);
		//
		bf.getBean("myClass");
		//bf.getBean("myClass02");
	}

}
