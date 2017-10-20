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
		//需要利用Resouce对象加载好配置文件
		ClassPathResource resource = new ClassPathResource("TwoContent/beans.xml");
		//然后生成bf对象
		BeanFactory bf = new XmlBeanFactory(resource);
		MyClass my = (MyClass) bf.getBean("myClass");
		my.show();
	}

}
