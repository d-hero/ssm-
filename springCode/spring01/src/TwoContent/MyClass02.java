package TwoContent;

import java.util.Date;

public class MyClass02 {
	public void show(){
		System.out.println("这里myclass02");
	}
	//要证明对象被生成，通过构造方法
	public  MyClass02(){
		System.out.println("我被生成啦02"+new Date());
	}
}
