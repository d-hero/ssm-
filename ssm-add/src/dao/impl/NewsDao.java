package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mapperDao.INewsMapper;
import mapperDao.INewsTypeMapper;
import model.NewsInfo;
import dao.inter.INewsDao;
@Repository
public class NewsDao implements INewsDao {
	@Autowired
	private INewsMapper mapper;
	@Override
	public void add(NewsInfo ni) {
		// TODO Auto-generated method stub
		mapper.add(ni);
		mapper.getResultByTitle();
	}

}
