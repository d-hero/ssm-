package dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import entity.GoodsInfo;

public interface GoodsMapper {
	@ResultMap("com.etc.GoodsInfoMapper.goodsMap")
	@Select("SELECT g.*,gt.typeName FROM goodsinfo g JOIN goodstypeinfo gt ON g.typeid = gt.id")
	public List<GoodsInfo> select();
	
}
