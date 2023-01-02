package lambda;

import java.util.List;

@FunctionalInterface
public interface Function<S> {
	
	String apply(List<S> list);

}
