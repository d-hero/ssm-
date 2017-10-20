package test;

import java.util.List;

import org.junit.Test;
import dao.*;
import entity.GoodsInfo;
public class TestGoodsInfo {
	public static void main(String[] args) {
		IGoodsInfoDao dao =new GoodsInfoDao();
		String str = "冰";
		int pageSize=3;
		int pageNum = 2;
		int m=(pageNum-1)*pageSize;
		int n = pageSize;
		System.out.println("输出一些内容");
		List<GoodsInfo> list = dao.search("%"+str+"%", m, n);
		for(GoodsInfo g:list){
			System.out.println(g.getId()+g.getgName());
		}
	}
	@Test
	public void byPage(){
		IGoodsInfoDao dao =new GoodsInfoDao();
		String str = "冰";
		int pageSize=3;
		int pageNum = 2;
		int m=(pageNum-1)*pageSize;
		int n = pageSize;
		List<GoodsInfo> list = dao.search("%"+str+"%", m, n);
		for(GoodsInfo g:list){
			System.out.println(g.getId()+g.getgName());
		}
	}
	@Test
	public void add(){
		GoodsInfo g =new GoodsInfo();
		g.setgName("中秋月饼");
		g.setPrice(8);
		IGoodsInfoDao dao =new GoodsInfoDao();
		dao.add(g);
		System.out.println("保存成功");
	}
	@Test
	public void addGeti(){
		GoodsInfo g =new GoodsInfo();
		g.setgName("中秋月饼2222");
		g.setPrice(88);
		IGoodsInfoDao dao =new GoodsInfoDao();
		int i = dao.addGoods(g);
		System.out.println("保存成功"+i);
	}
}
