package main;

import java.io.File;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class VNReader extends BasicGameState {
	VNDir myDir;
	VNSound mySound;
	int myState;
	
	public VNReader(int state, VNDir dir, VNSound sound) {
		myDir = dir;
		mySound = sound;
		myState = state;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	}
	
	public int getID() {
		return myState;
	}
}