package TwoContent;

import java.util.Date;

public class MyClass {
	public void show(){
		System.out.println("这里myclass");
	}
	//要证明对象被生成，通过构造方法
	public  MyClass(){
		System.out.println("我被生成啦"+new Date());
	}
}
