package bookmall.dao;

import java.util.List;
import bookmall.vo.CategoryVO;

public class CategoryDAOTest {

	public static void main(String[] args) {
//		insertTest();
		findAllTest();

	}

	private static void findAllTest() {
		List<CategoryVO> list = new CategoryDAO().findAll();
		for (CategoryVO vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		CategoryVO vo = null;
		CategoryDAO dao = new CategoryDAO();

		vo = new CategoryVO();
		vo.setName("IT");
		dao.insert(vo);

		vo = new CategoryVO();
		vo.setName("정치");
		dao.insert(vo);

		vo = new CategoryVO();
		vo.setName("인문학");
		dao.insert(vo);

		vo = new CategoryVO();
		vo.setName("여행");
		dao.insert(vo);

		vo = new CategoryVO();
		vo.setName("요리");
		dao.insert(vo);
	}

}
