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
		System.out.println("��Ʒ����"+fName);
		String url = "index";
		//����Ĳ���
		//�õ���Ŀ��Ӳ��·��
		String path = request.getSession().getServletContext().getRealPath("/");//
		//����ļ��в�����Ҫ����	
		String dir = "foodImg";
		File file =new File(path+dir);
		if(!file.exists()){
			file.mkdirs();
		}
		//����Ҫ������ļ���
		//��ԭ�����ļ�������
		String fileName =mfile.getOriginalFilename();
		String saveName = path+dir+"/"+fileName;
		//����
		//ʹ��FileOutputStream 
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
		//�õ���Ŀ��Ӳ��·��
		String path = request.getServletContext().getRealPath("/file");
		//
		String fileName = "myssm.rar";
		//����Ҫ���ص��ļ�����
		File file =new File(path+"/"+fileName);
		//�ı�Ĭ�ϵ�������ݵĸ�ʽ
		HttpHeaders headers =new HttpHeaders();
		
		headers.setContentDispositionFormData("attachment", "aabbcc.rar");
		//�������ݵĸ�ʽ
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//FileUtils.readFileToByteArray(file)
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
	//��������ݵ�ҳ����
	@RequestMapping("/myfiles")
	public ModelAndView getFiles(){
		MyFileDao dao =new MyFileDao();
		List<MyFile> list = dao.select();
		return new ModelAndView("fileList","list",list);
	}
	@RequestMapping("/myFileDown/{id}")
	public ResponseEntity<byte[]> myFileDown(@PathVariable(value="id") int id,HttpServletRequest request) throws IOException{
		//���ݴ����ݿ��ȡ
		MyFileDao dao =new MyFileDao();		
		MyFile m = dao.getById(id);
		//���ص��ļ�ʹ��ԭ�ļ���
		//�õ���Ŀ��Ӳ��·��
		 String path = request.getServletContext().getRealPath("/file")+"/";
		//������Ӳ���ϵ��ļ���
		 String saveFile = m.getBcwjm();
		 String oName = m.getYwjm();
		 //����Ҫ���ص��ļ�����
		 File file=new File(path+saveFile);
		//�����ļ��������
		 oName = new String(oName.getBytes("utf-8"),"iso-8859-1");//���������������
		 //����http�����header
		 HttpHeaders headers =new HttpHeaders();
		 headers.setContentDispositionFormData("attachment", oName);
		 //���ø���������
		 headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//�����ļ��������
		 return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
}
