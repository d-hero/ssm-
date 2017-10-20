package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;

import entity.GoodsInfo;

public class GoodsInfoDao implements IGoodsInfoDao{

	@Override
	public List<GoodsInfo> getAll() {
		// TODO Auto-generated method stub
		try{
			SqlSession session = MybatisUtil.getSession();
			// 利用sqlsession生成实体dao
			IGoodsInfoDao dao = session.getMapper(IGoodsInfoDao.class);
			List<GoodsInfo> list =dao.getAll();
			//sqlsession关闭
			session.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

}
