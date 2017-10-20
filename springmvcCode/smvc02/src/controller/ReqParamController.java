package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReqParamController {
	@RequestMapping("/goods") //url����·��/goods?id=xx&cz=edit
	public String getGoodsById(@RequestParam(value="cz") String cz,@RequestParam(value="id") int id){
		System.out.println("Ҫ���ҵ���Ʒ��id"+id);
		return "edit";
	}
	//��ҳ
	//��ͳ�ķ�ҳ pageSize=10��currPage=3
	@RequestMapping("/goods/list2") //url goods/list?pageSize=10&currpage=3
	public String selectByPage(@RequestParam(value="pageSize") int pSize,@RequestParam(value="currPage") int nowPage){
		System.out.println("ÿҳ��ʾ�ļ�¼��"+pSize+"��ǰҳ"+nowPage);
		return "list";
	}
}
