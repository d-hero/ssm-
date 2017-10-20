package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods") //url����ʼλ�ø�·����http://ip��ַ:�˿ں�/��Ŀ����/
public class GoodsController {
	//������Ʒ���������޸ģ�ɾ������ѯ����
	@RequestMapping("list") //��������ķ���·����http://ip��ַ:�˿ں�/��Ŀ����/goods/list
	public String list(){
		System.out.println("�����˸��ֲ�ѯ���õ����ݣ������Ʒ���ݵ�ҳ��");
		return "list";
	}
	@RequestMapping("add") 
	public String add(){
		System.out.println("���ﴦ������");
		return "add";
	}
	@RequestMapping("edit") 
	public String edit(){
		System.out.println("������ʾ�޸�ҳ��");
		return "edit";
	}
	//�������ϣ�����ص���ҳ
	@RequestMapping("index")
	public String toIndex(){
		System.out.println("�������������ҳ");
		return "../../index";
	}
}
