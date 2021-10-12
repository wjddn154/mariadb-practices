package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderVO;

public class OrderDAO {
	
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

	public boolean insert(OrderVO vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into bookmall.order values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)
			pstmt.setLong(1, vo.getOrderNo());
			pstmt.setLong(2, vo.getPayAmt());
			pstmt.setString(3, vo.getShip());
			pstmt.setLong(4, vo.getMemberNo());

			// 5. SQL 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("OrderDAO insert() 예외 발생 error:" + e);
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

	
	public List<OrderVO> findAll() {
		List<OrderVO> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = 
					"select no, order_no, pay_amt, ship, member_no" +
					"  from bookmall.order" +
					" order by no asc";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				Long orderNo = rs.getLong(2);
				Long payAmt = rs.getLong(3);
				String ship = rs.getString(4);
				Long memberNo = rs.getLong(5);

				OrderVO vo = new OrderVO();
				vo.setNo(no);
				vo.setOrderNo(orderNo);
				vo.setPayAmt(payAmt);
				vo.setShip(ship);
				vo.setMemberNo(memberNo);
				
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("OrderDAO findAll() error:" + e);
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
				e.printStackTrace();
			}
		}

		return result;
	}

}
