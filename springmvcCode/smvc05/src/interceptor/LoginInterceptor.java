package interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String[] IGNORE_URL={"/main.html","/doLogin"};
	/**
	 * ʵ�ֵ�¼������
	 * Ŀ�ģ����û�е�¼���Ͳ��ܹ����뵱ǰ��url,�����˻ص���¼ҳ��
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		boolean flag =false;
		//�õ���ǰ�����url
		String url = request.getRequestURI();
		//Ȼ���ж�url�����Ƿ��������ingore
		for(String s:IGNORE_URL){
			if(url.contains(s)){
				
				flag = true;System.out.println("���Բ���Ҫ��¼�Ϳ��Խ���Ľ���"+new Date().getTime());
				return flag;
			}
		}
		//���session
		HttpSession session =request.getSession();
		//ȡ�������û���Ϣ��key��Ӧ��value,key=userInfo
		Object user = session.getAttribute("userInfo");		
		//value������null����������,����true,�Ϳ��Խ��뵽��Ӧ�Ŀ�����������ķ���
		if(user!=null){
			flag = true;
		}else{
			//�����¼ҳ��
			//ע�����urlʹ�þ���·��
			System.out.println("url=login.index"+new Date().getTime());
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			url = basePath+"login.jsp";
			response.sendRedirect(url);
		}
		//false,���˻ص�ָ����ҳ��
		return flag;
	}
}
