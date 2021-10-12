package bookmall.dao;

import java.util.List;

import bookmall.vo.OrderBookVO;

public class OrderBookDAOTest {

	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<OrderBookVO> list = new OrderBookDAO().findAll();
		for (OrderBookVO vo : list) {
			System.out.println(vo);
		}		
	}
	
	private static void insertTest() {
		OrderBookVO vo = null;
		OrderBookDAO dao = new OrderBookDAO();		
		
		vo = new OrderBookVO();
		vo.setOrderNo(1L);
		vo.setBookNo(2L);
		vo.setQty(1L);
		vo.setPrice(15000L);
		dao.insert(vo);
	}
}
