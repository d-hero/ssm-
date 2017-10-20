package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;

import entity.AreaInfo;


public class AreaInfoDao implements IAreaInfoDao {

	@Override
	public List<AreaInfo> getAll() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSession();
		 IAreaInfoDao dao = session.getMapper(IAreaInfoDao.class);
		 List<AreaInfo> list=null;
		 list = dao.getAll();
		return list;
	}

}
