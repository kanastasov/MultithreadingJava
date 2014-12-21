package multithreadedSwings;

/**
 * <p>
 *	SwingWorker is a ferocious-looking but useful class that's perfect
 * for running stuff in the background while simultaneously updating 
 * progress bars and that sort of thing.
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

import javax.swing.SwingUtilities;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame("SwingWorker Demo");
			}
		});
	}

}