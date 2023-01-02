package streaming;

import java.util.Arrays;
import java.util.List;

public class Streaming {
	
	public static void main(String[] args) {
	
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


	numbers.stream()
		   .map(x -> x * x)
	       .forEach(System.out::println);


	numbers.stream()
	       .filter(x -> x % 2 == 0)
	       .forEach(System.out::println);
	
	numbers.stream()
	       .sorted()
	       .forEach(System.out::println);


	numbers.stream()
	       .distinct()
	       .forEach(System.out::println);


	numbers.stream()
	       .limit(5)
	       .forEach(System.out::println);
	
	numbers.stream()
	       .skip(5)
	       .forEach(System.out::println);
	
	}
	
}
