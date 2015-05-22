package main;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import java.io.IOException;

/**
 * Play sounds with this VNSound tool
 * 
 * @author Bradley
 *
 */
public class VNSound {
	protected Clip clip;
	protected boolean isLoop = false;
	
	/**
	 * Constructor that starts off the VNSound tool with a sound. Will not loop
	 * 
	 * @param file - the file path and name of the audio to play
	 */
	public VNSound(File file) {
		try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(file); 
            clip = AudioSystem.getClip();
            clip.open(audio);
            isLoop = false;
            clip.start();
        }
        catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
            System.out.println(lua);
        }
	}
	
	/**
	 * Constructor that starts off the VNSound tool with a sound. Will loop if you tell it to
	 * 
	 * @param file - the file path and name of the audio to play
	 * @param loop - will loop endlessly if true
	 */
	public VNSound(File file, boolean loop) {
		try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(file); 
            clip = AudioSystem.getClip();
            clip.open(audio);
            isLoop = loop;
            if(isLoop)
            	clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
        catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
            System.out.println(lua);
        }
	}
	
	/**
	 * Opens a new sound and replaces the old one. If object is set to loop the sound (isLoop = true) then it will loop
	 * 
	 * @param file - the file path and name of the audio to play
	 */
	public void open(File file) {
		clip.close();
		try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            clip.open(audio);
            if(isLoop)
            	clip.loop(Clip.LOOP_CONTINUOUSLY);
            else
            	clip.loop(0);
            clip.start();
        }
        catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
            System.out.println(lua);
        }
	}
	
	/**
	 * Starts playing the sound
	 */
	public void play() {
		clip.start();
	}
	
	/**
	 * Stops playing the sound
	 */
	public void stop() {
		clip.stop();
	}
	
	/**
	 * Sets isLoop to input TODO clean up loop business
	 * 
	 * @param loop - true will loop false will not
	 */
	public void setLoop(boolean loop) {
		isLoop = loop;
		if(isLoop)
        	clip.loop(Clip.LOOP_CONTINUOUSLY);
        else
        	clip.loop(0);
	}
	
	/**
	 * Return isLoop
	 * 
	 * @return isLoop, true if is looping false if not
	 */
	public boolean getLoop() {
		return isLoop;
	}
}