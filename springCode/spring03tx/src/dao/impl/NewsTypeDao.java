package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import model.NewsTypeInfo;
import dao.inter.INewsTypeDao;
import dao.mapper.NewsTypeInfoMapper;
@Repository
public class NewsTypeDao implements INewsTypeDao {
	@Autowired
	private NewsTypeInfoMapper ntMapper;
	@Override
	public void add(NewsTypeInfo nt) {
		// TODO Auto-generated method stub
		this.ntMapper.add(nt);
	}

}
