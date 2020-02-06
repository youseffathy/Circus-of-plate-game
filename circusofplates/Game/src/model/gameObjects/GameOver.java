package model.gameObjects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;
import model.clownBuilder.stack.StackIF;

public class GameOver implements GameObject {
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private boolean visible;
	private BufferedImage[] image = new BufferedImage[1];

	public GameOver() {
		positionX = 400;
		positionY = 275;
		width = 200;
		height = 100;
		visible = true;
		image[0] = new BufferedImage(400, 150, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = image[0].createGraphics();
		g2.setFont(new Font("SansSerif", Font.BOLD, 48));
		g2.setColor(Color.white);
		FontMetrics fm = g2.getFontMetrics();
		int x = image[0].getWidth() - fm.stringWidth("GAME OVER") - 5;
		int y = fm.getHeight();
		g2.drawString("GAME OVER", x, y);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return positionX;
	}

	@Override
	public void setX(int x) {

	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return positionY;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return image;
	}

}
