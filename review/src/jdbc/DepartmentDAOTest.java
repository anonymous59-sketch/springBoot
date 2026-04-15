package jdbc;

//import java.util.List;

public class DepartmentDAOTest {

	public static void main(String[] args) {
		DepartmentDAO deptDAO = new DepartmentDAO();
//		List<DepartmentVO> list = deptDAO.selectAll();
//		
//		for(DepartmentVO dept : list) {
//			System.out.println(dept.getDepartmentId() + " / " + dept.getDepartmentName() + " / " + dept.getManagerId() + " / " + dept.getLocationId());
//		}
		
//		DepartmentVO dept = deptDAO.selectOne(50);
//		System.out.println(dept.getDepartmentId() + " / " + dept.getDepartmentName() + " / " + dept.getManagerId() + " / " + dept.getLocationId());
		
		DepartmentVO dept = new DepartmentVO();
		dept.setDepartmentId(999);
		dept.setDepartmentName("TESTING");
		
		int cnt = deptDAO.insert(dept);
		System.out.println(cnt + "건이 등록되었습니다.");
		
	}// end of main

}// end of class DepartmentDAOTest
