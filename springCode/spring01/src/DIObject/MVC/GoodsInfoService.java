package DIObject.MVC;

public class GoodsInfoService {
	private GoodsInfoDao dao;

	public GoodsInfoDao getDao() {
		return dao;
	}

	public void setDao(GoodsInfoDao dao) {
		this.dao = dao;
	}
	public void list(){
		System.out.println("������ҵ���߼���ͨ������dao���õ���ѯ������");
		dao.list();
	}
}
