package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.INewsTypeDao;

import mapperDao.INewsTypeMapper;
import model.NewsTypeInfo;
import service.inter.INewsTypeService;
@Service
public class NewsTypeService implements INewsTypeService {
	@Autowired
	private INewsTypeDao dao;
	@Transactional
	public List<NewsTypeInfo> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
