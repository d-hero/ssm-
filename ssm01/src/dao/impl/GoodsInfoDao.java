package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.IGoodsInfoDao;
import dao.mapper.GoodsMapper;
import entity.GoodsInfo;
@Repository
public class GoodsInfoDao implements IGoodsInfoDao {
	//添加依赖的对象
	@Autowired
	private GoodsMapper gMapper;
	@Override
	public List<GoodsInfo> select() {
		// TODO Auto-generated method stub
		return gMapper.select();
	}
	

}
