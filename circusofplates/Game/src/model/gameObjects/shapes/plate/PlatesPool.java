package model.gameObjects.shapes.plate;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.gameObjects.shapes.ImageObject;
import model.gameWorld.MyLogger;

public class PlatesPool {
	private static PlatesPool pool;
	private static List<ImageObject> platesPoolUnused;
	private static Random random;

	private PlatesPool() {
		platesPoolUnused = new LinkedList<>();
		random = new Random();
	}

	public static PlatesPool getInstance() {
		if (pool == null) {
			pool = new PlatesPool();
		}
		return pool;
	}

	public ImageObject PopPlate() {
		if (platesPoolUnused.size() == 0) {
			MyLogger.getLogger().warning("pool is empty");
			return null;
		}
		MyLogger.getLogger().config("a random plate is popped from the pool");
		return platesPoolUnused.remove(random.nextInt(platesPoolUnused.size()));
	}

	public void PushPlate(ImageObject plate) {
		MyLogger.getLogger().config("plate is push to the pool to be reused");
		platesPoolUnused.add(plate);
	}
}
