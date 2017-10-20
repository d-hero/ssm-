package test;

import java.util.List;

import dao.AreaInfoNewDao;
import dao.IAreaInfoNewDao;
import entity.AreaInfoNew;

public class TestAreaInfoNew {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAreaInfoNewDao dao =new AreaInfoNewDao();
		List<AreaInfoNew> list = dao.getAll();
		for(AreaInfoNew p:list){
			System.out.println("----"+p.getId()+":"+p.getCityName()+"----");
			for(AreaInfoNew c:p.getChildren()){
				System.out.println("----"+c.getCityName()+"----");
			}
		}
	}

}
