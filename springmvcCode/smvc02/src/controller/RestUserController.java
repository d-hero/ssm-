package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestUserController {
	//�б���ʾ
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String select(@PathVariable("type") String type){
		System.out.println("��ȡ�������û���Ϣ��Ϣ��Ϣ"+new Date());
		return "../../myuser/list";
	}
	//�޸�	 
	//����id��ñ༭����
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String getById(@PathVariable(value = "id") int id) {
		System.out.println("����������ݿ��ѯ����ѯ����Ӧ�����ݣ������ҳ����");
		return "../../myuser/edit";
	}
	//save data
	//����id����༭����
	@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
	public String saveById(@PathVariable(value = "id") int id) {
		System.out.println("��������û��ύ�����ݣ����б���" + id);
		return "../../myuser/list";
	}
	//����ע���û�����Ϣ
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public String doReg(){
		System.out.println("��������û���ע��"+new Date());
		return "../../login";
	}
	
}
