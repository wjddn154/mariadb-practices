package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

   public static void main(String[] args) {
      Connection conn = null;
      
      
      try {
         //1. JDBC 드라이버 로드
         Class.forName("org.mariadb.jdbc.Driver");
      
         //2. 연결하기
         String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf-8";
         conn= DriverManager.getConnection(url, "webdb" , "webdb");
         //url, 아이디, 비밀번호
         
         System.out.println("연결성공");
      
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         System.out.println("드라이버 로딩 실패" + e);
      }catch (SQLException e) {
         System.out.println("SQL 예외 발생 error:" + e);
      }finally {
         
         try {
            if(conn != null) {
               conn.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

      
      
   }

}