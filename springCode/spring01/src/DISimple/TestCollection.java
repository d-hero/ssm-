package DISimple;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollection {
	@Test
	public void listDi(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("DISimple/beans.xml");
		CollectionDI di =(CollectionDI) ac.getBean("collectionDI");
		di.show();
		di.showMap();
	}
}
