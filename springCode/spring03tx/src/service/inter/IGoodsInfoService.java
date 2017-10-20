package service.inter;

import java.util.List;

import entity.GoodsInfo;


public interface IGoodsInfoService {
	public List<GoodsInfo> select();
	public int add(GoodsInfo goodsInfo);
	public void add2(GoodsInfo goodsInfo);
}
