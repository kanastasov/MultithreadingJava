package threadSynchronization;

/**
 * <p>
 * Gracefully terminating a thread from another thread and introducing the volatile keyword:
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

import java.util.Scanner;

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {

		while (running) {
			System.out.println("Running");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor pro = new Processor();
		pro.start();

		// Wait for the enter key
		new Scanner(System.in).nextLine();

		pro.shutdown();
	}

}