package anno.mvc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	@Resource
	private UserInfoService service;
	public void show(){
		System.out.println("这里是控制器");
		service.show();
	}
}
