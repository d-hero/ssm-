package anno.mvc;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailDao {
	public void add(){
		System.out.println("这里保存订单明细信息");
	}
}
