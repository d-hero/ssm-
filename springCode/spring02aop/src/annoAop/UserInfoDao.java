package annoAop;

import org.springframework.stereotype.Repository;

public class UserInfoDao {
	public void addUser() throws Exception{
		System.out.println("��������û�������");
		throw new Exception("����������");
	}
}
