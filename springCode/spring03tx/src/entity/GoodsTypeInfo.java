package entity;

public class GoodsTypeInfo {
	@Override
	public String toString() {
		return "GoodsTypeInfo [id=" + id + ", typeName=" + typeName + "]";
	}
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String typeName;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}
