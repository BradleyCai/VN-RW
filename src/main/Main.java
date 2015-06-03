package main;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame {

	protected static VNDir myDir = new VNDir();
	//protected static int[] config = myDir.configure();
	
	public static final String gamename = "VN-RW";
	//public static final int menu = 0; 
	public static final int reader = 0;
	public final static int FPS = myDir.configure()[0];
	
	//protected VNSound mySound = new VNSound(new File(""), true);
	
	public Main(String gamename) {
		super(gamename);
		this.addState(new VNReader(reader, myDir));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(reader).init(gc, this);
		//this.enterState(menu);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		
		try {
			appgc = new AppGameContainer(new Main(gamename));
			appgc.setDisplayMode(1000, 660, false);
			appgc.setTargetFrameRate(FPS);
			appgc.start();
		}
		catch(SlickException e) {
			e.printStackTrace();
		}
	}
}