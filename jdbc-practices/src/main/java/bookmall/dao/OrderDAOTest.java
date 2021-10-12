package bookmall.dao;

import java.util.List;

import bookmall.vo.OrderVO;

public class OrderDAOTest {
	
	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<OrderVO> list = new OrderDAO().findAll();
		for (OrderVO vo : list) {
			System.out.println(vo);
		}		
	}

	private static void insertTest() {
		OrderVO vo = null;
		OrderDAO dao = new OrderDAO();		
		
		vo = new OrderVO();
		vo.setOrderNo(210002L);
		vo.setPayAmt(14000L);
		vo.setShip("북구 화명동");
		vo.setMemberNo(1L);
		dao.insert(vo);
		
		vo = new OrderVO();
		vo.setOrderNo(210003L);
		vo.setPayAmt(15000L);
		vo.setShip("고길동집");
		vo.setMemberNo(2L);
		dao.insert(vo);
		
		
		vo = new OrderVO();
		vo.setOrderNo(210003L);
		vo.setPayAmt(15000L);
		vo.setShip("고길동 옆집");
		vo.setMemberNo(3L);
		dao.insert(vo);
	}
	
}
