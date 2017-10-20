package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class RestFulController {
	//��������restful���������
	///films/{������ÿҳ��ʾ�ļ�¼��}/{�����ǵ�ǰ��ҳ��}
	@RequestMapping(value="/rfilms/{pageSize}/{pageNum}",method=RequestMethod.GET)
	public String  select(@PathVariable(value="pageSize") int pageSize,@PathVariable(value="pageNum") int pageNum){
		System.out.println("��ǰ��ʾ�ļ�¼��"+pageSize+"��ǰ��ҳ��"+pageNum);
		return "../films/list";
	}
	//���ﴦ����������������ʾ
	///rfilms/filmType
	@RequestMapping(value="/rfilms",method=RequestMethod.GET)
	public String add(){
		System.out.println("�����Ƕ�λ������ҳ��");
		return "../films/add";
	}
	//�����������ĵ�Ӱ����
	@RequestMapping(value="/rfilms",method=RequestMethod.POST)
	public String doAdd(){
		System.out.println("������е�Ӱ���ݵı���");
		//������Ϸ����б�ҳ��
		return "../films/list";
	}
	//����id��ñ༭����
	// /rfilms?id=xxx
	// rfilms/2
	@RequestMapping(value="/rfilms/{id}",method=RequestMethod.GET)
	public String getById(@PathVariable(value="id") int id){
		System.out.println("����������ݿ��ѯ����ѯ����Ӧ�����ݣ������ҳ����");
		return "../films/edit";
	}
	//����id����༭����
	@RequestMapping(value="/rfilms/{id}",method=RequestMethod.PUT)
	public String saveById(@PathVariable(value="id") int id){
			System.out.println("��������û��ύ�����ݣ����б���");
			return "../films/list";
	}
	//����id����ɾ��
	@RequestMapping(value="/rfilms/{id}",method=RequestMethod.DELETE)
	public String delById(@PathVariable(value="id") int id){
			System.out.println("����������ݵ�ɾ����ɾ���ɹ�");
			return "../films/list";
	}
}
