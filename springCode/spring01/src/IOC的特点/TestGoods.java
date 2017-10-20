package IOC的特点;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGoods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("IOC的特点/beans.xml");
		IGoodsInfoDao dao = (IGoodsInfoDao) ac.getBean("goodsDao");
		dao.add();
	}

}
