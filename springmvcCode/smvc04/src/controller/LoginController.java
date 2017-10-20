package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.UserInfoDao;
import entity.UserInfo;
@Controller
@SessionAttributes(value={"ui"})
public class LoginController {
	//����SessionAttribute��ʹ��
	//��֤����ɹ�
	//��index.jspҳ�����棬���û�е�¼��Ϣ����ʾ��¼���е�¼��Ϣ����ʾ�û���
	@RequestMapping("/myLogin")
	public ModelAndView myLogin(HttpServletResponse response,String uName,String pwd){
		//����dao
		UserInfoDao dao =new UserInfoDao();
		UserInfo ui = dao.doLogin(uName, pwd);
		//�û����������
		//���ص�ҳ���ϣ����ݵ��Ǵ�����Ϣ
		ModelAndView mav =new ModelAndView();
		String viewName = "../login";
		//���������Cookie�ı���
		Cookie ck =new Cookie("uName",uName);
		response.addCookie(ck);
		ck =new Cookie("pwd",pwd);
		response.addCookie(ck);
		//����Cookie�����ϣ������Cookie��������Ϻ���Ķ�ȡ
		if(ui!=null){
			viewName="../index";
			mav.addObject("ui", ui);
		}else{
			mav.addObject("msg","�û��������������");
		}
		mav.setViewName(viewName);
		return mav;
	}
}
