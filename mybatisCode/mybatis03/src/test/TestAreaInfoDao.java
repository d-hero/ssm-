package test;

import java.util.List;

import org.junit.Test;

import dao.AreaInfoDao;
import entity.AreaInfo;

public class TestAreaInfoDao {
@Test
public void testgetAll(){
	AreaInfoDao dao= new AreaInfoDao();
	List<AreaInfo> list = dao.getAll();
	for (AreaInfo a : list) {
		System.out.println(a);
	}
}
}
