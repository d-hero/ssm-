package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.INewsDao;
import model.NewsInfo;
import service.inter.INewsService;
@Service
public class NewsService implements INewsService {
	@Autowired
	private INewsDao dao;
	@Override
	@Transactional
	public void add(NewsInfo ni) {
		// TODO Auto-generated method stub
		System.out.println("����������ŵ�����");
		dao.add(ni);
	}

}
