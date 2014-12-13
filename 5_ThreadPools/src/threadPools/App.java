package threadPools;

/** <p>
 * This is the fifth tutorial on how to manage multiple threads in Java using thread pools. 
 * With thread pools you can assign a whole collection of threads to work through your queue of tasks.
 * </p>
 * 
 * <p>
 * The full tutorial and the majority of the code is available at
 * https://www.udemy.com/java-multithreading/?dtcode=KmfAU1g20Sjj#/
 * </p>
 * 
 * <p>
 * @author kanastasov L1087591@live.tees.ac.uk December-2014
 * </p>
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

	private int id;

	public Processor(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Starting: " + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		System.out.println("Completed: " + id);
	}
}

public class App {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}

		executor.shutdown();

		System.out.println("All tasks submitted.");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}

		System.out.println("All tasks completed.");
	}
}