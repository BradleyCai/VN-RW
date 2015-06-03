package main;

import java.io.File;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import chn.util.FileInput;

/**
 * Tool to display VN type things onto the screen
 * 
 * @author Bradley
 *
 */
public class VNTool {
	protected GameContainer gc;
	protected StateBasedGame sbg;
	protected VNDir myDir = new VNDir();

	protected int i = 0;
	protected boolean loaded = false;
	protected String pathName = myDir.getBook();
	protected FileInput file = new FileInput(pathName);
	protected VNSound mySound;
	protected VNSound bgSound;
	protected Image bgImage;
	protected Image image;

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
			int lineI = 0;
			char commandChar = 0;

			while (commandChar != 'd') {
				commandChar = line.charAt(lineI + 1);

				switch (commandChar) {
				case 'i':
					image = new Image(this.getStringArg(line, lineI));
					lineI = lineI + this.getStringArg(line, lineI).length();
					break;
				case 's':
					String path = this.getStringArg(line, lineI);
					lineI = lineI + this.getStringArg(line, lineI).length();
					bgSound.open(new File(path), this.getIntArg(line, lineI));
					lineI = lineI + String.valueOf(this.getIntArg(line, lineI)).length();
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
		//Slash
		int resIndex = str.indexOf('\\', index + 1);
		
		//Comma
		temp = str.indexOf(',', index + 1);
		if((temp < resIndex) && (temp != -1))
			resIndex = temp;
		
		//Parenthesis
		temp = str.indexOf('(', index + 1);
		if((temp < resIndex) && (temp != 1))
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
	public void displayString(String text, int lineLen, Graphics g) {
		if (i < text.length()) {
			int line = 0;
			for (int k = 1; k <= i; k++) {
				if (k % lineLen == 0) {
					line++;
				}
				g.drawString(text.substring(k - 1, k), (k - 1) % lineLen * 10,
						line * 20);
			}
		} else {
			int line = 0;
			for (int k = 1; k <= text.length(); k++) {
				if (k % lineLen == 0) {
					line++;
				}
				g.drawString(text.substring(k - 1, k), (k - 1) % lineLen * 10,
						line * 20);
			}
		}
		i++;
	}

	public void clear(Graphics g) {
		i = 0;
		// g.clear();
	}
	// public boolean displayDone() { }
}
