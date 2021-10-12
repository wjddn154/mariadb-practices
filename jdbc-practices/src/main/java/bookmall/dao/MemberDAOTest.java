package bookmall.dao;

import java.util.List;
import bookmall.vo.MemberVO;

public class MemberDAOTest {

	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<MemberVO> list = new MemberDAO().findAll();
		for (MemberVO vo : list) {
			System.out.println(vo);
		}		
	}

	private static void insertTest() {
		MemberVO vo = null;
		MemberDAO dao = new MemberDAO();		
		
		vo = new MemberVO();
		vo.setName("둘리");
		vo.setEmail("345@naver.com");
		vo.setPassword("345");
		vo.setPhonenumber("010-2345-2345");
		dao.insert(vo);
		
		vo = new MemberVO();
		vo.setName("또치");
		vo.setEmail("456@naver.com");
		vo.setPassword("456");
		vo.setPhonenumber("010-3456-3456");
		dao.insert(vo);
		
		vo = new MemberVO();
		vo.setName("마이클");
		vo.setEmail("567@naver.com");
		vo.setPassword("567");
		vo.setPhonenumber("010-4567-4567");
		dao.insert(vo);
		
	}
	
}
