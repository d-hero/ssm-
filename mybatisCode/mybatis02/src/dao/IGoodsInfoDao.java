package dao;

import java.util.List;

import entity.GoodsInfo;

public interface IGoodsInfoDao {
	public List<GoodsInfo> search(String str,int pageSize,int pageNum);
	//商品的新增
	public void add(GoodsInfo goodsInfo);
	//新增成功后返回的是自增的id值
	public int addGoods(GoodsInfo goodsInfo);
}
