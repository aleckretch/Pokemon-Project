package view;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * This class allows music to play
 */
public class MusicPlayer {
	private static Clip clip;
	private static File currentFile;
	
	/**
	 * plays the music on an infinite loop
	 * @param takes a string of the file name for the sound
	 */
	public static void play(String soundName){
		 pause();
		 File sound = new File(soundName);
		 currentFile = sound;
		 PlaySound(sound, false);
	}
	/**
	 * plays the music one time
	 * @param takes a string of the file name for the sound
	 */
	public static void playOnce(String soundName){
		 pause();
		 File sound = new File(soundName);
		 currentFile = sound;
		 PlaySound(sound, true);
	}
	/**
	 * plays the music one time
	 * @param takes a string of the file name for the sound
	 */
	public static void playTransition(String soundName){
		 pause();
		 File sound = new File(soundName);
		 currentFile = sound;
		 PlaySound(sound, true);
		 
		 try{
			 Thread.sleep(clip.getMicrosecondLength()/1000);
		 }catch (Exception e){
			 e.printStackTrace();
		 }
	}
	/**
	 * this method actually makes the sound play
	 * @param takes a sound file
	 * @param takes a boolean of whether to play once or infinitely
	 */
	public static void PlaySound(File sound, boolean once){
		pause();
		try{
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			if (once)
				clip.start();
			else
				clip.loop(100);
			//Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * pauses the music clip
	 * 
	 */
	public static void pause(){
		if (clip != null)
			clip.stop();
	}
	/**
	 * resumes the music clip
	 * 
	 */
	public static void resume(){
		clip.start();
	}
}
