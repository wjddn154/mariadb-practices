package bookmall.vo;

public class MemberVO {
	private Long no;
	private String name;
	private String email;
	private String password;
	private String phonenumber;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phonenumber=" + phonenumber + "]";
	}
	
	
}
