package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.UserInfo;

@Controller
@SessionAttributes(value={"ui"})
public class ServletObjectController {
	//�õ�Request
	//url:/testReq?id=&name
	@RequestMapping("/testReq")
	public String testReq(HttpServletRequest request){
		//����ͨ��url���ݲ�������request��ò���
		//�����������request�������ݣ���ҳ����ȥ��ȡ����
		//
		System.out.println("id"+request.getParameter("id"));
		System.out.println("name"+request.getParameter("name"));
		request.setAttribute("req", "from request");
		return "../index";
	}
	//�õ�session
	@RequestMapping("/testSession")
	public String testSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("sess", "from session");
		return "../index";
	}
	//sessionAttributes���ModelAndview
	//����ֵ������modelAndview
	//�����¼�����ҵ�¼�ɹ���
	//��õ�һ���û�����
	@RequestMapping("/testSession2")
	public ModelAndView testSession(){
		ModelAndView mav =new ModelAndView();
		UserInfo ui =new UserInfo();
		ui.setuName("admin");
		ui.setPwd("123");
		mav.addObject("ui", ui);//��������Ѷ��󱣴�����������ĸ����ö������棿
		mav.setViewName("../index");
		return mav;
	}
}
