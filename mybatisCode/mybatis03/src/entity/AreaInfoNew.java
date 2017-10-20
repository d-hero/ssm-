package entity;

import java.util.List;

public class AreaInfoNew {
	private int id;
	private String cityName;
	private List<AreaInfoNew> children;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<AreaInfoNew> getChildren() {
		return children;
	}
	public void setChildren(List<AreaInfoNew> children) {
		this.children = children;
	}
}
