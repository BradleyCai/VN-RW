package main;

import java.io.File;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class VNReader extends BasicGameState {
	protected VNDir myDir;
	protected VNSound mySound;
	protected int myState;
	protected Image bg;
	protected MouseOverArea button;
	protected Input input = new Input(0);
	
	public VNReader(int state, VNDir dir) {
		myState = state;
		myDir = dir;
		mySound =  new VNSound();
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image(myDir.getWorkingDir() + VNDir.addSlash("images") + "placeholder.jpg");
		mySound.open(new File(myDir.getWorkingDir() + VNDir.addSlash("sounds") + "test.wav"));	
		mySound.setLoop(true);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(input.isMouseButtonDown(0)) {}
		else 
			g.drawImage(bg, 0, 0);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	public int getID() {
		return myState;
	}
}