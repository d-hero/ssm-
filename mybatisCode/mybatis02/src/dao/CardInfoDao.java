package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.util.MybatisUtil;

import entity.CardInfo;
import entity.GoodsInfo;

public class CardInfoDao implements ICardInfoDao {

	@Override
	public List<CardInfo> getAll() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSession();
		// ����sqlsession����ʵ��dao
		ICardInfoDao dao = session.getMapper(ICardInfoDao.class);
		List<CardInfo> list =dao.getAll();
		System.out.println("������ڣ�"+list.get(0).getOpenTime());
		//sqlsession�ر�
		session.close();
		return list;
	}

}
