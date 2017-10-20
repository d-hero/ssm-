package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.MyFileDao;
import entity.MyFile;

@Controller
public class FileController {
	@RequestMapping("/addFood")
	public String doUpload(@RequestParam("foodImg") MultipartFile mfile,HttpServletRequest request,String fName){
		System.out.println("菜品名称"+fName);
		String url = "index";
		//传输的步骤
		//得到项目的硬盘路径
		String path = request.getSession().getServletContext().getRealPath("/");//
		//如果文件夹不存在要创建	
		String dir = "foodImg";
		File file =new File(path+dir);
		if(!file.exists()){
			file.mkdirs();
		}
		//设置要保存的文件名
		//用原来的文件名保存
		String fileName =mfile.getOriginalFilename();
		String saveName = path+dir+"/"+fileName;
		//保存
		//使用FileOutputStream 
		try {
			FileOutputStream  fos = new FileOutputStream(saveName);
			FileCopyUtils.copy(mfile.getInputStream(), fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	@RequestMapping("/downFile")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException{
		//得到项目的硬盘路径
		String path = request.getServletContext().getRealPath("/file");
		//
		String fileName = "myssm.rar";
		//生成要下载的文件对象
		File file =new File(path+"/"+fileName);
		//改变默认的输出内容的格式
		HttpHeaders headers =new HttpHeaders();
		
		headers.setContentDispositionFormData("attachment", "aabbcc.rar");
		//设置内容的格式
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//FileUtils.readFileToByteArray(file)
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
	//先输出数据到页面上
	@RequestMapping("/myfiles")
	public ModelAndView getFiles(){
		MyFileDao dao =new MyFileDao();
		List<MyFile> list = dao.select();
		return new ModelAndView("fileList","list",list);
	}
	@RequestMapping("/myFileDown/{id}")
	public ResponseEntity<byte[]> myFileDown(@PathVariable(value="id") int id,HttpServletRequest request) throws IOException{
		//数据从数据库读取
		MyFileDao dao =new MyFileDao();		
		MyFile m = dao.getById(id);
		//下载的文件使用原文件名
		//得到项目的硬盘路径
		 String path = request.getServletContext().getRealPath("/file")+"/";
		//保存在硬盘上的文件名
		 String saveFile = m.getBcwjm();
		 String oName = m.getYwjm();
		 //生成要下载的文件对象
		 File file=new File(path+saveFile);
		//中文文件名的输出
		 oName = new String(oName.getBytes("utf-8"),"iso-8859-1");//解决中文乱码问题
		 //设置http里面的header
		 HttpHeaders headers =new HttpHeaders();
		 headers.setContentDispositionFormData("attachment", oName);
		 //设置附件的内容
		 headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//设置文件流的输出
		 return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
}
