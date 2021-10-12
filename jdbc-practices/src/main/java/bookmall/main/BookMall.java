package bookmall.main;

import java.util.List;

import bookmall.dao.BookDAO;
import bookmall.dao.CartDAO;
import bookmall.dao.CategoryDAO;
import bookmall.dao.MemberDAO;
import bookmall.dao.OrderBookDAO;
import bookmall.dao.OrderDAO;
import bookmall.vo.BookVO;
import bookmall.vo.CartVO;
import bookmall.vo.CategoryVO;
import bookmall.vo.MemberVO;
import bookmall.vo.OrderBookVO;
import bookmall.vo.OrderVO;

public class BookMall {

	public static void main(String[] args) {
		
		//회원 2명 추가
		Memberinsert();
		System.out.println("======= member ======="); 
		MemberfindAll();
		
		//카테고리 3개 추가
		Categoryinsert();
		System.out.println();
		System.out.println("======= category ======="); 
		CategoryfindAll();
		
		//책 상품 3개 추가
		Bookinsert(); 
		System.out.println();
		System.out.println("======= book ======="); 
		BookfindAll();
		
		//카트(장바구니) 2개 추가
		Cartinsert(); 
		System.out.println();
		System.out.println("======= cart ======="); 
		CartfindAll();
		
		//주문 1개 추가
		Orderinsert(); 
		System.out.println();
		System.out.println("======= order ======="); 
		OrderfindAll();
		
		//주문 도서 리스트 2개 추가	
		Orderbookinsert(); 
		System.out.println();
		System.out.println("======= order_book ======="); 
		OrderbookfindAll();
	}

	private static void Memberinsert() {
		MemberVO vo = null;
		MemberDAO dao = new MemberDAO();	
		
		vo = new MemberVO();
		vo.setName("철수");
		vo.setEmail("chulsu@naver.com");
		vo.setPassword("123");
		vo.setPhonenumber("010-1111-1111");
		dao.insert(vo);
		
		vo = new MemberVO();
		vo.setName("영희");
		vo.setEmail("0hee@naver.com");
		vo.setPassword("321");
		vo.setPhonenumber("010-2222-2222");
		dao.insert(vo);
	}

	private static void MemberfindAll() {
		List<MemberVO> list = new MemberDAO().findAll();
		for (MemberVO vo : list) {
			System.out.println(vo);
		}	
	}

	private static void Categoryinsert() {
		CategoryVO vo = null;
		CategoryDAO dao = new CategoryDAO();
		
		vo = new CategoryVO();
		vo.setName("뉴스");
		dao.insert(vo);
		
		vo = new CategoryVO();
		vo.setName("시집");
		dao.insert(vo);
		
		vo = new CategoryVO();
		vo.setName("만화");
		dao.insert(vo);
	}

	private static void CategoryfindAll() {
		List<CategoryVO> list = new CategoryDAO().findAll();
		for (CategoryVO vo : list) {
			System.out.println(vo);
		}
	}

	private static void Bookinsert() {
		BookVO vo = null;
		BookDAO dao = new BookDAO();		
		
		vo = new BookVO();
		vo.setTitle("책1");
		vo.setPrice(21000L);
		vo.setCategoryNo(1L);
		dao.insert(vo);
		
		vo = new BookVO();
		vo.setTitle("책2");
		vo.setPrice(22000L);
		vo.setCategoryNo(2L);
		dao.insert(vo);
		
		vo = new BookVO();
		vo.setTitle("책3");
		vo.setPrice(23000L);
		vo.setCategoryNo(3L);
		dao.insert(vo);
	}

	private static void BookfindAll() {
		List<BookVO> list = new BookDAO().findAll();
		for (BookVO vo : list) {
			System.out.println(vo);
		}	
	}

	private static void Cartinsert() {
		CartVO vo = null;
		CartDAO dao = new CartDAO();		
		
		vo = new CartVO();
		vo.setQty(1L);
		vo.setMemberNo(1L);
		vo.setBookNo(1L);
		dao.insert(vo);	
		
		vo = new CartVO();
		vo.setQty(2L);
		vo.setMemberNo(2L);
		vo.setBookNo(2L);
		dao.insert(vo);	
	}

	private static void CartfindAll() {
		List<CartVO> list = new CartDAO().findAll();
		for (CartVO vo : list) {
			System.out.println(vo);
		}	
	}

	private static void Orderinsert() {
		OrderVO vo = null;
		OrderDAO dao = new OrderDAO();		
		
		vo = new OrderVO();
		vo.setOrderNo(210001L);
		vo.setPayAmt(21000L);
		vo.setShip("북구 화명동");
		vo.setMemberNo(1L);
		dao.insert(vo);
	}

	private static void OrderfindAll() {
		List<OrderVO> list = new OrderDAO().findAll();
		for (OrderVO vo : list) {
			System.out.println(vo);
		}		
	}

	private static void Orderbookinsert() {
		OrderBookVO vo = null;
		OrderBookDAO dao = new OrderBookDAO();		
		
		vo = new OrderBookVO();
		vo.setOrderNo(1L);
		vo.setBookNo(2L);
		vo.setQty(1L);
		vo.setPrice(22000L);
		dao.insert(vo);	
		
		vo = new OrderBookVO();
		vo.setOrderNo(1L);
		vo.setBookNo(3L);
		vo.setQty(2L);
		vo.setPrice(46000L);
		dao.insert(vo);
	}

	private static void OrderbookfindAll() {
		List<OrderBookVO> list = new OrderBookDAO().findAll();
		for (OrderBookVO vo : list) {
			System.out.println(vo);
		}
	}

}
