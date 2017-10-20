package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.GoodsInfo;

import service.inter.IGoodsInfoService;

@Controller
public class GoodsInfoController {
	@Autowired
	private IGoodsInfoService gService;
	@RequestMapping("/goods")
	public ModelAndView select(){
		ModelAndView mav =new ModelAndView();
		List<GoodsInfo> list = gService.select();
		mav.addObject("list", list);
		mav.setViewName("goods/list");
		return mav;
	}
}
