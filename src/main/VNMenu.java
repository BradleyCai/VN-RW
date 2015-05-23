//TODO Menu will be worked on later

/*
package main;

import java.io.File;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;

public class VNMenu extends BasicGameState {
	
	
	public VNMenu(int state, VNDir dir) {
		myState = state;
		myDir = dir;
		mySound =  new VNSound();
		//mySound = sound;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image(myDir.getWorkingDir() + VNDir.addSlash("images") + "placeholder.jpg");
		mySound.open(new File(myDir.getWorkingDir() + VNDir.addSlash("sounds") + "test.wav"));	
		mySound.setLoop(true);
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.drawString("VN-RW", 50, 0);
		
		
		if(input.isMouseButtonDown(0)) {
			
		}
		else 
			g.drawImage(bg, 0, 0);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	public int getID() {
		return myState;
	}
}
*/