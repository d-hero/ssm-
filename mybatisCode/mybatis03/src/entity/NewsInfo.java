package entity;

public class NewsInfo {
	private int id;
	private String title;
	private String content;
	private NewsTypeInfo newsTypeInfo;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public NewsTypeInfo getNewsTypeInfo() {
		return newsTypeInfo;
	}
	public void setNewsTypeInfo(NewsTypeInfo newsTypeInfo) {
		this.newsTypeInfo = newsTypeInfo;
	}
}
