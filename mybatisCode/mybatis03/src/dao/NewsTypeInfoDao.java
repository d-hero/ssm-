package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;


import entity.NewsTypeInfo;

public class NewsTypeInfoDao implements INewsTypeDao {

	@Override
	public List<NewsTypeInfo> getAll() {
		// TODO Auto-generated method stub
		try{
			SqlSession session = MybatisUtil.getSession();
			// ����sqlsession����ʵ��dao
			INewsTypeDao dao = session.getMapper(INewsTypeDao.class);
			List<NewsTypeInfo> list =dao.getAll();
			//sqlsession�ر�
			session.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

}
