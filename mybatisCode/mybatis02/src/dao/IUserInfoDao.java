package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.UserInfo;

public interface IUserInfoDao {
	//这里处理登录
	public UserInfo doLogin(UserInfo userInfo);
	// 得到当前的用户数
	public int getUserCount();
	//方法参数2个以上
	public UserInfo doLogin02(@Param("name1") String name,@Param("pwd1")String pwd,int id);
	//分页显示记录数
	public List<UserInfo> getByPage(@Param("m") int pageSize,@Param("n")int pageNum);
}
