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
	protected VNSound bgSound;
	protected VNTool myTool;

	protected int myState;
	protected Image bg;
	protected MouseOverArea button;
	protected Input input = new Input(0);
	
	public VNReader(int state, VNDir dir) {
		myState = state;
		myDir = dir;
		mySound = new VNSound();
		bgSound = new VNSound();
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		myTool = new VNTool(gc, sbg, mySound, bgSound);
		bg = new Image(myDir.getWorkingDir() + VNDir.addSlash("images") + "placeholder.jpg");
		mySound.open(new File(myDir.getWorkingDir() + VNDir.addSlash("sounds") + "test.wav"));	
		mySound.setLoop(true);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(bg, 0, 0);
		g.drawRect(50, 50, 500, 500);
		myTool.displayString("Uguu senpai am I cute? Uguu senpai am I cute? Uguu senpai am I cute? "
				+ "Uguu senpai am I cute? Uguu senpai am I cute? Uguu senpai am I cute? ", 100, g);
		
		if(input.isMouseButtonDown(0))
			myTool.clear(g);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	public int getID() {
		return myState;
	}
}