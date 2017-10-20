package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;
import entity.*;

public class EmpInfoDao implements IEmInfoDao {
	@Override
	public List<EmpInfo> getAll() {
		// TODO Auto-generated method stub
		try{
			SqlSession session = MybatisUtil.getSession();
			// ����sqlsession����ʵ��dao
			IEmInfoDao dao = session.getMapper(IEmInfoDao.class);
			List<EmpInfo> list =dao.getAll();
			//sqlsession�ر�
			session.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

}
