package annoAop;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//@Aspect
public class PrivilegeDao {
	//��ʲô�����࣬����ʲô������ʱ���ȥ�����������
	@Pointcut("execution(* annoAop.*.*(..))")
	private void any(){};
	//ʹ�ù���֮ǰ
	@Before("any()")
	public void check(){
		System.out.println("�������Ȩ�޵ļ��ͻ�ȡ"+new Date());
	}
}
