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
		System.out.println("（2）这里是进行赋值"+id);
	}
	
	public String toString(){
		return id+":"+this.hashCode();
	}
	public EmpInfo(){
		System.out.println("(1)EmpInfo构造函数的调用");
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("（3）setBeanName的调用"+name);
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("(5)setApplicationContext的调用"+applicationContext);
	}
	/**
	 * 得到spring的容器
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("(4)setBeanFactory的调用"+beanFactory);
	}
	/**
	 * 属性设置后可以根据属性值，进行进一步的处理
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("（6）afterPropertiesSet");
	}
	
	public void init(){
		System.out.println("（7）这里是自己的init方法的处理");
	}
	/**
	 * 创建自己的销毁方法
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
			System.out.println("（8）这里是去实现的destroy方法");
	}
	public void myDestroy(){
		System.out.println("（8）这里是自己的destroy方法");
	}
	//定义一个show方法
	public void show(){
		System.out.println("hello，声明周期"+id);
	}
}
