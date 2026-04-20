package lambda;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		int total = numbers.stream()
					.mapToInt(a -> a)
					.filter(a -> a % 2 == 0)
					.sum();
		
		System.out.println(total);
		
	}// end of main
	
}
