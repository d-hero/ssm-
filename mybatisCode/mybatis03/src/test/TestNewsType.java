package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.INewsTypeDao;
import dao.NewsTypeInfoDao;

import entity.NewsInfo;
import entity.NewsTypeInfo;

public class TestNewsType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<NewsTypeInfo> list =new ArrayList<NewsTypeInfo>();
		NewsTypeInfo nt = new NewsTypeInfo();
		nt.setId(1);
		nt.setTypeName("����");
		//��������������
		NewsInfo ni =new NewsInfo();
		ni.setId(1);
		ni.setTitle("��������1");
		List<NewsInfo> news = new ArrayList<NewsInfo>();
		news.add(ni);
		ni =new NewsInfo();
		ni.setId(2);
		ni.setTitle("��������2");
		news.add(ni);
		//
		nt.setNews(news);
		//���Ҫ������������ӵ���Ӧ�ļ���
		list.add(nt);
		//��������
		for(NewsTypeInfo ntype:list){
			System.out.println("--"+ntype.getTypeName()+":"+ntype.getId()+"----");
			for(NewsInfo n:ntype.getNews()){
				System.out.println("��Ӧ������"+n.getTitle());
			}
		}
	}
	@Test
	public void showAll(){
		INewsTypeDao dao = new NewsTypeInfoDao();
		List<NewsTypeInfo> list =dao.getAll();
		//��������
		for (NewsTypeInfo ntype : list) {
			System.out.println("--"+ntype.getTypeName()+":"+ntype.getId()+"----");
			for(NewsInfo n:ntype.getNews()){
				System.out.println("��Ӧ������"+n.getTitle());
			}
		}
	}

}
