package multipleLocks;

/** <p>
 * This is the fourth part of the advanced Java multi-threading tutorial. 
 * In this tutorial we can use multiple locks to speed up complex multi-threaded
 *  code, sometimes dramatically.
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

	public static void main(String[] args) {

		Worker worker = new Worker();
		worker.main();
	}

}
