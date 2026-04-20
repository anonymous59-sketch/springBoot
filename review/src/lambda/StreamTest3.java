package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jdbc.EmployeeVO;

public class StreamTest3 {
	public static void main(String[] args) {
		List<EmployeeVO> list = new ArrayList<>();
		list.add(new EmployeeVO(200, "홍길동", 2000));
		list.add(new EmployeeVO(201, "김길동", 10000));
		list.add(new EmployeeVO(202, "박길동", 5000));
		
		list.stream()
			.filter(emp -> emp.getSalary() >= 5000)
			.forEach(emp -> System.out.println(emp.getFirstName()));
		
		list.stream()
		.filter(emp -> emp.getSalary() >= 5000)
		.forEach(System.out::println);
		
		 List<EmployeeVO> result = list.stream()
				 					   .filter(emp -> emp.getSalary() >= 5000)
				 					   .collect(Collectors.toList());
		 
		System.out.println(result);
		 
	}// end of main
}
