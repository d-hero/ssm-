package annoAop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestGoods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext ac =new ClassPathXmlApplicationContext("annoAop02/beans.xml");
		GoodsInfoDao dao = (GoodsInfoDao) ac.getBean("dao");
		dao.delGoods();

	}

}
