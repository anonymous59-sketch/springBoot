package lambda;

import java.util.stream.Stream;

public class StreamTest2 {
	public static void main(String[] args) {
		String[] strArr = {"키위", "포도", "바나나", "사과", "강", "사과"};
		
		Stream.of(strArr)
		.distinct()
		.sorted()
		.limit(3)
		.forEach(System.out::println);
		
		
	}// end of main
}
