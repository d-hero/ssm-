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
		nt.setTypeName("国内");
		//以下是新闻数据
		NewsInfo ni =new NewsInfo();
		ni.setId(1);
		ni.setTitle("国内新闻1");
		List<NewsInfo> news = new ArrayList<NewsInfo>();
		news.add(ni);
		ni =new NewsInfo();
		ni.setId(2);
		ni.setTitle("国内新闻2");
		news.add(ni);
		//
		nt.setNews(news);
		//最后要把新闻类型添加到对应的集合
		list.add(nt);
		//遍历数据
		for(NewsTypeInfo ntype:list){
			System.out.println("--"+ntype.getTypeName()+":"+ntype.getId()+"----");
			for(NewsInfo n:ntype.getNews()){
				System.out.println("对应的新闻"+n.getTitle());
			}
		}
	}
	@Test
	public void showAll(){
		INewsTypeDao dao = new NewsTypeInfoDao();
		List<NewsTypeInfo> list =dao.getAll();
		//遍历数据
		for (NewsTypeInfo ntype : list) {
			System.out.println("--"+ntype.getTypeName()+":"+ntype.getId()+"----");
			for(NewsInfo n:ntype.getNews()){
				System.out.println("对应的新闻"+n.getTitle());
			}
		}
	}

}
