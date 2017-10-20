package dao;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;
import entity.EmpInfo;

public class EmpInfoDao implements IEmpInfoDao {

	@Override
	public void add(EmpInfo emp) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSession();
		// 利用sqlsession生成实体dao
		IEmpInfoDao dao = session.getMapper(IEmpInfoDao.class);
		dao.add(emp);
		session.commit();
		session.close();
	}

}
