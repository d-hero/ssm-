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
		//��ͼƬ���浽��������Ӳ������
		//web��Ŀ���ڵ�·��
		String path = request.getServletContext().getRealPath("/");		
		//ͼƬҪ������ļ���
		String dir = "foodImg";
		//�ж��ļ����Ƿ����
		File file =new File(path+dir);
		if(!file.exists()){
			file.mkdirs();
		}
		//ͼƬ���Ϊ���ļ���
		//����ֱ��ȡ��ǰʱ��ת���������ļ���
		String newFileName = new Date().getTime()+"";
		String saveName = newFileName;//��������������ñ��浽��������ļ���
		//�õ�ԭ���ļ�����չ��
		String orgFileName = imgFile.getOriginalFilename();
		System.out.println(orgFileName);
		//��ȡ��չ��
		String[] tmp = orgFileName.split("\\.");
		String ext = tmp[tmp.length-1];//�õ���չ��
		//�õ�������Ҫ������ļ���
		newFileName = path+dir+"/"+newFileName+"."+ext;
		//���б���
		FileOutputStream out = new FileOutputStream(newFileName);
		//�����������浽ָ���ĵط�
		FileCopyUtils.copy(imgFile.getInputStream(), out);
		//����Ʒ���ݱ��浽���ݿ�
		//img��ֵ��Ҳ���Ǳ����ڱ������ֵ������ͱ����ļ���
		saveName += "."+ext;
		foodInfo.setImg(saveName);
		dao.add(foodInfo);
	    //������ϣ������б�
		return "redirect:/foods";
	}
	//��ʾ��Ʒ���б���Ϣ
	@RequestMapping(value="/foods",method=RequestMethod.GET)
	public ModelAndView getAll(){
		List<FoodInfo> list = dao.selectAll();
		return new ModelAndView("hw0907/list","list",list);
	}
}
