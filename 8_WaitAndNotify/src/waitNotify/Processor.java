package waitNotify;

/** <p>
 * 	Wait and notify in Java; low-level multithreading methods of the
 *  Object class that allow you to have one or more threads sleeping,
 *  only to be woken up by other threads at the right moment.
 *  Extremely useful for avoiding those processor-consuming polling loops.
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


public class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running ....");
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException {
        
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        
        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(5000);
        }
    }
}