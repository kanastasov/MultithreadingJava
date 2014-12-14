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
public class App {

    public static void main(String[] args) throws InterruptedException {

        final Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
}