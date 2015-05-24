package main;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import java.io.IOException;

/**
 * Play sounds with this VNSound tool. When initialized, will not loop.
 * Sounds start off at 0 decibels/93 percent volume
 * 
 * @author Bradley
 *
 */
public class VNSound {
	protected Clip clip;
	protected boolean isLoop = false;
	protected AudioInputStream audio;
	FloatControl volumeControl;
	
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
	 * Constructor that starts off the VNSound tool with a sound at a certain volume. Will not loop.
	 * 
	 * @param file - the file path and name of the audio to play
	 * @param volume - volume to play the file at
	 */
	public VNSound(File file, float volume) {
		try {
            audio = AudioSystem.getAudioInputStream(file); 
            clip = AudioSystem.getClip();
            clip.open(audio);
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            setVolume(volume);
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
			volumeControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
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
	 * Will open a new file for a certain volume.
	 * 
	 * @param file
	 * @param volume
	 */
	public void open(File file, float volume) {
		try {
			clip.stop();
            clip.close();
            audio = AudioSystem.getAudioInputStream(file);
            clip.open(audio);
			volumeControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            setVolume(volume);
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
	 * Will set volume to the volume inputed. If volume input is greater than 100 or less than 0
	 * then then the respective maximum or minimum volume will be input instead.
	 * 
	 * @param volume - volume to have audio at, from 0 to 100
	 */
	public void setVolume(float volume) {
		if(volume > 0 && volume < 100)
			volumeControl.setValue((86.0206f*volume/100) - 80);
		else if (volume >= 100)
			volumeControl.setValue(6.0206f);
		else
			volumeControl.setValue(-80f);
}
	
	/**
	 * Gives the volume of the VNSound in percent
	 * 
	 * @return Current volume of VNSound
	 */
	public float getVolume() {
		System.out.println(((volumeControl.getValue() + 80.0f)/86.0206f)*100);
		return ((volumeControl.getValue() + 80.0f)/86.0206f)*100;
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