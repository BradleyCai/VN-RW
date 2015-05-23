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
	protected AudioInputStream audio;
	
	/**
	 * Constructor that starts off the VNSound tool with a sound. Will not loop
	 * 
	 * @param file - the file path and name of the audio to play
	 */
	public VNSound(File file) {
		try {
            audio = AudioSystem.getAudioInputStream(file); 
            clip = AudioSystem.getClip();
            clip.open(audio);
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
			isLoop = loop;
            audio = AudioSystem.getAudioInputStream(file); 
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            if(isLoop)
            	clip.loop(Clip.LOOP_CONTINUOUSLY);
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
		System.out.println(isLoop);
	}
	
	/**
	 * A constructor for those who dont want open any sound and just have a VNSound tool nearby to use.
	 */
	public VNSound() {
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException lue) {
			lue.printStackTrace();
		}
	}
	
	/**
	 * Opens a new sound and replaces the old one. If object is set to loop the sound (isLoop = true) then it will loop
	 * 
	 * @param file - the file path and name of the audio to play
	 */
	public void open(File file) {
		try {
			clip.stop();
            clip.close();
            audio = AudioSystem.getAudioInputStream(file);
            clip.open(audio);
            clip.start();
            if(isLoop)
            	clip.loop(Clip.LOOP_CONTINUOUSLY);
            else
            	clip.loop(0);
        }
        catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
            System.out.println(file);
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