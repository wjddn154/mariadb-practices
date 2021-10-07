package bookmall.vo;

public class CartVO {
	private Long qty;
	private Long memberNo;
	private Long bookNo;
	
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	
	@Override
	public String toString() {
		return "CartVO [qty=" + qty + ", memberNo=" + memberNo + ", bookNo=" + bookNo + "]";
	}
	
	
}
