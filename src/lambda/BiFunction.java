package lambda;


@FunctionalInterface
public interface BiFunction<T,V> {
	
	int apply(T x,V y);
	
}
