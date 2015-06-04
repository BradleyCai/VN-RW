package main;

import java.io.File;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.Color;

import chn.util.FileInput;

/**
 * Tool to display VN type things onto the screen
 * 
 * @author Bradley
 *
 */
public class VNTool {
	// Slick graphics things
	protected GameContainer gc;
	protected StateBasedGame sbg;

	// Path name and files
	protected VNDir myDir = new VNDir();
	protected String pathName = myDir.getBook();
	protected FileInput file = new FileInput(pathName);

	// Graphics and sound
	protected VNSound mySound;
	protected VNSound bgSound;
	protected Image bgImage;
	protected Image image;

	/* For class use */
	protected int i = 0; // The current character the VNTool is on
	protected boolean loaded = false; // Whether the not the commands up until
										// the "dialog" command are loaded
	protected Color transparentGrey = new Color(240, 240, 240, 200);

	/**
	 * Constructor for VNTool. Will take the GameContainer, StateBasedGame, and
	 * VNSound classes from where ever it's called and initialize them.
	 * 
	 * @param gameC
	 *            - Game container object from slick
	 * @param stateBG
	 *            - State based game object from slick
	 * @param sound
	 *            - VNSound class for holding etc sounds other than the bg music
	 * @param bg
	 *            - VNSound class specifically for holding the bg music
	 */
	public VNTool(GameContainer gameC, StateBasedGame stateBG, VNSound sound,
			VNSound bg) {
		gc = gameC;
		sbg = stateBG;
		mySound = sound;
		bgSound = bg;
	}

	public void load(Graphics g) throws SlickException {
		while (!loaded) {
			String line = file.readLine();
			int fileI = 0;
			char command = 0;

			while (command != 'd') {
				command = line.charAt(fileI + 1);

				switch (command) {
				case 'i':
					image = new Image(this.getStringArg(line, fileI));
					fileI = fileI + this.getStringArg(line, fileI).length();
					break;
				case 's':
					String path = this.getStringArg(line, fileI);
					fileI = fileI + this.getStringArg(line, fileI).length();
					bgSound.open(new File(path), this.getIntArg(line, fileI));
					fileI = fileI
							+ String.valueOf(this.getIntArg(line, fileI))
									.length();
				}
				// g.drawImage(new Image(line.substring(line.indexOf('(', fileI)
				// + 1, line.indexOf(',', fileI))), gc.getWidth()/2,
				// gc.getHeight());
			}
			// fileI = line.substring(fileI + 1, line.length()).indexOf('\\');
		}
	}

	/**
	 * When given a line of VNC code, it will return the first string of the
	 * string argument.
	 * 
	 * @param str
	 *            - Line to pull string argument from
	 * @return First string argument found from the input string
	 */
	public String getStringArg(String str) {
		return str.substring(str.indexOf('"') + 1, str.indexOf(',') + 1);
	}

	/**
	 * When given a line of VNC code, returns the first string argument within
	 * this string, starting the search at the specified index.
	 * 
	 * @param str
	 *            - Line to pull string argument from
	 * @param index
	 *            - Start the search of the string argument from this index
	 * @return First string arugment fround from the input string starting from
	 *         the "fromIndex"
	 */
	public String getStringArg(String str, int fromIndex) {
		return str.substring(str.indexOf('(', fromIndex) + 1,
				str.indexOf(',', fromIndex) + 1);
	}

	/**
	 * When given a line of VNC code, returns the first int argument within this
	 * string, starting the search at the specified index.
	 * 
	 * @param str
	 *            - Line of VNC code to pull int argument from
	 * @param fromIndex
	 *            - Start the search of the string argument from this index
	 * @return First int argument from the input line of VNC, starting the
	 *         search at "fromIndex"
	 */
	public int getIntArg(String str, int fromIndex) {
		int index = Integer.MAX_VALUE;
		int newIndex = -1;

		for (int n = 0; n < 10; n++) {
			newIndex = str.charAt(str.indexOf(',') + 1);
			if ((newIndex < index) && (newIndex != -1))
				index = newIndex;
		}

		return Integer.parseInt(str.substring(index, str.indexOf(',', index)));
	}

	public int getNextIndex(String str, int index) {
		int temp = -1;
		// Slash
		int resIndex = str.indexOf('\\', index + 1);

		// Comma
		temp = str.indexOf(',', index + 1);
		if ((temp < resIndex) && (temp != -1))
			resIndex = temp;

		// Parenthesis
		temp = str.indexOf('(', index + 1);
		if ((temp < resIndex) && (temp != 1))
			resIndex = temp;

		return resIndex + 1;
	}

	/**
	 * Will display a string to the window, character by character. To reset,
	 * make i = 0.
	 * 
	 * @param text
	 *            - Text to display to the window
	 * @param lineLen
	 *            - How long you want the window to be
	 * @param g
	 *            - The graphics windows to display the String to
	 */
	public void drawString(String text, int lineLen, Graphics g) {
		if (i < text.length()) {
			int line = 0;
			for (int k = 1; k <= i; k++) {
				if (k % lineLen == 0) {
					line++;
				}
				// TODO Implement
				g.drawString(text.substring(k - 1, k),
						((k - 1) % lineLen * 10) + 30, line * 20 + 475);
			}
		} else {
			int line = 0;
			for (int k = 1; k <= text.length(); k++) {
				if (k % lineLen == 0) {
					line++;
				}
				g.drawString(text.substring(k - 1, k),
						((k - 1) % lineLen * 10) + 30, line * 20 + 475);
			}
		}
		i++;
	}

	public void drawDialogBox(Graphics g) {
		// x: 20 y: 470 width: 960 height: 640 - 470
		// g.drawRect(20, 470, 960, 170);
		g.fill(new Rectangle(20, 470, 960, 170), new GradientFill(20f, 470f,
				transparentGrey, 980f, 660f,
				transparentGrey));

	}

	public void drawDialog(String text, int lineLen, Graphics g) {
		this.drawDialogBox(g);
		this.drawString(text, lineLen, g);
	}

	public void clear(Graphics g) {
		i = 0;
		// g.clear();
	}
	// public boolean displayDone() { }
}
