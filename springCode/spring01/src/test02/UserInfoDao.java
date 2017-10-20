package test02;

import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDao implements IUserInfoDao {
	public UserInfoDao() {
		super();
		System.out.println(this);
	}
}
