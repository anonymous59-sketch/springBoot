package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jdbc01Test {
	   public static void main(String[] args) {

//	        String url = "jdbc:h2:mem:testdb"; // 인메모리 DB
//	        String username = "sa";
//	        String password = "";

			String jdbc_driver = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String username = "hr";
			String password = "hr";

	        try (
	        	//2. 데이터베이스 연결
	            Connection conn = DriverManager.getConnection(url, username, password);
	        	// sql 구문 저장을 위한 공간
	            Statement stmt = conn.createStatement()
	        ) {

	            // 1. 테이블 생성(ddl)
//	            stmt.execute("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(50))");

	            // 2. 데이터 삽입(dml)
//	            stmt.executeUpdate("INSERT INTO users (id, name) VALUES (1, 'Alice')");
//	            stmt.executeUpdate("INSERT INTO users (id, name) VALUES (2, 'Bob')");

	            // 3. 데이터 조회(select)
	            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
	            
	            // 결과를 List<EmployeeVO>에 저장
	            // VO = value object
	            List<EmployeeVO> list = new ArrayList<>();
 	            // 4. 출력
	            while (rs.next()) {
//	                System.out.println(
//	                    rs.getInt("employee_id") + " / " + rs.getString("first_name") + " / " + rs.getDate("hire_date")
//	                );
	            	
	            	EmployeeVO emp = new EmployeeVO();
	            	//firstName,lastName, salary, hiredate
	            	emp.setFirstName(rs.getString("first_name"));
	            	emp.setLastName(rs.getString("last_name"));
	            	emp.setSalary(rs.getDouble("salary"));
	            	emp.setHireDate(rs.getDate("hire_date"));
	            	
	            	list.add(emp);
	            }
	            
	            // list 반복문
	            for(int i = 0; i < list.size(); i++) {
	            	System.out.println(list.get(i).getFirstName());
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }// end of main
}