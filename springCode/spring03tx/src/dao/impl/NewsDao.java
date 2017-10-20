package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import model.NewsInfo;
import model.NewsTypeInfo;
import dao.inter.INewsDao;
import dao.mapper.NewsInfoMapper;

@Repository
public class NewsDao implements INewsDao {
	@Autowired
	private NewsInfoMapper map;	
	public void add(NewsInfo ni){
		
		this.map.add(ni);
		System.out.println("这里是新闻的dao,执行新增");
	}

}
