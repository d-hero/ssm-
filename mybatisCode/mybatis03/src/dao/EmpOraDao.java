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
			// 利用sqlsession生成实体dao
			IEmpOraDao dao = session.getMapper(IEmpOraDao.class);
			List<EmpOra> list =dao.getAll();
			//sqlsession关闭
			session.close();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

}
