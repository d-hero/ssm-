package beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/***
 * 调用bean的构造方法来创建出bean的类
 * @author Administrator
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	public MyBeanPostProcessor(){
		super();
		 System.out.println("（0）这是BeanPostProcessor实现类构造器！！");
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		LogInfoDao dao = new LogInfoDao();
		dao.addLog();
		System.out.println("postProcessBeforeInitialization:"+bean+" beanName:"+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		LogInfoDao dao = new LogInfoDao();
		dao.addLog();
		System.out.println("postProcessAfterInitialization:"+bean+" beanName:"+beanName);

		return bean;
	}

}
