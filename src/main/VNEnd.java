package main;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * State of the end
 * 
 * @author Bradley
 *
 */
public class VNEnd extends BasicGameState{
	protected int myState;
	protected VNSound myBg;
	protected Input input;
	
	/**
	 * Just a state to define this state based game
	 * 
	 * @param state = state ID
	 */
	public VNEnd(int state) {
		myState = state;
	}
	
	/**
	 * Init method, nothing in it.
	 */
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
	}
	
	/**
	 * Render graphics to the screen. Will render "The end"
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("The End", 475, 330);
		if (Mouse.isButtonDown(0)) {
			System.exit(0);
		}
	}
	
	/**
	 * Update the game logic
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
	}
	
	/**
	 * @return return state based ID
	 */
	public int getID() {
		return myState;
	}
}
