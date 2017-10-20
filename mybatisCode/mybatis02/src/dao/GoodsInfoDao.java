package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;

import entity.GoodsInfo;

public class GoodsInfoDao implements IGoodsInfoDao {

	@Override
	public List<GoodsInfo> search(String str, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		try{
			SqlSession session = MybatisUtil.getSession();
			// ����sqlsession����ʵ��dao
			IGoodsInfoDao dao = session.getMapper(IGoodsInfoDao.class);
			List<GoodsInfo> list =dao.search(str, pageSize, pageNum);
			//sqlsession�ر�
			session.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void add(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSession();
		// ����sqlsession����ʵ��dao
		IGoodsInfoDao dao = session.getMapper(IGoodsInfoDao.class);
		dao.add(goodsInfo);
		session.commit();
		session.close();
	}

	@Override
	public int addGoods(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSession();
		// ����sqlsession����ʵ��dao
		IGoodsInfoDao dao = session.getMapper(IGoodsInfoDao.class);
		System.out.println("����֮ǰû��ֵ"+goodsInfo.getId());
		dao.addGoods(goodsInfo);
		session.commit();
		session.close();
		System.out.println("����֮��"+goodsInfo.getId());
		return goodsInfo.getId();
	}

}
