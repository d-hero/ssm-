package entity;

public class ContactInfo {
	private int id;
	private String name;
	private String mobile;
	private String email;
	private ContactType contactType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ContactType getContactType() {
		return contactType;
	}
	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}
	
	public ContactInfo(int id, String name, String mobile, String email,
			ContactType contactType) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.contactType = contactType;
	}
	public ContactInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ContactInfo [id=" + id + ", name=" + name + ", mobile="
				+ mobile + ", email=" + email + ", contactType=" + contactType
				+ "]";
	}
	
}
