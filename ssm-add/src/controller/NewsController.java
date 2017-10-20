package controller;

import model.NewsInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.inter.INewsService;
import service.inter.INewsTypeService;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private INewsService newss;
	@Autowired
	private INewsTypeService newsNt;
	/**
	 * 要先得到新闻类型
	 * @return
	 */
	@RequestMapping("add")
	public ModelAndView getType(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("news/add");
		mav.addObject("typeList", newsNt.getAll());
		return mav;
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String doAdd(NewsInfo ni){
		String str="";
		newss.add(ni);
		//新增完毕，重新回到新增页面
		str = "redirect:/news/add";
		return str;
	}
}
