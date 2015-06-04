package main;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.*;

/**
 * Menu screen
 * 
 * @author Terry
 *
 */
public class VNMenu extends BasicGameState {

	Image playDemo;
	Image exitReader;
	public String mouses = "none"; // for testing and analysis
	protected int myState;
	protected VNDir myDir;
	protected Image bg;
	protected Input input;

	/**
	 * Constructor. Starts the object off with a state ID and a VNDir class
	 * 
	 * @param state - sbg ID
	 * @param dir - VNDir to help with working directory things
	 */
	public VNMenu(int state, VNDir dir) {
		myState = state;
		myDir = dir;

		// mySound = sound;
	}

	/**
	 * Initializes state
	 * 
	 * @param gc
	 *            GameContainer
	 * @param sbg
	 *            StateBasedGame
	 */
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		playDemo = new Image(myDir.getWorkingDir() + VNDir.addSlash("images")
				+ "best.png");

	}

	/**
	 * "Draws" with Graphics object
	 * 
	 * @param gc
	 *            GameContainer
	 * @param sbg
	 *            StateBasedGame
	 * @param g
	 *            Graphics
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		playDemo.draw(0, 0);

		//g.drawString(mouses, 50, 50);

	}

	/**
	 * When things change
	 * 
	 * @param gc
	 *            GameContainer
	 * @param sbg
	 *            StateBasedGame
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		mouses = posX + "," + posY;

		if ((posX > 790 && posX < 961) && (posY > 419 && posY < 480)) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(1, new FadeOutTransition(),
						new FadeInTransition());
			}
		}
		if ((posX > 790 && posX < 852) && (posY > 218 && posY < 274)) {
			if (Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
	}

	/**
	 * @return State ID
	 */
	public int getID() {
		return myState;
	}
}