package interfaces;

public interface Cleanable {
	
	default void clean() {
		System.out.println("Cleaned from dirt");
	}
	
}
