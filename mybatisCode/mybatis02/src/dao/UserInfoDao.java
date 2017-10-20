package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;
import entity.UserInfo;

public class UserInfoDao implements IUserInfoDao {	
	@Override
	public UserInfo doLogin(UserInfo userInfo) {
		// 创建sqlsession
		SqlSession session = MybatisUtil.getSession();
		// 利用sqlsession生成实体dao
		IUserInfoDao dao = session.getMapper(IUserInfoDao.class);
		userInfo =dao.doLogin(userInfo);
		//sqlsession关闭
		session.close();
		return userInfo;
	}

	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		int num=0;
		// 创建sqlsession
		SqlSession session = MybatisUtil.getSession();
		// 利用sqlsession生成实体dao
		IUserInfoDao dao = session.getMapper(IUserInfoDao.class);
		num = dao.getUserCount();
		session.close();
		return num;
	}

	@Override
	public UserInfo doLogin02(String name, String pwd, int id) {
		// TODO Auto-generated method stub
		// 创建sqlsession
		SqlSession session = MybatisUtil.getSession();
		// 利用sqlsession生成实体dao
		IUserInfoDao dao = session.getMapper(IUserInfoDao.class);
		UserInfo userInfo = dao.doLogin02(name,pwd,id);
		// sqlsession关闭
		session.close();
		return userInfo;
	}

	@Override
	public List<UserInfo> getByPage(int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		// 创建sqlsession
		SqlSession session = MybatisUtil.getSession();
		// 利用sqlsession生成实体dao
		IUserInfoDao dao = session.getMapper(IUserInfoDao.class);
		List<UserInfo> list = dao.getByPage(pageSize, pageNum);
		// sqlsession关闭
		session.close();
		return list;
	}
	
}
