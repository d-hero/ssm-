package test;

import java.util.List;

import org.junit.Test;

import dao.*;
import entity.GoodsInfo;

public class TestGoodsInfo {
	@Test
	public void getAll(){
		IGoodsInfoDao dao =new GoodsInfoDao();
		List<GoodsInfo> list = dao.getAll();
		for(GoodsInfo g:list){
			System.out.println(g);
		}
	}
}
