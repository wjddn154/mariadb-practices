package bookmall.dao;

import java.util.List;

import bookmall.vo.BookVO;

public class BookDAOTest {
	
	public static void main(String[] args) {
//		insertTest();
		findAllTest();

	}

	private static void findAllTest() {
		List<BookVO> list = new BookDAO().findAll();
		for (BookVO vo : list) {
			System.out.println(vo);
		}		
	}

	private static void insertTest() {
		BookVO vo = null;
		BookDAO dao = new BookDAO();		
		
		vo = new BookVO();
		vo.setTitle("디비나은");
		vo.setPrice(11000L);
		vo.setCategoryNo(3L);
		dao.insert(vo);
		
		vo = new BookVO();
		vo.setTitle("항공원호");
		vo.setPrice(12000L);
		vo.setCategoryNo(4L);
		dao.insert(vo);
		
		vo = new BookVO();
		vo.setTitle("바선생");
		vo.setPrice(13000L);
		vo.setCategoryNo(5L);
		dao.insert(vo);
		
		vo = new BookVO();
		vo.setTitle("펀치마스터다슬");
		vo.setPrice(14000L);
		vo.setCategoryNo(5L);
		dao.insert(vo);
		
	}
	
}
