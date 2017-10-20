package interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	/**
	 * ������ͼ������Ⱦ�����ͼ֮�����
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("03�����ǽ��뵽afterCompletion"+new Date().getTime());
	}
	/***
	 * ��ɿ������ľ��巽��֮�������ͼ֮ǰ����
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("02�����ǽ��뵽postHandle"+new Date());
	}
	/**
	 * �ڿ����������û�������֮ǰ
	 * �����Ӧ�Ŀ����������÷���֮ǰ
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("01�����ǽ��뵽preHandle"+new Date());
		return true;//��Ȼ����ı����أ��߲�����������Ӧ�ķ�������
	}

}
