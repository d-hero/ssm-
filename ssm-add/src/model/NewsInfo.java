package model;

public class NewsInfo {
	private int id;
	private String title;
	private NewsTypeInfo newsType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public NewsTypeInfo getNewsType() {
		return newsType;
	}
	public void setNewsType(NewsTypeInfo newsType) {
		this.newsType = newsType;
	}
}
