package test;

import java.util.List;

import org.junit.Test;

import dao.ContactInfoDao;
import entity.ContactInfo;

public class TestContactInfo {
	@Test
	public void select(){
		ContactInfoDao dao =new ContactInfoDao();
		List<ContactInfo> list = dao.selectAll();
		System.out.println(list.size());
	}
	@Test
	public void ById(){
		ContactInfoDao dao =new ContactInfoDao();
		ContactInfo ci = dao.getByid(2);
		System.out.println(ci.getMobile());
	}
}
