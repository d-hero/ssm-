package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.UserInfo;

public interface IUserInfoDao {
	//���ﴦ���¼
	public UserInfo doLogin(UserInfo userInfo);
	// �õ���ǰ���û���
	public int getUserCount();
	//��������2������
	public UserInfo doLogin02(@Param("name1") String name,@Param("pwd1")String pwd,int id);
	//��ҳ��ʾ��¼��
	public List<UserInfo> getByPage(@Param("m") int pageSize,@Param("n")int pageNum);
}
