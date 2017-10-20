package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.*;
public class UserInfoDao {
	//��ѯ�����е��û��������
	//��jspҳ�������ʾ��ҳ����
	/*
	 * 
	 * �õ����е��û�����
	 */
	public List<UserInfo> selectAll(){
		List<UserInfo> list =null;
		//����sql
		String sql = "select * from userinfo";
		//�õ������
		ResultSet rs = JDBCUtil.getResultSet(sql);
		//���������
		try {
			//ע��list��new
			list =new ArrayList<UserInfo>();
			while(rs.next()){
				//ÿһ�м�¼����һ��userinfo����
				UserInfo ui =new UserInfo();
				//��rs����һ���ֶ�һ���ֶζ�ȡ��ui
				ui.setId(rs.getInt("id"));
				ui.setuName(rs.getString("uName"));
				ui.setPwd(rs.getString("pwd"));
				
				ui.setNickName(rs.getString("nickName"));
				//���������û����󱣴���û�����
				list.add(ui);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeDB(rs);
		}
		//�����ݱ��浽list����
		return list;
	}
	/***
	 * ʵ�ֶ��û����ݵ�ɾ��
	 * @param id ���ݵı�����¼������
	 * @return ɾ���Ľ����һ�����ͣ�>0����ɹ�
	 */
	public int delById(String id){
		int i=0;//��������ɾ����Ľ��
		//дsql
		String sql = "delete from userInfo where id=?";
		//������ɾ��
		i = JDBCUtil.executeUpdate(sql, id);
		return i;
	}
	//��ɵ�¼����
		public UserInfo doLogin(String uName,String pwd){
			//��д��ѯsql
		  	String sql = "SELECT * FROM userinfo WHERE uName=? AND pwd =?";
		  	//���ù�����������ѯ����
		  	ResultSet rs = null;
		  	//�����ǽ���Ҫ���û���Ϣ���浽user��������
		  	UserInfo ui =null;
		  	try {
		  		rs = JDBCUtil.getResultSet(sql, uName, pwd);
		  		//����ж��Ƿ����
		  		if (rs.next()) {
		  			ui=new UserInfo();
		  			String nickName=rs.getString("nickName");
		  			ui.setuName(uName);
		  			ui.setPwd(pwd);
		  			ui.setNickName(nickName);
		  			
		  		}
		  	} catch (Exception ex) {
		  		 System.out.println(ex.getMessage());
		  	} finally {
		  		//�ر����ݿ�
		  		JDBCUtil.closeDB(rs);
		  	}
		  	return ui;
		}
}
