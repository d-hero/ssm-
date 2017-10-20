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
	//��ʲô���ķ���������
	//ʲô���ķ���ִ�����֮�󣬲�ȥ��������ķ���
	@Pointcut("execution(* annoAop.*.*(..))")
	private void anyMethod(){};
	//�û�ʹ������²۹��ܵķ�����������
	@AfterReturning("anyMethod()")
	public void count(){
		System.out.println("��ѽ��ã��ַ�������ʹ����afterreturning"+new Date());
	}
	@After("anyMethod()")
	public void alert(){
		System.out.println("������ǰ���count��ʲô����after"+new Date());
	}
	//@AfterThrowing("anyMethod()")
	public void doAfterThrowing() {
		System.out.println("����֪ͨ");
	}

}
