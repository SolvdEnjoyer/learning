package threadexmaple;

public class MyRunnable implements Runnable {
	
	
	public void run() {
	    System.out.println("Thread started!");   
	}
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}
}
