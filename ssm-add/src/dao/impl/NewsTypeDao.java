package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mapperDao.INewsTypeMapper;
import model.NewsTypeInfo;
import dao.inter.INewsTypeDao;
@Repository
public class NewsTypeDao implements INewsTypeDao {
	@Autowired
	private INewsTypeMapper mapper;
	
	public List<NewsTypeInfo> getAll() {
		// TODO Auto-generated method stub
		return mapper.getAll();
	}

}
