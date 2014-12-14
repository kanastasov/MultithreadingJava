package deadlocks;
/**
 * <p>
 * The causes of deadlock and two things you can do about it. This video also
 * covers how to write a method that can safely acquire any number of locks in
 * any order without causing deadlock, using the tryLock() method of
 * ReentrantLock.
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
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    
    private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
        while(true) {
            // Acquire locks
            
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            
            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            }
            finally {
                if(gotFirstLock && gotSecondLock) {
                    return;
                }
                
                if(gotFirstLock) {
                    firstLock.unlock();
                }
                
                if(gotSecondLock) {
                    secondLock.unlock();
                }
            }
            
            // Locks not acquired
            Thread.sleep(1);
        }
    }

    public void firstThread() throws InterruptedException {

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {

            acquireLocks(lock1, lock2);

            try {
            	Account.transfer(acc1, acc2, random.nextInt(100));
//                Account.transfer(acc1, acc2, );
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            
            acquireLocks(lock2, lock1);

            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: "
                + (acc1.getBalance() + acc2.getBalance()));
    }
}