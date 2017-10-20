package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmsController {
	//����ط�����Ӱ�б����ݷ�ҳ��ʾ����
	//��ҳ��������Ϣ��ÿҳ��ʾ�ļ�¼��pageSize����ǰҳ��pageNum
	//������url
	@RequestMapping(value="/films",params={"oper=list"})
	public String  select(@RequestParam(value="pageSize") int pageSize,@RequestParam(value="pageNum") int pageNum){
		System.out.println("��ǰ��ʾ�ļ�¼��"+pageSize+"��ǰ��ҳ��"+pageNum);
		return "../films/list";
	}
	@RequestMapping(value="/films",params={"oper=add"})
	public String add(){
		System.out.println("�����Ƕ�λ������ҳ��");
		return "../films/add";
	}
	@RequestMapping(value="/films",params={"oper=doadd"})
	public String doAdd(){
		System.out.println("������е�Ӱ���ݵı���");
		//������Ϸ����б�ҳ��
		return "../films/list";
	}
}
