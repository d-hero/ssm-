package dao.inter;

import java.util.List;

import entity.GoodsInfo;

public interface IGoodsInfoDao {
	public List<GoodsInfo> select();
	public int add(GoodsInfo goodsInfo);
}
