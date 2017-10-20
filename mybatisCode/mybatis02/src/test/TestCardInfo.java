package test;

import dao.CardInfoDao;
import dao.ICardInfoDao;

public class TestCardInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICardInfoDao dao =new CardInfoDao();
		dao.getAll();
	}

}
