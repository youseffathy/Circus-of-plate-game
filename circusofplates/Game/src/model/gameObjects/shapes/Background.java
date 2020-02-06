package model.gameObjects.shapes;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background extends ImageObject {

	public Background(int posX, int posY, int width, int height, Color color) {
		super(posX, posY, width, height, color);
		try {
			spriteImages[0] = ImageIO.read(Background.class.getResource("/res/background.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(true);
	}
}
 