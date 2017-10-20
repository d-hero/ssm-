package annoAop02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//这个是aspect,是公共功能类型
@Aspect
public class DBUtil {
	//pointcut配置
	@Pointcut("execution(* annoAop02.*Dao.*(..))")
	private void any(){};
	@Before("any()")
	public void getConn(){
		System.out.println("在执行sql之前，需要连接，就靠我啦");
	}
	@After("any()")
	public void commit(){
		System.out.println("执行完毕之后，调用事务处理，并且帮忙关闭");
		System.out.println("帮忙关闭数据库");
	}
}
