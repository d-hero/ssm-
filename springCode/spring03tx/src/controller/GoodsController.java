package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import entity.GoodsInfo;

import service.inter.IGoodsInfoService;

@Controller
public class GoodsController {
	@Autowired
	private IGoodsInfoService gService;
	public List<GoodsInfo> select(){
		return gService.select();
	} 
}
