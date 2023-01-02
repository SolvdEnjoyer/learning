package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class lambdaExamples {
	public static void main(String[] args ) {
		
		
		BiFunction<Integer, Integer> sum = (x, y) -> x + y;
		int result = sum.apply(10, 20);
		System.out.println(result);
		
		Function<String> join = (list) -> String.join(", ", list);
		String joined = join.apply(Arrays.asList("apple", "banana", "cherry"));
		System.out.println(joined);
		
		Predicate<Integer> isPositive = x -> x > 0;
		BinaryOperator<Integer> max = (x, y) -> x > y ? x : y;
		Supplier<String> greet = () -> "Hello, World!";
		Consumer<Integer> print = x -> System.out.println(x);
		
	}
}