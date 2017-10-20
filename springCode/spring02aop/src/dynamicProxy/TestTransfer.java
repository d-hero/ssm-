package dynamicProxy;

import java.lang.reflect.Proxy;

public class TestTransfer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccountDao dao =new BankAccountDao();//������Ҳ�Ǳ�����Ķ���
		//��־����
		LogInfoDao logDao = new LogInfoDao();//��Ҫ��ǿ�Ĺ���
		//������������󣬾���ķ���Ӵ��ԽӵĴ�����Ա
		LogProxy proxy = new LogProxy(dao,logDao);
		//���ɾ���ת�˹��ܵĴ�����󣬿�ʼִ��������Ҫ�Ĳ���
		IBankAccountDao accProxy = (IBankAccountDao) Proxy.newProxyInstance(LogProxy.class.getClassLoader(), 
				new Class[]{IBankAccountDao.class}, proxy);
		accProxy.transfer();
		
	}

}
