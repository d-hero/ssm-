package dao;

import java.util.ArrayList;
import java.util.List;

import entity.ContactType;

public class ContactTypeDao {
	
public List<ContactType> selectAll(){
	List<ContactType> list=null;
	String sql="select * from contactType";
	DBUtil db=new DBUtil();
	 list= db.getQuery(new ContactType(), sql);
	return list;
}
}
