package anno.mvc;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	public void add(){
		System.out.println("这里保存订单主表信息");
	}
}
