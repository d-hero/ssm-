package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogProxy implements InvocationHandler {
	//����һ��object���ԣ���������Ҫ����Ķ���
	private Object target;
	private LogInfoDao logDao;//Ҫ�ô���Ķ�����ǿ�Ĺ��ܣ���������־����
	public LogProxy(){
		
	}
    public LogProxy(Object target,LogInfoDao logDao){
		this.target =target;
		this.logDao = logDao;
	}
	/**
	 * �������������ʱ��Ҫ������־����
	 * �Լ���ÿ������ģ�鴦����Ϻ�Ҫ���� ��־����
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		//����������ģ����ĺ��Ĺ���
		//���ת��
		Object returnVal = method.invoke(target, args);
		//������־dao
		this.logDao.addLog();
		return returnVal;
	}

}
