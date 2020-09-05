import java.util.concurrent.Semaphore;

public class DressingRoom implements Runnable {
	
	// fields
	int rooms;
	Semaphore semaphore;
	long waitTimer;
	long startWait;
	long endWait;
	long startRun;
	long endRun;
	long runTimer;
	int numberOfItems;
	Thread runner;
	
	
	// constructor
	public DressingRoom() {
		rooms = 3;
		semaphore = new Semaphore(rooms);
	} // constructor
	
	
	// constructor
	public DressingRoom(int r) {
		rooms = r;
		semaphore = new Semaphore(rooms);
	} // constructor
	
	
	// request
	public void RequestRoom(int num) {
		numberOfItems = num;
		// thread
		this.runner = new Thread(this);
		//start
		startRun = System.nanoTime();
		this.runner.start();
	} // request
	
	
	// random
	public static int GetRandomNumber(int maxValue) {
		int x = 1 + (int)(Math.random()) * maxValue;
		return x;
	} // random
	
	
	// runnable
	@Override
	public void run() {
		
		try {
			
			// check connection with semaphore
			semaphore.acquire();
			
			// edit run time
			endRun = System.nanoTime();
			runTimer += (endRun - startRun);
			
			// get wait time, 1-3 minutes
			int wait = GetRandomNumber(3);
			
			// output status
			System.out.println(Thread.currentThread().getName() + " thread waiting");
			
			// output finish
			System.out.println(Thread.currentThread().getName() + " thread ran");
			
			// start
			startWait = System.nanoTime();
			
			// sleep
			Thread.sleep(wait * numberOfItems);
			
			// end
			endWait = System.nanoTime();
			waitTimer += (endWait - startWait);
			
			// release
			semaphore.release();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // runnable
	
	
	// getter
	public long getWaitTimer() {
		return waitTimer;
	}
	
	
	public long getRunTimer() {
		return runTimer;
	}
	
	
} // class
