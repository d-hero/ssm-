package entity;

import java.util.List;

public class NewsTypeInfo {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public List<NewsInfo> getNews() {
		return news;
	}
	public void setNews(List<NewsInfo> news) {
		this.news = news;
	}
	private String typeName;
	//���������ŵĹ�ϵ��һ�Զ�
	private List<NewsInfo> news;
	
}
