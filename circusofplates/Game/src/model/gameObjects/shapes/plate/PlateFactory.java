package model.gameObjects.shapes.plate;

import java.awt.Color;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import model.gameObjects.shapes.ImageObject;
import model.gameWorld.MyLogger;

public class PlateFactory {
	private static PlateFactory factory;
	private static Random randomGenerator;
	private static Shapesloader shapesloader;
	private final Color[] colors = new Color[] { Color.BLUE, Color.ORANGE, Color.CYAN, Color.DARK_GRAY, Color.MAGENTA,
			Color.GRAY, Color.YELLOW, Color.GREEN, Color.PINK, Color.black, Color.LIGHT_GRAY, Color.red };
	private static int numberOfColors;
	private static PlatesPool pool;

	private PlateFactory() {
		randomGenerator = new Random();
	}

	public static PlateFactory getInstance(int numColors) {

		numberOfColors = numColors;
		if (factory == null) {
			pool = PlatesPool.getInstance();
			shapesloader = Shapesloader.getInstance();
			factory = new PlateFactory();
		}
		return factory;
	}

	public ImageObject getPlate(int width, int height) {
		int PlateType = randomGenerator.nextInt(2);
		ImageObject plate;
		// get a plate from the pool.
		plate = pool.PopPlate();

		if (plate != null) {
			Color color = colors[randomGenerator.nextInt(numberOfColors)];
			plate.setColor(color);
			plate.setSpirteImage(PlateFlyWeight.getRandomPlate(color, 80, 15));
			plate.setattached(false);
			plate.setStopMoving(false);
			plate.setX(Math.abs(randomGenerator.nextInt(width - 80)));
			plate.setY(randomGenerator.nextInt(80));
			return plate;
		}
		if (PlateType == 0) {
			// dynamic loading
			MyLogger.getLogger().info("rectanglar Plate instance is returned from factory ");
			Class<? extends ImageObject> s = shapesloader.load("model.gameObjects.shapes.RegtanglePlateObject");
			Class[] parameterTypes = new Class[] { int.class, int.class, int.class, int.class, Color.class };
			try {
				Constructor constructor = s.getConstructor(parameterTypes);
				plate = (ImageObject) constructor.newInstance(Math.abs(randomGenerator.nextInt(width - 80)),
						randomGenerator.nextInt(80), 80, 15, colors[randomGenerator.nextInt(numberOfColors)]);
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				plate = null;
				e.printStackTrace();
			}
			// plate = new
			// RegtanglePlateObject(Math.abs(randomGenerator.nextInt(width-80)),randomGenerator.nextInt(80)
			// , 80, 15, colors[randomGenerator.nextInt(3)]);
		} else {
			MyLogger.getLogger().info("oval Plate instance is returned from factory ");
			Class<? extends ImageObject> s = shapesloader.load("model.gameObjects.shapes.ElipsePlateObject");
			Class[] parameterTypes = new Class[] { int.class, int.class, int.class, int.class, Color.class };
			try {
				Constructor constructor = s.getConstructor(parameterTypes);
				plate = (ImageObject) constructor.newInstance(Math.abs(randomGenerator.nextInt(width - 80)),
						randomGenerator.nextInt(80), 80, 15, colors[randomGenerator.nextInt(numberOfColors)]);
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				plate = null;
				e.printStackTrace();
			}
			// plate = new ElipsePlateObject(Math.abs(randomGenerator.nextInt(width - 80)),
			// randomGenerator.nextInt(80),80, 15, colors[randomGenerator.nextInt(3)]);
		}

		return plate;
	}

	public ImageObject getBatmanLogo(int width, int height) {
		ImageObject plate = null;
		MyLogger.getLogger().info("batman logo instance is returned from factory ");
		Class<? extends ImageObject> s = shapesloader.load("model.gameObjects.shapes.BatmanObject");
		Class[] parameterTypes = new Class[] { int.class, int.class, int.class, int.class, Color.class };
		try {
			Constructor constructor = s.getConstructor(parameterTypes);
			plate = (ImageObject) constructor.newInstance(Math.abs(randomGenerator.nextInt(width - 80)),
					randomGenerator.nextInt(80), 80, 15, colors[randomGenerator.nextInt(numberOfColors)]);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return plate;
	}

	public ImageObject getHarleyLogo(int width, int height) {
		ImageObject plate = null;
		MyLogger.getLogger().info("harley logo instance is returned from factory ");
		Class<? extends ImageObject> s = shapesloader.load("model.gameObjects.shapes.HarleyQuinnObject");
		Class[] parameterTypes = new Class[] { int.class, int.class, int.class, int.class, Color.class };
		try {
			Constructor constructor = s.getConstructor(parameterTypes);
			plate = (ImageObject) constructor.newInstance(Math.abs(randomGenerator.nextInt(width - 80)),
					randomGenerator.nextInt(80), 80, 15, colors[randomGenerator.nextInt(numberOfColors)]);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return plate;
	}

}
