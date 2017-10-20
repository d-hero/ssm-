package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.IGoodsInfoDao;

import entity.GoodsInfo;
import service.inter.IGoodsInfoService;
@Service
public class GoodsInfoService implements IGoodsInfoService {
	@Autowired
	private IGoodsInfoDao gDao;
	@Override
	public List<GoodsInfo> select() {
		// TODO Auto-generated method stub
		return gDao.select();
	}
	
}
