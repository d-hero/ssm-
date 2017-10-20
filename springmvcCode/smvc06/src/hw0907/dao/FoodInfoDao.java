package hw0907.dao;

import java.util.List;

import hw0907.entity.FoodInfo;

public class FoodInfoDao {
	public List<FoodInfo> selectAll(){
		List<FoodInfo> list = null;
		DBUtil util = new DBUtil();
		String sql = "select * from foodInfo";
		list =util.getQuery(new FoodInfo(), sql);
		return list;
	}
	//这里进行数据的保存
	public int add(FoodInfo foodInfo){
		int i=0;
		String sql ="insert into foodInfo(fname,price,img) values(?,?,?)";
		i = DBUtil.executeUpdate(sql, foodInfo.getfName(),foodInfo.getPrice(),foodInfo.getImg());
		return i;
	}
}
