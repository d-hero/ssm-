package annoAop02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//�����aspect,�ǹ�����������
@Aspect
public class DBUtil {
	//pointcut����
	@Pointcut("execution(* annoAop02.*Dao.*(..))")
	private void any(){};
	@Before("any()")
	public void getConn(){
		System.out.println("��ִ��sql֮ǰ����Ҫ���ӣ��Ϳ�����");
	}
	@After("any()")
	public void commit(){
		System.out.println("ִ�����֮�󣬵������������Ұ�æ�ر�");
		System.out.println("��æ�ر����ݿ�");
	}
}
