package edu.virginia.engine.display;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class SoundManager {

    /*private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;*/


	public SoundManager() {
		
	}
	
	//loads effect
	public void LoadSoundEffect(String id, String filename) {
		
	}
	
	//plays short effect that gets removed once complete
	public void PlaySoundEffect(String id) {
		
	}
	
	//loads music
	public void LoadMusic(String id, String filename) {
		
	}
	
	//plays music on loop forever, possible add looping parameter
	public void PlayMusic(String id) {
		
	}
    /**
     * @param filename the name of the file that is going to be played
     */
	public void playSound(String filename){
	
		String strFilename ="resources"+File.separator+ filename;
		try {
		    File yourFile=new File(strFilename);
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;

		    stream = AudioSystem.getAudioInputStream(yourFile);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
		    //whatevers
		}
    }
}
