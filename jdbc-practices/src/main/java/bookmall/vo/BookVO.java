package bookmall.vo;

public class BookVO {
	private Long no;
	private String title;
	private Long price;
	private Long categoryNo;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	@Override
	public String toString() {
		return "BookVO [no=" + no + ", title=" + title + ", price=" + price + ", categoryNo=" + categoryNo + "]";
	}
	
	

}
