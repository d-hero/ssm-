package test;

import java.util.List;

import org.junit.Test;

import dao.GoodsInfoDao;
import dao.IGoodsInfoDao;
import entity.GoodsInfo;
import entity.GoodsTypeInfo;

public class TestGoodsInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGoodsInfoDao dao =new GoodsInfoDao();
		String str ="±ù";
		str ="%"+str+"%";
		List<GoodsInfo> list =dao.search(str, 2, 20);
		System.out.println(list.size());
	}
	@Test
	public void doUpdate(){
		try{
			GoodsInfo g =new GoodsInfo();
			g.setId(2);
			g.setgName("ffff");
			g.setPrice(30);
			//
			GoodsTypeInfo gt =new GoodsTypeInfo();
			gt.setId(2);
			//
			//g.setGoodsTypeInfo(gt);
			IGoodsInfoDao dao =new GoodsInfoDao();
			System.out.println(dao.doUpdate(g));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	@Test
	public void searchByTypeId(){
		String[] typeArr = new String[]{"7","2","5"};
		IGoodsInfoDao dao =new GoodsInfoDao();
		List<GoodsInfo> list = dao.searchByTypeId(typeArr);
		System.out.println(list.size());
		
	}
}
