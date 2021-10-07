package bookmall.vo;

public class OrderBookVO {
	private Long orderNo;
	private Long bookNo;
	private Long qty;
	private Long price;
	
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "OrderBookVO [orderNo=" + orderNo + ", bookNo=" + bookNo + ", qty=" + qty + ", price=" + price + "]";
	}
	
	
}
