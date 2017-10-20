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
	//ע��������dao�������ǽӿ�
	@Autowired
	private INewsTypeDao dao;
	@Override
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(NewsTypeInfo nt) {
		// TODO Auto-generated method stub
		
		dao.add(nt);
		System.out.println("�������ͱ���ɹ�");
		//ֱ���׳��쳣����֤������Ĺ�������
		throw new RuntimeException("newsTypeError");
	}

}
