package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.UserInfo;

public interface UserMapper {
	//��ѯ���е��û�
	@Select("select * from userinfo")
	public  List<UserInfo> getAll();
	
}
