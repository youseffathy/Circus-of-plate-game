package model.gameObjects.shapes;


import java.awt.*;
import java.awt.geom.Ellipse2D;

import model.gameObjects.shapes.plate.PlateFlyWeight;

public class ElipsePlateObject extends Plate {
	public ElipsePlateObject(int posX, int posY, int width, int height, Color color) {
		super(posX, posY, width, height, color);
		spriteImages[0] = PlateFlyWeight.getOvalPlate(color, width, height);
		setVisible(true);
	}
}