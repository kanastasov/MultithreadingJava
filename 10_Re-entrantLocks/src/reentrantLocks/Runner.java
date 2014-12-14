package reentrantLocks;

/** <p>
 * ReentrantLock class in Java as an alternative to synchronized code blocks. 
 * ReentrantLocks let you do all the stuff that you can do with synchronized, 
 * wait and notify, plus some more stuff besides that may come in handy from time to time.
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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();

		System.out.println("Waiting ....");
		cond.await();

		System.out.println("Woken up!");

		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() throws InterruptedException {

		Thread.sleep(1000);
		lock.lock();

		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");

		cond.signal();

		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}