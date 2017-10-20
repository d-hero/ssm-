package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.UserInfo;

public interface UserMapper {
	//查询所有的用户
	@Select("select * from userinfo")
	public  List<UserInfo> getAll();
	
}
