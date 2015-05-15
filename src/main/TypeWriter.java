package main;

public class TypeWriter {
	/**
	 * Prints text using a typewriter effect
	 * 
	 * @param text - The text to print
	 * @param ms - Milliseconds between each letter
	 */
	static void print(String text, int ms) {
		
		for(int i = 0; i < text.length(); i++) {
			System.out.print(text.substring(i, i+1));
			try {
			    Thread.sleep(100);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			    Thread.currentThread().interrupt();
			}
		}
	}
}