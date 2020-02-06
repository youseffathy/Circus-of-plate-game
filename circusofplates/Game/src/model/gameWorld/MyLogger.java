package model.gameWorld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import model.gameObjects.Clown;

public class MyLogger {

	private static Logger LOGGER;
	private static LogManager logManager;
	private static String path;

	private MyLogger() {

	}

	public static Logger getLogger() {
		if (logManager == null && LOGGER == null) {
			logManager = LogManager.getLogManager();
			Handler handler;
			try {

				FileInputStream fileInputStream = new FileInputStream(
						new File(MyLogger.class.getResource("/res/logging.properties").getFile()));
				logManager.readConfiguration(fileInputStream);
			} catch (Exception e1) {

			}

			LOGGER = Logger.getLogger(MyLogger.class.getName());
			try {
				handler = new FileHandler("log messages" + (new Random()).nextInt() + ".log");
				Logger.getLogger("").addHandler(handler);
			} catch (Exception e) {

			}
		}
	
		return LOGGER;

	}
}
