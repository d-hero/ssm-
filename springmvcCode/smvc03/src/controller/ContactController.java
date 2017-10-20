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
	//这里代表处理的是新增数据，post
	@RequestMapping(value="/contact",method=RequestMethod.POST)
	public String doAdd(ContactInfo cInfo){
		System.out.println(cInfo);
		int i = dao.addContact(cInfo);
		System.out.println(i);
		return "../index";
	}
	//要访问add.jsp之前，需要通过控制器调用
	//
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ModelAndView getContactType(){
		//模拟从数据库拿到数据
		List<ContactType> list =new ArrayList<ContactType>();
		ContactType ct =new ContactType();
		ct.setTypeId(1);
		ct.setTypeName("家人");
		list.add(ct);
		ct =new ContactType();
		ct.setTypeId(2);
		ct.setTypeName("朋友");
		list.add(ct);
		ct =new ContactType();
		ct.setTypeId(3);
		ct.setTypeName("同学");
		list.add(ct);
		//将数据传递给modelANdview
		return new ModelAndView("../0905hw/add","list",list);
	}
	//通过get请求得到所有数据
	//url：/contact/all
	@RequestMapping(value="/contact/{type}",method=RequestMethod.GET)
	public ModelAndView select(@PathVariable(value="type") String type){
		List<ContactInfo> list = dao.selectAll();
		return new ModelAndView("../0905hw/list","list",list);
	}
	//利用restful风格完成增删改
	//根据id得到数据
	//将数据传入到修改页面
	//只有一个id会跟前面的查找起冲突，url：contact/detail/1
	@RequestMapping(value="/contact/{type}/{id}",method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable(value="id")Integer id){
		//要传2个数据对象
		//一个是联系人类型
		//模拟从数据库拿到数据
				List<ContactType> list =new ArrayList<ContactType>();
				ContactType ct =new ContactType();
				ct.setTypeId(1);
				ct.setTypeName("家人");
				list.add(ct);
				ct =new ContactType();
				ct.setTypeId(2);
				ct.setTypeName("朋友");
				list.add(ct);
				ct =new ContactType();
				ct.setTypeId(3);
				ct.setTypeName("同学");
				list.add(ct);
		//联系人信息
		ContactInfo ci = dao.getByid(id);
		ModelAndView mav =new ModelAndView();
		mav.addObject("list", list);//这里将联系人类型添加进来
		mav.addObject("cinfo", ci);
		mav.setViewName("../0905hw/update");//这里设置修改的页面
		return mav;
	}
	//保存修改的数据
	//保存成功后返回到列表页面
	@RequestMapping(value="/contact/{id}",method=RequestMethod.POST)
	public String updateById(ContactInfo cinfo){
		dao.updateContactInfo(cinfo);//直接调用dao里面的方法保存
		return "redirect:/contact/all";
	}
}
