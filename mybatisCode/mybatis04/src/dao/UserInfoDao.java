package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;
import entity.UserInfo;

public class UserInfoDao implements IUserInfoDao {

	@Override
	public int doUpdate(UserInfo userInfo) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSession();
		// ����sqlsession����ʵ��dao
		IUserInfoDao dao = session.getMapper(IUserInfoDao.class);
		int i=dao.doUpdate(userInfo);
		session.commit();
		session.close();
		return i ;		
	}	
	
	
}
