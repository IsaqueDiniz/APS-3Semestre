package gameStates;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
	
	
	 public void playSong(String path) {
		 try {
			File songPath = new File(path);
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(songPath);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		 }catch(Exception e){
			 System.out.println(e);
		 }
		 
	 }

	

}
