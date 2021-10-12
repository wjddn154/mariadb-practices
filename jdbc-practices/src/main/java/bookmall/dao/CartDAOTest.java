package bookmall.dao;

import java.util.List;

import bookmall.vo.CartVO;

public class CartDAOTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<CartVO> list = new CartDAO().findAll();
		for (CartVO vo : list) {
			System.out.println(vo);
		}	
	}

	private static void insertTest() {
		CartVO vo = null;
		CartDAO dao = new CartDAO();		
		
		vo = new CartVO();
		vo.setQty(1L);
		vo.setMemberNo(2L);
		vo.setBookNo(5L);
		dao.insert(vo);	
		
		vo = new CartVO();
		vo.setQty(1L);
		vo.setMemberNo(4L);
		vo.setBookNo(6L);
		dao.insert(vo);	
		
		vo = new CartVO();
		vo.setQty(3L);
		vo.setMemberNo(3L);
		vo.setBookNo(2L);
		dao.insert(vo);
	}

}
