package main;

import java.io.File;
import java.util.List;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame {

	public static final String gamename = "VN-RW";
	//public static final int menu = 0; 
	public static final int reader = 0;
	public static int FPS;
	
	protected VNDir myDir = new VNDir();
	public List config = myDir.configure();
	//protected VNSound mySound = new VNSound(new File(""), true);
	
	public Main(String gamename) {
		super(gamename);
		this.addState(new VNReader(reader, myDir));
		
		FPS = ((Integer)config.get(0)).intValue();
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