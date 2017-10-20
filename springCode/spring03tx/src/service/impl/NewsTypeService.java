package service.impl;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.INewsTypeDao;
import model.NewsTypeInfo;
import service.inter.INewsTypeService;
@Service
public class NewsTypeService implements INewsTypeService {
	//注意这里是dao，而且是接口
	@Autowired
	private INewsTypeDao dao;
	@Override
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(NewsTypeInfo nt) {
		// TODO Auto-generated method stub
		
		dao.add(nt);
		System.out.println("新闻类型保存成功");
		//直接抛出异常，来证明事务的管理特性
		throw new RuntimeException("newsTypeError");
	}

}
