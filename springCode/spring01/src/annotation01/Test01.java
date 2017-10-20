package annotation01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
 public static void main(String[] args) {
	 ApplicationContext ac =new ClassPathXmlApplicationContext("annotation01/beans.xml");
	 MyClass m = (MyClass) ac.getBean("myClass");
	 m.show();
}
}
