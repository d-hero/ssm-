package annotation01;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
	public void show(){
		System.out.println("嘿嘿被调用了");
	}
}
