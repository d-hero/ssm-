package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.*;
public class UserInfoDao {
	//查询出所有的用户表的数据
	//让jsp页面调用显示在页面上
	/*
	 * 
	 * 得到所有的用户数据
	 */
	public List<UserInfo> selectAll(){
		List<UserInfo> list =null;
		//构造sql
		String sql = "select * from userinfo";
		//得到结果集
		ResultSet rs = JDBCUtil.getResultSet(sql);
		//遍历结果集
		try {
			//注意list的new
			list =new ArrayList<UserInfo>();
			while(rs.next()){
				//每一行记录代表一个userinfo对象
				UserInfo ui =new UserInfo();
				//从rs里面一个字段一个字段读取到ui
				ui.setId(rs.getInt("id"));
				ui.setuName(rs.getString("uName"));
				ui.setPwd(rs.getString("pwd"));
				
				ui.setNickName(rs.getString("nickName"));
				//将单个的用户对象保存的用户集合
				list.add(ui);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeDB(rs);
		}
		//将数据保存到list里面
		return list;
	}
	/***
	 * 实现对用户数据的删除
	 * @param id 传递的本条记录的主键
	 * @return 删除的结果，一个整型，>0代表成功
	 */
	public int delById(String id){
		int i=0;//用来接收删除后的结果
		//写sql
		String sql = "delete from userInfo where id=?";
		//调用增删改
		i = JDBCUtil.executeUpdate(sql, id);
		return i;
	}
	//完成登录功能
		public UserInfo doLogin(String uName,String pwd){
			//编写查询sql
		  	String sql = "SELECT * FROM userinfo WHERE uName=? AND pwd =?";
		  	//调用工具类的里面查询方法
		  	ResultSet rs = null;
		  	//正常是将需要的用户信息保存到user对象里面
		  	UserInfo ui =null;
		  	try {
		  		rs = JDBCUtil.getResultSet(sql, uName, pwd);
		  		//如何判断是否存在
		  		if (rs.next()) {
		  			ui=new UserInfo();
		  			String nickName=rs.getString("nickName");
		  			ui.setuName(uName);
		  			ui.setPwd(pwd);
		  			ui.setNickName(nickName);
		  			
		  		}
		  	} catch (Exception ex) {
		  		 System.out.println(ex.getMessage());
		  	} finally {
		  		//关闭数据库
		  		JDBCUtil.closeDB(rs);
		  	}
		  	return ui;
		}
}
