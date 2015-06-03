package main;

import java.io.File;
import java.io.IOException;

import chn.util.*;

/**
 * VNDir class will ensure that a book and a config file both exist.
 * 
 * @author Bradley
 *
 */
public class VNDir {
	//protected FileOutput output;
	protected ConsoleIO keyboard = new ConsoleIO();
	protected File book, config;
	protected String dir;
	private final boolean USE_EXAMPLE = true;
	
	/**
	 * Constructor, will instantiate with config and book file. If book.txt is missing 
	 * then it'll ask to find one. If config.txt is missing, it'll make one
	 */
	public VNDir(){
		dir = System.getProperty("user.dir");
		addSlash(dir);
		
		//If true, then it'll use the example visual provided
		if(USE_EXAMPLE)
			dir = addSlash(System.getProperty("user.dir")) + addSlash("ExampleVN");
		
		//Block for getting the book.txt 
		book = new File(dir + "book.txt");
		while(!book.canRead()) {
			System.out.println("Book not found in current directory, please provide the folder of the visual novel you wish to read");
			System.out.print("Directory: ");
			dir = keyboard.readToken();
			book = new File(addSlash(dir) + "book.txt");
		}
		
		//Block for getting the config.txt
		config = new File(dir + "config.txt");
		if(!config.canRead()) {
			System.out.println("Config file not found. Making one now. Please configure it.");
			try {
				config.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Visual novel successfully loaded at " + dir);
	}
	
	/**
	 * Will add your directory with it's appropriate slash (/ or \)
	 * 
	 * @param dir - String to be added to
	 * @return Your directory string with its appropriate slash, if a
	 */
	public static String addSlash(String dir) {
		if(dir.contains("\\"))
			return dir + "\\";
		else if(dir.contains("/"))
			return dir + "/"; 
		else
			return dir + addSlash(System.getProperty("user.dir")).substring(System.getProperty("user.dir").length(), System.getProperty("user.dir").length() + 1);
	}
	
	public int[] configure() {
		int[] res = new int[1];
		//FileInput input = new FileInput(config.getAbsolutePath());
		
		//if(input.readToken().equals("fps"))
			//res[0] = input.readInt();
		//else
			res[0] = 60;
		
		return res;
	}
	
	/**
	 * Returns pathname of book
	 * 
	 * @return book File object
	 */
	public String getBook() {
		return book.getAbsolutePath();
	}
	
	/**
	 * Returns pathname of config
	 * 
	 * @return config File object
	 */
	public String getConfig() {
		return config.getAbsolutePath();
	}
	
	/**
	 * Returns the working directory
	 * 
	 * @return the working directory
	 */
	public String getWorkingDir() {
		return addSlash(book.getParent());
	}
}