package annoAop;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//@Aspect
public class PrivilegeDao {
	//对什么样的类，调用什么方法的时候才去调用这个功能
	@Pointcut("execution(* annoAop.*.*(..))")
	private void any(){};
	//使用功能之前
	@Before("any()")
	public void check(){
		System.out.println("这里进行权限的检测和获取"+new Date());
	}
}
