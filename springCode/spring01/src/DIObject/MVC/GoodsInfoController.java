package DIObject.MVC;

public class GoodsInfoController {
	private GoodsInfoService service;

	public GoodsInfoService getService() {
		return service;
	}

	public void setService(GoodsInfoService service) {
		this.service = service;
	}
	public void goodsList(){
		System.out.println("�����ǿ����������");
		service.list();
	}
}
