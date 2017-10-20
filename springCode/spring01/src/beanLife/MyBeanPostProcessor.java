package beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/***
 * ����bean�Ĺ��췽����������bean����
 * @author Administrator
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	public MyBeanPostProcessor(){
		super();
		 System.out.println("��0������BeanPostProcessorʵ���๹��������");
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
