package jdbc;

import java.util.Date;

//import java.util.List;

public class EmpDAOTest {
	public static void main(String[] args) {
		EmployeeDAO empDAO = new EmployeeDAO();
		
		////// 전체조회
//		List<EmployeeVO> list = empDAO.selectAll();
//		
//		for(EmployeeVO emp : list) {
//			System.out.println(emp.getFirstName() + " / " + emp.getLastName() + " / " + emp.getSalary() + " / " + emp.getHireDate());
//		}
		
		////// 단건조회
//		EmployeeVO emp = empDAO.selectOne(101);
//		System.out.println(emp.getFirstName() + " / " + emp.getLastName() + " / " + emp.getSalary() + " / " + emp.getHireDate());
		
		////// 삭제
//		int cnt = empDAO.delete(300);
//		System.out.println(cnt + "건이 삭제되었습니다.");
		
		////// 등록
		EmployeeVO emp = new EmployeeVO();
		emp.setEmployeeId(301);
		emp.setLastName("김철수");
		emp.setEmail("chol");
		emp.setHireDate(new Date());
		emp.setJobId("IT_PROG");
		
		int cnt = empDAO.insert(emp);
		System.out.println(cnt + "건이 등록되었습니다.");

		////// 수정
		emp = new EmployeeVO();
		emp.setFirstName("홍길동");
		emp.setSalary(30000);
		emp.setEmployeeId(301);
		cnt = empDAO.update(emp);
		System.out.println(cnt + "건이 수정되었습니다.");
		
	}// end of main
}// end of class EmpDAOTest

