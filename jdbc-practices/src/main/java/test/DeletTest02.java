package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletTest02 {

	public static void main(String[] args) {
		Boolean result = delete(8L);
		System.out.println(result ? "성공":"실패");
	}

	private static Boolean delete(long no) {
		boolean result = false;
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	      try {
	         //1. JDBC 드라이버 로드
	         Class.forName("org.mariadb.jdbc.Driver");
	      
	         //2. 연결하기
	         String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf-8";
	         conn= DriverManager.getConnection(url, "hr" , "hr");
	         //url, 아이디, 비밀번호
	         
	         //3. SQL 준비
	         String sql = "delete from dept where no =? ";
	         pstmt = conn.prepareStatement(sql);
	         
	         //4. binding
	         pstmt.setLong(1, no);
	         
	         //5. SQL 실행
	         int count = pstmt.executeUpdate();
	         
	         result = count == 1;
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	         System.out.println("드라이버 로딩 실패" + e);
	      }catch (SQLException e) {
	         System.out.println("SQL 예외 발생 error:" + e);
	      }finally {
	         //clean up
	         try {
	        	if(pstmt != null) {
	        	   pstmt.close();
	        	}
	        	 
	            if(conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      return result;
	}

}
