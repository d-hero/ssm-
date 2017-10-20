package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.GoodsInfo;

public interface IGoodsInfoDao {
	//根据用户输入的3个参数实现查询
	//商品名称-模糊查询
	//价格区间-只要用户输入任意一个，即可实现查询
	public List<GoodsInfo> search(@Param("gName") String gName,@Param("pMin") int pMin,@Param("pMax") int pMax);
	public int doUpdate(GoodsInfo goodsInfo);
	public List<GoodsInfo> searchByTypeId(@Param("typeArr") String[] typeArr);
}
