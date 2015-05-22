package main;

import java.io.File;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class VNMenu extends BasicGameState {
	protected VNDir myDir;
	protected VNSound mySound;
	protected int myState;
	protected Image bg;
	
	public VNMenu(int state, VNDir dir, VNSound sound) {
		myState = state;
		myDir = dir;
		mySound = sound;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image(myDir.getWorkingDir() + VNDir.addSlash("images") + "placeholder.jpg");
		mySound = new VNSound(new File(myDir.getWorkingDir() + VNDir.addSlash("sounds") + "test.wav"));
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.drawString("VN-RW", 50, 0);
		
		g.drawImage(bg, 0, 0);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	}
	
	public int getID() {
		return myState;
	}
	
}