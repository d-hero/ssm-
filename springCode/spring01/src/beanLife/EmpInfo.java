package beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EmpInfo implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {		
		this.id = id;
		System.out.println("��2�������ǽ��и�ֵ"+id);
	}
	
	public String toString(){
		return id+":"+this.hashCode();
	}
	public EmpInfo(){
		System.out.println("(1)EmpInfo���캯���ĵ���");
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("��3��setBeanName�ĵ���"+name);
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("(5)setApplicationContext�ĵ���"+applicationContext);
	}
	/**
	 * �õ�spring������
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("(4)setBeanFactory�ĵ���"+beanFactory);
	}
	/**
	 * �������ú���Ը�������ֵ�����н�һ���Ĵ���
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��6��afterPropertiesSet");
	}
	
	public void init(){
		System.out.println("��7���������Լ���init�����Ĵ���");
	}
	/**
	 * �����Լ������ٷ���
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
			System.out.println("��8��������ȥʵ�ֵ�destroy����");
	}
	public void myDestroy(){
		System.out.println("��8���������Լ���destroy����");
	}
	//����һ��show����
	public void show(){
		System.out.println("hello����������"+id);
	}
}
