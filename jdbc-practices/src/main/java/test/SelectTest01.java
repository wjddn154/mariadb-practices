package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest01 {
	public static void main(String[] args) {
		search("pat");
	}

	public static void search(String keyword) {
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	      
	      try {
	         //1. JDBC 드라이버 로드
	         Class.forName("org.mariadb.jdbc.Driver");
	      
	         //2. 연결하기
	         String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf-8";
	         conn= DriverManager.getConnection(url, "hr" , "hr");
	         //url, 아이디, 비밀번호
	         
	         //3. Statement 생성
	         stmt = conn.createStatement();
	         
	         //4. SQL 실행
	         String sql = "select emp_no, first_name " +
	        		 	  "from employees " + 
	        		      "where first_name like '%" + keyword + "%'";
	         rs = stmt.executeQuery(sql);
	         while(rs.next()) {
	        	 Long empNo = rs.getLong(1);
	        	 String firstName = rs.getString(2);
	        	 System.out.println(empNo + " : " + firstName);
	         }
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	         System.out.println("드라이버 로딩 실패" + e);
	      }catch (SQLException e) {
	         System.out.println("SQL 예외 발생 error:" + e);
	      }finally {
	         // clean up
	         try {
	        	if(rs != null) { 
	        		rs.close();
	        	}
	        	
	        	if(stmt != null) {
	        	   stmt.close();
	        	}
	        	 
	            if(conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	}

}
