package TwoContent;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestBeanFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��Ҫ����Resouce������غ������ļ�
		ClassPathResource resource = new ClassPathResource("TwoContent/beans.xml");
		//Ȼ������bf����
		BeanFactory bf = new XmlBeanFactory(resource);
		MyClass my = (MyClass) bf.getBean("myClass");
		my.show();
	}

}
