package threadexmaple;

public class threadsExample extends Thread {
	

	
	
    public void run() {
        System.out.println("Thread started!");
    }
    
    
   
	
	public static void main(String[] args) {
		threadsExample thread = new threadsExample();
		thread.start();


	}

}
