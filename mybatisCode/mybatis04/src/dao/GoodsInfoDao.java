package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;


import entity.GoodsInfo;

public class GoodsInfoDao implements IGoodsInfoDao {

	@Override
	public List<GoodsInfo> search(String gName, int pMin, int pMax) {
		SqlSession session = MybatisUtil.getSession();
		// 利用sqlsession生成实体dao
		IGoodsInfoDao dao = session.getMapper(IGoodsInfoDao.class);
		List<GoodsInfo> list =dao.search(gName,pMin,pMax);
		//sqlsession关闭
		session.close();
		return list;
	
	}

	@Override
	public int doUpdate(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSession();
		// 利用sqlsession生成实体dao
		IGoodsInfoDao dao = session.getMapper(IGoodsInfoDao.class);
		int i=dao.doUpdate(goodsInfo);
		session.commit();
		session.close();
		return i ;
	}

	@Override
	public List<GoodsInfo> searchByTypeId(String[] typeArr) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSession();
		// 利用sqlsession生成实体dao
		IGoodsInfoDao dao = session.getMapper(IGoodsInfoDao.class);		
		List<GoodsInfo> list =dao.searchByTypeId(typeArr);
		//sqlsession关闭
		session.close();
		return list;
	}

}
