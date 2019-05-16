package gameStates;

import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
	
	private int j,d;
	
	 public void playSong(String path) {
		 j=0;d=0;
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

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}
