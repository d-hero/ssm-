package annoAop;

import org.springframework.stereotype.Repository;

public class UserInfoDao {
	public void addUser() throws Exception{
		System.out.println("这里进行用户的新增");
		throw new Exception("出现问题了");
	}
}
