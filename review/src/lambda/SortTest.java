package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import jdbc.EmployeeVO;

/*
 * 익명클래스(추상메소드가 하나만 있는 경우) -> 람다식
 */
public class SortTest {

	public static void main(String[] args) {
		List<EmployeeVO> list = new ArrayList<>();
		list.add(new EmployeeVO(200, "홍길동"));
		list.add(new EmployeeVO(201, "김길동"));
		list.add(new EmployeeVO(202, "박길동"));

		list.sort((EmployeeVO o1, EmployeeVO o2) -> o2.getEmployeeId() - o1.getEmployeeId());

		System.out.println(list);

	}// end of main

}

class IdCompare implements Comparator<EmployeeVO> {

	@Override
	public int compare(EmployeeVO o1, EmployeeVO o2) {
		return o1.getEmployeeId() - o2.getEmployeeId();
	}

}

class NameComapre implements Comparator<EmployeeVO> {
	@Override
	public int compare(EmployeeVO o1, EmployeeVO o2) {
		return o1.getFirstName().compareTo(o2.getFirstName());
	}
}