package DIObject.MVC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("DIObject/MVC/beans.xml");
		GoodsInfoController gc = (GoodsInfoController) ac.getBean("controller");
		gc.goodsList();
	}

}
