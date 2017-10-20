package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ContactInfo;
import entity.ContactType;

public class ContactInfoDao {
	public int addContact(ContactInfo cInfo){
		int i=0;
		String sql = "insert into contactinfo values(seqContact.nextval,?,?,?,?)";
		i = DBUtil.executeUpdate(sql, cInfo.getName(),cInfo.getMobile(),cInfo.getContactType().getTypeId(),cInfo.getEmail());
		return i;
	}
	//查询
	//查询所有的
	public List<ContactInfo> selectAll() {
		List<ContactInfo> list = null;
		String sql = "select ci.*,ct.typeName from contactInfo ci,contactType ct where ci.typeId=ct.typeId order by id";
		ResultSet rs = DBUtil.getResultSet(sql);
		try {
			list = new ArrayList<ContactInfo>();
			while (rs.next()) {
				ContactType ct = new ContactType();
				ct.setTypeId(rs.getInt("typeId"));
				ct.setTypeName(rs.getString("typeName"));
				ContactInfo ci = new ContactInfo(rs.getInt("id"),
						rs.getString("name"), rs.getString("mobile"),
						rs.getString("email"), ct);
				list.add(ci);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//根据id查询
	public ContactInfo getByid(int id) {
		ContactInfo ci = null;
		String sql = "select * from contactInfo where id=?";
		ResultSet rs = DBUtil.getResultSet(sql, id);
		try {
			while (rs.next()) {
				ci = new ContactInfo();
				ci.setId(rs.getInt("id"));
				ci.setName(rs.getString("name"));
				ci.setMobile(rs.getString("mobile"));
				ci.setEmail(rs.getString("email"));
				ContactType ct = new ContactType();
				ct.setTypeId(rs.getInt("typeId"));
				ci.setContactType(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ci;
	}
	//
	//改
		public int updateContactInfo(ContactInfo ci){
			int i=0;
			String sql="update contactInfo set name=?,mobile=?,email=?, typeId=? where id=?";
			i=DBUtil.executeUpdate(sql,ci.getName(),ci.getMobile(),ci.getEmail(),ci.getContactType().getTypeId(),ci.getId());
			return i;
		}
}
