package main;
import chn.util.*;

public class VNDir {
	FileInput file;
	
	/**
	 * Constructor, will instantiate with config file. If config file is missing then it'll make one
	 */
	public VNDir() {
		try {
			file = new FileInput("config.txt");
		} 		
		catch(Exception E) {
			System.out.println("Config file not found. Making one now. Please configure it.");
			FileOutput config = new FileOutput("config.txt");
		}
		System.out.println("");
			
		
	}
}
