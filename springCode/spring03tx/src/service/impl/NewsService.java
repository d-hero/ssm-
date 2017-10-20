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
	 * 这个方法里面，一个是调用dao里面的新增，
	 * 一个是调用newsTypeService里面的新增
	 */	
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(NewsInfo ni,NewsTypeInfo nt) {
		// TODO Auto-generated method stub
		//try{
			System.out.println("这里进行新闻的新增");
			dao.add(ni);
			
			//这里去调用新闻类型的service里面的add方法
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
