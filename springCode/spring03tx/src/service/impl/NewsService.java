package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.INewsDao;

import model.NewsInfo;
import model.NewsTypeInfo;
import service.inter.INewsService;
import service.inter.INewsTypeService;
 
@Service
public class NewsService implements INewsService {
	@Autowired
	private INewsDao dao;
	@Autowired
	private INewsTypeService ntService;	
	/**
	 * ����������棬һ���ǵ���dao�����������
	 * һ���ǵ���newsTypeService���������
	 */	
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(NewsInfo ni,NewsTypeInfo nt) {
		// TODO Auto-generated method stub
		//try{
			System.out.println("����������ŵ�����");
			dao.add(ni);
			
			//����ȥ�����������͵�service�����add����
			try{
				ntService.add(nt);
			}catch(Exception ex){
				
			}
			
			//throw new RuntimeException("newsinfoError");
		/*}catch(Exception ex){
			ex.printStackTrace();
		}*/
		
	}

}
