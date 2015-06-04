package main;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * Main method
 * 
 * @author Bradley
 *
 */
public class Main extends StateBasedGame {

	protected static VNDir myDir = new VNDir();

	public static final String gamename = "VN-RW";
	public static final int menu = 0;
	public static final int reader = 1;
	public static final int end = 2;
	public final static int FPS = 60;

	/**
	 * Will add 3 states, the menu, the book, and the end
	 * 
	 * @param gamename - Name of window
	 */
	public Main(String gamename) {
		super(gamename);
		this.addState(new VNMenu(menu, myDir));
		this.addState(new VNReader(reader, myDir));
		this.addState(new VNEnd(end));
	}

	/**
	 * Starts up the listed states init method
	 */
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(reader).init(gc, this);
		// this.enterState(menu);
	}

	/**
	 * Creates and App Game Container which creates the window and set the first state
	 * 
	 * @param args - Command line arguments
	 */
	public static void main(String[] args) {
		AppGameContainer appgc;

		try {
			appgc = new AppGameContainer(new Main(gamename));
			appgc.setDisplayMode(1000, 660, false);
			appgc.setTargetFrameRate(FPS);
			appgc.setShowFPS(false);
			//appgc.setVSync(true);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}