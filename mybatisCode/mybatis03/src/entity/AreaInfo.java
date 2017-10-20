package entity;

public class AreaInfo {
private int id;
private String cityName;
private AreaInfo fathercity;
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
public AreaInfo getFathercity() {
	return fathercity;
}
public void setFathercity(AreaInfo fathercity) {
	this.fathercity = fathercity;
}
@Override
public String toString() {
	return "AreaInfo [id=" + id + ", cityName=" + cityName + ", fathercity="
			+ fathercity + "]";
}

}
