import java.util.Random;

/**
 * <p>
 *	Interrupt running threads in Java using the built-in thread
 * interruption mechanism.
 * </p>
 * 
 * <p>
 * The full tutorial and the majority of the code is available at
 * https://www.udemy.com/java-multithreading/?dtcode=KmfAU1g20Sjj#/
 * </p>
 * 
 * <p>
 * 
 * @author kanastasov L1087591@live.tees.ac.uk December-2014
 *         </p>
 */

public class App {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting. ");

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Random ran = new Random();

				for (int i = 0; i < 1E8; i++) {
					if(Thread.currentThread().isInterrupted())
					{
						System.out.println("Interrupted!");
						break;
					}
					Math.sin(ran.nextDouble());
				}

			}
		});
		t1.start();
		Thread.sleep(500);
		t1.interrupt();
		
		t1.join();
		System.out.println("Finished");
	}
}