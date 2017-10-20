package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogProxy implements InvocationHandler {
	//定义一个object属性，用来接收要代理的对象
	private Object target;
	private LogInfoDao logDao;//要让代理的对象增强的功能，这里是日志功能
	public LogProxy(){
		
	}
    public LogProxy(Object target,LogInfoDao logDao){
		this.target =target;
		this.logDao = logDao;
	}
	/**
	 * 调用这个方法的时候，要调用日志功能
	 * 以及是每个功能模块处理完毕后都要调用 日志功能
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		//这里来调用模块类的核心功能
		//完成转账
		Object returnVal = method.invoke(target, args);
		//调用日志dao
		this.logDao.addLog();
		return returnVal;
	}

}
