package dynamicProxy;

import java.util.Date;

public class LogInfoDao {
	public void addLog(){
		System.out.println("记录下来各种操作"+new Date());
	}
}
