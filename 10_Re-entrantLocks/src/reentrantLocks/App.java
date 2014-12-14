package reentrantLocks;

/**
 * <p>
 * ReentrantLock class in Java as an alternative to synchronized code blocks.
 * ReentrantLocks let you do all the stuff that you can do with synchronized,
 * wait and notify, plus some more stuff besides that may come in handy from
 * time to time.
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
public class App {

	public static void main(String[] args) throws Exception {

		final Runner runner = new Runner();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		runner.finished();
	}

}