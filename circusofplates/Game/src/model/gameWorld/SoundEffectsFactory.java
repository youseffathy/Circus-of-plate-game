package model.gameWorld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import model.gameObjects.Clown;

public class SoundEffectsFactory {
	private Thread thread;

	public SoundEffectsFactory() {

		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					playMainTheme("resources/joker.mp3");
				}
			}
		};
		new Thread(runnable).start();
	}

	private void playMainTheme(String path) {
		File soundFile = new File(path);
		FileInputStream audioIn;
		try {
			try {
				audioIn = new FileInputStream(soundFile);
				Player player = new Player(audioIn);
				player.play();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void playJokerLaugh() {

		Runnable runnable = new Runnable() {
			public void run() {
				
					playMainTheme("resources/jokerLaugh.mp3");
					thread.stop();
				
			}
		};
		thread = new Thread(runnable);
		thread.start();

	}
}
