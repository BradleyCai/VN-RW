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
	
	/**
	 * Constructor, will instantiate with config and book file. If book.txt is missing 
	 * then it'll ask to find one. If config.txt is missing, it'll make one
	 */
	public VNDir(){
		dir = System.getProperty("user.dir");

		if(dir.contains("\\"))
			dir = dir + "\\"; 
		else
			dir = dir + "/"; 
		
		//Block for getting the book.txt 
		book = new File(dir + "book.txt");
		while(!book.canRead()) {
			System.out.println("Book not found, please provide a folder of the visual novel");
			System.out.print("Directory: ");
			dir = keyboard.readToken();
				if(!dir.substring(dir.length() - 1, dir.length()).equals("/"))
					dir = dir + "/";
			book = new File(dir + "book.txt");
		}
		
		//Block for getting the config.txt
		config = new File(dir + "config.txt");
		if(!config.canRead()) {
			System.out.println("Config file not found. Making one now. Please configure it.");
			try {
				config.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Visual novel successfully loaded");
	}
	
	/**
	 * Returns pathname of book
	 * 
	 * @return book File object
	 */
	public File getBook() {
		return book;
	}
	
	/**
	 * Returns pathname of config
	 * 
	 * @return config File object
	 */
	public File getConfig() {
		return config;
	}
}