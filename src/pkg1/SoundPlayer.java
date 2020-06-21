package pkg1;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * The <code>SoundPlayer</code> class is used to manage and play a sound in the .wav or .au format.
 * Starting, stopping, and looping the sounds is supported. It is also possible to change the volume 
 * of the sound being played. 
 * 
 * @author jonatanfontanez
 */
public class SoundPlayer {
	private int soundType; 	//	0 - normal
							//	1 - music
							//	2 - sound effects
	private Clip clip;
	private String fileName;
	private Thread t;

	/**
	 * Initializes a new <code>SoundPlayer</code> object through the file name. The sound must be within
	 * the specific file folder, or an exception will be thrown.
	 * 
	 * @param fileName the name of the file in <code>String</code> format
	 */
	public SoundPlayer(final String fileName) {
		this.fileName = fileName;
		try {
			clip = AudioSystem.getClip();
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(sounds.EmptyClass.class.getResource(this.fileName));
	        clip.open(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SoundPlayer(final String fileName, final int type) {
		soundType = type;
		this.fileName = fileName;
		try {
			clip = AudioSystem.getClip();
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(sounds.EmptyClass.class.getResource(this.fileName));
	        clip.open(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Plays the sound through the computers speakers at the volume set by the <code>setVolume</code>
	 * method. If no volume is chosen, it will play at the sound's default volume.
	 */
	public void playSound() {
		try {
			t = new Thread(new Runnable() {
				public void run() {
					try {
				        clip.start(); 
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			t.start();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
        		stopSound();
        		try {
				clip = AudioSystem.getClip();
        			AudioInputStream inputStream = AudioSystem.getAudioInputStream(sounds.EmptyClass.class.getResource(this.fileName));
        			clip.open(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
	
	/**
	 * Stops the sound. If the sound had already been stopped, this method will have no effect.
	 * 
	 * @return if the sound was successfully stopped
	 */
	public boolean stopSound() {
		if(!t.isInterrupted()) {
			t.interrupt();
			clip.stop();
			return true;
		}
		return false;
	}
	
	/**
	 * Loops the sound continuously.
	 */
	public void loopSound() {
		loopSound(Clip.LOOP_CONTINUOUSLY);
	}
	
	/**
	 * Loops the sound <code>loopCount</code> times.
	 * 
	 * @param loopCount the amount of times to loop the sound
	 */
	public void loopSound(int loopCount) {
		try {
			t = new Thread(new Runnable() {
				public void run() {
					try {
				        clip.loop(loopCount);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			t.start();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
        		stopSound();
        }
	}
	
	/**
	 * 
	 * @return the current volume of the sound
	 */
	public float getVolume() {
	    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
	    return (float) Math.pow(10f, gainControl.getValue() / 20f * (ArcadeData.generalVolume/100f) * 
	    		(soundType == 1 ? (ArcadeData.musicVolume/100f): soundType == 2 ? (ArcadeData.soundEffectsVolume/100f):1f));
	}

	/**
	 * Sets the volume of the sound to <code>volume</code>.
	 * 
	 * @param volume the volume to set the sound at, from <code>0.0f</code> to <code>1.0f</code>.
	 */
	private void setVolume(float volume) {
	    if (volume < 0f || volume > 1f)
	        throw new IllegalArgumentException("Volume not valid: " + volume);
	    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
	    gainControl.setValue(20f * (float) Math.log10(volume * (ArcadeData.generalVolume/100f) * 
	    		(soundType == 1 ? (ArcadeData.musicVolume/100f): soundType == 2 ? (ArcadeData.soundEffectsVolume/100f):1f)));
	}
	
	/**
	 * Sets the volume of the sound to <code>volume</code>.
	 * 
	 * @param volume the volume to set the sound at, from <code>0.0</code> to <code>1.0</code>.
	 */
	public void setVolume(double volume) {
	    setVolume((float)volume);
	}
	
	public String getFileName() {return fileName;}

}
