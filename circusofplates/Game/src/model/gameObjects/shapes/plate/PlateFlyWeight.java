package model.gameObjects.shapes.plate;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;

import model.gameWorld.MyLogger;

public class PlateFlyWeight {
	private static final HashMap<Color, BufferedImage> rectsByColor = new HashMap<Color, BufferedImage>();
	private static final HashMap<Color, BufferedImage> EllipseByColor = new HashMap<Color, BufferedImage>();
	private static PlateFlyWeight factory;

	private PlateFlyWeight() {

	}

	public static PlateFlyWeight getInstance() {
		if (factory == null) {
			factory = new PlateFlyWeight();
		}
		return factory;

	}

	public  BufferedImage getRectangularPlate(Color color, int width, int height) {
		BufferedImage plate = rectsByColor.get(color);

		if (plate == null) {
			MyLogger.getLogger().config("rectanglar Image from flyweight is created");
			plate = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = plate.createGraphics();
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.black);
			g2.drawRect(0, 0, width - 1, height - 1);
			g2.setPaint(color);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.fillRect(2, 2, width - 4, height - 4);
			rectsByColor.put(color, plate);
		} else {
			MyLogger.getLogger().config("rectanglar Image from flyweight is reused");
		}

		return plate;
	}

	public  BufferedImage getOvalPlate(Color color, int width, int height) {
		BufferedImage plate = EllipseByColor.get(color);

		if (plate == null) {
			MyLogger.getLogger().config("oval Image from flyweight is created");
			plate = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = plate.createGraphics();
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.black);
			g2.drawOval(0, 0, width - 1, height - 1);
			g2.setPaint(color);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.fillOval(2, 2, width - 4, height - 4);
			EllipseByColor.put(color, plate);
		} else {
			MyLogger.getLogger().config("oval Image from flyweight is reused");
		}
		return plate;
	}

	public static BufferedImage getRandomPlate(Color color, int width, int height) {
		Random random = new Random();
		int ran = random.nextInt() % 2;
		BufferedImage plate;
		if (ran == 0) {
			plate = EllipseByColor.get(color);
		} else {
			plate = rectsByColor.get(color);
		}
		if (plate == null) {
			MyLogger.getLogger().config("Random Image from flyweight is created");
			plate = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = plate.createGraphics();
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.black);
			g2.drawOval(0, 0, width - 1, height - 1);
			g2.setPaint(color);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.fillOval(2, 2, width - 4, height - 4);
			EllipseByColor.put(color, plate);
		}else {
			MyLogger.getLogger().config("Random Image from flyweight is reused");
		}
		return plate;
	}
}
