package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import entity.GoodsInfo;

public interface GoodsMapper {
	@Select("select * from goodsinfo")
	public List<GoodsInfo> select();
	//����
	@Insert("insert into goodsInfo(gname,price) values(#{gName},#{price})")
	public int add(GoodsInfo goodsInfo);
}
