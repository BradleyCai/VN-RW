package main;

import java.io.File;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {

	public static final String gamename = "VN-RW";
	public static final int menu = 0; 
	public static final int FPS = 60;
	
	protected VNDir myDir = new VNDir();
	protected VNSound mySound = new VNSound(new File(""), true);
	
	public Game(String gamename) {
		super(gamename);
		this.addState(new VNMenu(menu, myDir, mySound));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.enterState(menu);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		VNDir dir = new VNDir();
		
		try {
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(1000, 660, false);
			appgc.setTargetFrameRate(FPS);
			appgc.start();
		}
		catch(SlickException e) {
			e.printStackTrace();
		}
	}
}