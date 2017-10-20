package annoAop;

import java.util.Date;
import java.util.Random;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
public class CountClass {
	//对什么样的方法起作用
	//什么样的方法执行完毕之后，才去调用下面的方法
	@Pointcut("execution(* annoAop.*.*(..))")
	private void anyMethod(){};
	//用户使用完毕吐槽功能的方法后起作用
	@AfterReturning("anyMethod()")
	public void count(){
		System.out.println("哎呀真好，又发现有人使用了afterreturning"+new Date());
	}
	@After("anyMethod()")
	public void alert(){
		System.out.println("看看跟前面的count有什么区别after"+new Date());
	}
	//@AfterThrowing("anyMethod()")
	public void doAfterThrowing() {
		System.out.println("例外通知");
	}

}
