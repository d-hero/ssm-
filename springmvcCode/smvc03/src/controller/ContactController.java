package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ContactInfoDao;
import dao.ContactTypeDao;

import entity.ContactInfo;
import entity.ContactType;

@Controller
public class ContactController {
	ContactInfoDao dao =new ContactInfoDao();
	//�������������������ݣ�post
	@RequestMapping(value="/contact",method=RequestMethod.POST)
	public String doAdd(ContactInfo cInfo){
		System.out.println(cInfo);
		int i = dao.addContact(cInfo);
		System.out.println(i);
		return "../index";
	}
	//Ҫ����add.jsp֮ǰ����Ҫͨ������������
	//
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ModelAndView getContactType(){
		//ģ������ݿ��õ�����
		List<ContactType> list =new ArrayList<ContactType>();
		ContactType ct =new ContactType();
		ct.setTypeId(1);
		ct.setTypeName("����");
		list.add(ct);
		ct =new ContactType();
		ct.setTypeId(2);
		ct.setTypeName("����");
		list.add(ct);
		ct =new ContactType();
		ct.setTypeId(3);
		ct.setTypeName("ͬѧ");
		list.add(ct);
		//�����ݴ��ݸ�modelANdview
		return new ModelAndView("../0905hw/add","list",list);
	}
	//ͨ��get����õ���������
	//url��/contact/all
	@RequestMapping(value="/contact/{type}",method=RequestMethod.GET)
	public ModelAndView select(@PathVariable(value="type") String type){
		List<ContactInfo> list = dao.selectAll();
		return new ModelAndView("../0905hw/list","list",list);
	}
	//����restful��������ɾ��
	//����id�õ�����
	//�����ݴ��뵽�޸�ҳ��
	//ֻ��һ��id���ǰ��Ĳ������ͻ��url��contact/detail/1
	@RequestMapping(value="/contact/{type}/{id}",method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable(value="id")Integer id){
		//Ҫ��2�����ݶ���
		//һ������ϵ������
		//ģ������ݿ��õ�����
				List<ContactType> list =new ArrayList<ContactType>();
				ContactType ct =new ContactType();
				ct.setTypeId(1);
				ct.setTypeName("����");
				list.add(ct);
				ct =new ContactType();
				ct.setTypeId(2);
				ct.setTypeName("����");
				list.add(ct);
				ct =new ContactType();
				ct.setTypeId(3);
				ct.setTypeName("ͬѧ");
				list.add(ct);
		//��ϵ����Ϣ
		ContactInfo ci = dao.getByid(id);
		ModelAndView mav =new ModelAndView();
		mav.addObject("list", list);//���ｫ��ϵ��������ӽ���
		mav.addObject("cinfo", ci);
		mav.setViewName("../0905hw/update");//���������޸ĵ�ҳ��
		return mav;
	}
	//�����޸ĵ�����
	//����ɹ��󷵻ص��б�ҳ��
	@RequestMapping(value="/contact/{id}",method=RequestMethod.POST)
	public String updateById(ContactInfo cinfo){
		dao.updateContactInfo(cinfo);//ֱ�ӵ���dao����ķ�������
		return "redirect:/contact/all";
	}
}
