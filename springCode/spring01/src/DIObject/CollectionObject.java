package DIObject;

import java.util.List;

public class CollectionObject {
 private List<UserInfo> list;

public List<UserInfo> getList() {
	return list;
}

public void setList(List<UserInfo> list) {
	this.list = list;
}
public void show(){
	for(UserInfo u:list){
		System.out.println(u);
	}
}
}
