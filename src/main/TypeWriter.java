package main;

/**
 * Prints text to the console like a typewriter
 * 
 * @author Bradley
 *
 */
public class TypeWriter {
	/**
	 * Prints text using a typewriter effect
	 * 
	 * @param text - The text to print
	 * @param ms - Milliseconds between each letter
	 */
	public static void print(String text, int ms) {
		for(int i = 0; i < text.length(); i++) {
			System.out.print(text.substring(i, i+1));
			try {
			    Thread.sleep(ms);
			} 
			catch (InterruptedException e) {
			    e.printStackTrace();
			    Thread.currentThread().interrupt();
			}
		}
	}
	
	/**
	 * Will pause for a certain amount of ms
	 * 
	 * @param ms - milliseconds to pause for
	 */
	public static void wait(int ms) {
		try {
		    Thread.sleep(ms);
		} 
		catch (InterruptedException e) {
		    e.printStackTrace();
		    Thread.currentThread().interrupt();
		}
	}
}