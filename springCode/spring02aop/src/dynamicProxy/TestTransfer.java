package dynamicProxy;

import java.lang.reflect.Proxy;

public class TestTransfer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccountDao dao =new BankAccountDao();//被代理，也是被服务的对象
		//日志对象
		LogInfoDao logDao = new LogInfoDao();//需要增强的功能
		//创建出代理对象，具体的服务接待对接的代理人员
		LogProxy proxy = new LogProxy(dao,logDao);
		//生成具有转账功能的代理对象，开始执行我们需要的操作
		IBankAccountDao accProxy = (IBankAccountDao) Proxy.newProxyInstance(LogProxy.class.getClassLoader(), 
				new Class[]{IBankAccountDao.class}, proxy);
		accProxy.transfer();
		
	}

}
