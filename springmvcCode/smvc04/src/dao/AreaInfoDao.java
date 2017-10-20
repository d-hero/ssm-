package dao;

import java.util.List;

import entity.AreaInfo;

public class AreaInfoDao {
	/**
	 * 
	 * @param pId
	 * @return
	 */
	public List<AreaInfo> getByPid(String pId){
		List<AreaInfo> list = null;
		String sql = "select * from tb_da_area where parentid =?";
		list = new DBUtil().getQuery(new AreaInfo(), sql, pId);		
		return list;
	}
}
