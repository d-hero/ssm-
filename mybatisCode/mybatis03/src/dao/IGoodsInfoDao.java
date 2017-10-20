package dao;

import java.util.List;

import entity.GoodsInfo;

public interface IGoodsInfoDao {
	//查询出商品信息，
	public List<GoodsInfo> getAll();
}
