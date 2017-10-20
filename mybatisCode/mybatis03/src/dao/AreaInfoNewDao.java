package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;

import entity.AreaInfo;
import entity.AreaInfoNew;

public class AreaInfoNewDao implements IAreaInfoNewDao {

	@Override
	public List<AreaInfoNew> getAll() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSession();
		 IAreaInfoNewDao dao = session.getMapper(IAreaInfoNewDao.class);
		 List<AreaInfoNew> list=null;
		 list = dao.getAll();
		return list;
	}

}
