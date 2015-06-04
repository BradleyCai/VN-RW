package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

/**
 * Main reader for the VN. Will read the VNC and display the commands in there
 * 
 * @author Bradley
 *
 */
public class VNReader extends BasicGameState {
	//VN helping classes
	protected VNDir myDir;
	protected VNSound mySound;
	protected VNSound bgSound;
	protected VNTool myTool;

	//Object helping objects
	protected int myState;
	protected Image bg;
	protected MouseOverArea button;
	protected Input input = new Input(1000);
	protected String error = "";
	protected boolean end = false;
	
	/**
	 * Starts off VNReader with path name information with VNDir and its state
	 * 
	 * @param state - State based game state
	 * @param dir - VNDir to help guide directories
	 */
	public VNReader(int state, VNDir dir) {
		myState = state;
		myDir = dir;
		mySound = new VNSound();
		bgSound = new VNSound();
	}
	
	/**
	 * Will check if mouse is clicked
	 * 
	 * @param button - mouse button
	 * @param x - x
	 * @param y - y
	 * @param clickCount - How many times clicked
	 */
	public void mouseClicked(int button, int x, int y, int clickCount) {
		myTool.clear();
		if(!myTool.hasMore){
			myTool.end = true;
		}
	}
	
	/**
	 * Will initialize state
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		myTool = new VNTool(gc, sbg, mySound, bgSound);
		input.addMouseListener(this);
	}
	
	/**
	 * Stamps the graphics to the screen
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		myTool.load(g);
		if(end){
			sbg.enterState(2, new FadeOutTransition(),
					new FadeInTransition());
		}

	}
	
	/**
	 * Updates the game logic
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	/**
	 * Returns the state based ID
	 * 
	 * @return state based ID
	 */
	public int getID() {
		return myState;
	}
}