package annoAop;

import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
public class LogDao {
	@Pointcut("execution(* annoAop.*.add*(..))")
	private void any(){};
	@Before("any()") //advice
	public void addLog(){
		System.out.println("我又添加了一条日志"+new Date());
	}
}
