package IOC���ص�;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGoods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("IOC���ص�/beans.xml");
		IGoodsInfoDao dao = (IGoodsInfoDao) ac.getBean("goodsDao");
		dao.add();
	}

}
