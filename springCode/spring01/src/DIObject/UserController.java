package DIObject;

public class UserController {
	private UserInfoDao dao;

	public UserInfoDao getDao() {
		return dao;
	}

	public void setDao(UserInfoDao dao) {
		this.dao = dao;
	}
	/**
	 * ���ﴦ���û�������
	 */
	public void add(){
		//�ڿ������������dao������
		//����õ���Ҫ�������Ժ󣬵���dao�����û�������
		dao.add();
	}
}
