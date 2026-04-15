package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

	String jdbc_driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String username = "hr";
	String password = "hr";
	
	// 등록
	int insert(DepartmentVO dept) {
		int cnt = 0;
		String sql = """
				INSERT INTO departments (department_id
									   , department_name)
				VALUES                  (?, ?)
				""";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, dept.getDepartmentId());
			stmt.setString(2, dept.getDepartmentName());

			cnt = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 수정
	int update(DepartmentVO dept) {
		int cnt = 0;
		String sql = """
				UPDATE departments
				SET    department_name = (?)
				WHERE  department_id = (?)
				""";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, dept.getDepartmentName());
			stmt.setInt(2, dept.getDepartmentId());

			cnt = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	// 삭제
	int delete(int id) {
		int cnt = 0;
		String sql = """
				DELETE FROM departments 
				WHERE       department_id = ?
				""";
		try (
				Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(sql);
			) 
		{
			stmt.setInt(1, id);
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	// 단건조회
	DepartmentVO selectOne(int deptid) {
		DepartmentVO dept = new DepartmentVO();
		String sql = """
				SELECT *
				FROM   departments
				WHERE  department_id = ?
				""";
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, deptid);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dept;
	}

	// 전체조회
	List<DepartmentVO> selectAll() {
		List<DepartmentVO> list = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM departments");

			while (rs.next()) {
				DepartmentVO dept = new DepartmentVO();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));

				list.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
