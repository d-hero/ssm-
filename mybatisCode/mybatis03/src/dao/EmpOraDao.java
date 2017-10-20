package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;
import entity.*;

public class EmpOraDao implements IEmpOraDao {
	@Override
	public List<EmpOra> getAll() {
		// TODO Auto-generated method stub
		try{
			SqlSession session = MybatisUtil.getSession();
			// ����sqlsession����ʵ��dao
			IEmpOraDao dao = session.getMapper(IEmpOraDao.class);
			List<EmpOra> list =dao.getAll();
			//sqlsession�ر�
			session.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

}
