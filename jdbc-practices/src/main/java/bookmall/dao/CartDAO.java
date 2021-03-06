package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVO;

public class CartDAO {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}
	
	public boolean insert(CartVO vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into cart values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)
			pstmt.setLong(1, vo.getQty());
			pstmt.setLong(2, vo.getMemberNo());
			pstmt.setLong(3, vo.getBookNo());

			// 5. SQL 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("CartDAO insert() 예외 발생 error:" + e);
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public List<CartVO> findAll() {
		List<CartVO> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "select qty, member_no, book_no from cart";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long qty = rs.getLong(1);
				Long memberNo = rs.getLong(2);
				Long bookNo = rs.getLong(3);

				CartVO vo = new CartVO();
				vo.setQty(qty);
				vo.setMemberNo(memberNo);
				vo.setBookNo(bookNo);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("CartDAO findAll() error:" + e);
		} finally {
			// clean up
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
	
}
