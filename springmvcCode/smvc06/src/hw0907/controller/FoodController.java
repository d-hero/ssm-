package hw0907.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hw0907.dao.FoodInfoDao;
import hw0907.entity.FoodInfo;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class FoodController {
	FoodInfoDao dao = new FoodInfoDao();
	@RequestMapping(value="/foods",method=RequestMethod.POST)
	public String doAdd(@RequestParam("foodImg") MultipartFile imgFile,FoodInfo foodInfo,HttpServletRequest request) throws IOException{
		//将图片保存到服务器的硬盘里面
		//web项目所在的路径
		String path = request.getServletContext().getRealPath("/");		
		//图片要保存的文件夹
		String dir = "foodImg";
		//判断文件夹是否存在
		File file =new File(path+dir);
		if(!file.exists()){
			file.mkdirs();
		}
		//图片另存为的文件名
		//建议直接取当前时间转换出来的文件名
		String newFileName = new Date().getTime()+"";
		String saveName = newFileName;//这个变量用来设置保存到表里面的文件名
		//得到原来文件的扩展名
		String orgFileName = imgFile.getOriginalFilename();
		System.out.println(orgFileName);
		//截取扩展名
		String[] tmp = orgFileName.split("\\.");
		String ext = tmp[tmp.length-1];//得到扩展名
		//得到完整的要保存的文件名
		newFileName = path+dir+"/"+newFileName+"."+ext;
		//进行保存
		FileOutputStream out = new FileOutputStream(newFileName);
		//将输入流保存到指定的地方
		FileCopyUtils.copy(imgFile.getInputStream(), out);
		//将菜品数据保存到数据库
		//img的值，也就是保存在表里面的值，建议就保存文件名
		saveName += "."+ext;
		foodInfo.setImg(saveName);
		dao.add(foodInfo);
	    //新增完毕，返回列表
		return "redirect:/foods";
	}
	//显示菜品的列表信息
	@RequestMapping(value="/foods",method=RequestMethod.GET)
	public ModelAndView getAll(){
		List<FoodInfo> list = dao.selectAll();
		return new ModelAndView("hw0907/list","list",list);
	}
}
