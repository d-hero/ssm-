package interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	/**
	 * 调用视图并且渲染完毕视图之后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("03现在是进入到afterCompletion"+new Date().getTime());
	}
	/***
	 * 完成控制器的具体方法之后进入视图之前调用
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("02现在是进入到postHandle"+new Date());
	}
	/**
	 * 在控制器处理用户的请求之前
	 * 进入对应的控制器，调用方法之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("01现在是进入到preHandle"+new Date());
		return true;//不然就真的被拦截，走不到控制器对应的方法里面
	}

}
