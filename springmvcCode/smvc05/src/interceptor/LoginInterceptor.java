package interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String[] IGNORE_URL={"/main.html","/doLogin"};
	/**
	 * 实现登录拦截器
	 * 目的：如果没有登录，就不能够进入当前的url,必须退回到登录页面
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		boolean flag =false;
		//得到当前请求的url
		String url = request.getRequestURI();
		//然后判断url里面是否包含必须ingore
		for(String s:IGNORE_URL){
			if(url.contains(s)){
				
				flag = true;System.out.println("可以不需要登录就可以进入的界面"+new Date().getTime());
				return flag;
			}
		}
		//获得session
		HttpSession session =request.getSession();
		//取出保存用户信息的key对应的value,key=userInfo
		Object user = session.getAttribute("userInfo");		
		//value不等于null，就往下走,返回true,就可以进入到对应的控制器类里面的方法
		if(user!=null){
			flag = true;
		}else{
			//进入登录页面
			//注意的是url使用绝对路径
			System.out.println("url=login.index"+new Date().getTime());
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			url = basePath+"login.jsp";
			response.sendRedirect(url);
		}
		//false,就退回到指定的页面
		return flag;
	}
}
