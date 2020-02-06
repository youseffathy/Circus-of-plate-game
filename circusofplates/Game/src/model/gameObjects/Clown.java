package model.gameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;
import model.clownBuilder.stack.StackIF;
import model.gameObjects.shapes.ImageObject;
import model.gameObjects.shapes.plate.Shapesloader;
import model.gameWorld.GameWorld;
import model.gameWorld.MyLogger;
import view.MainMenu;

public class Clown implements GameObject {
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private boolean visible = true;
	private StackIF leftStack;
	private StackIF rightStack;
	private BufferedImage[] clownImage = new BufferedImage[1];
	public Clown(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;

		try {
				
			clownImage[0] = ImageIO.read(Clown.class.getResource("/res/joker.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = clownImage[0].getWidth();
		height = clownImage[0].getHeight();
	}

	@Override
	public int getX() {

		return positionX;
	}

	@Override
	public void setX(int x) {
		if(x>positionX) {
			MyLogger.getLogger().info("clown moved right");
		}else {
			MyLogger.getLogger().info("clown moved left");
		}
		leftStack.setPositionX(x + 51);
		rightStack.setPositionX(x + 157);
		positionX = x;

		if (x == 0 || x >= 1100) {

			notifyStacks();
			notifyStopStacks(true);
		} else {
			notifyStopStacks(false);
		}
		leftStack.setPositionX(x + 51);
		rightStack.setPositionX(x + 157);

	}

	@Override
	public int getY() {

		return positionY;
	}

	@Override
	public void setY(int y) {
		// positionY = y;

	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {

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
		return clownImage;
	}

	public void SetLeftStack(StackIF leftStack) {
		this.leftStack = leftStack;
	}

	public StackIF getLeftStack() {
		return leftStack;
	}

	public void setRightStack(StackIF rightStack) {
		this.rightStack = rightStack;
	}

	public StackIF getRightStack() {
		return rightStack;
	}

	public boolean intersectStacks(ImageObject p) {
		int deltaX = 80;
		int deltaY = 3;
		if ((Math.abs(p.getX() - rightStack.getPositionX()) <= deltaX)
				&& (Math.abs(p.getY() - rightStack.getPositiony()) <= deltaY)) {
			if (Shapesloader.getInstance().loadAllclasses().get("model.gameObjects.shapes.HarleyQuinnObject")
					.isInstance(p)) {
				MyLogger.getLogger().info("intersection of harleyquinn with right stack");
				
				return true;
			} if (Shapesloader.getInstance().loadAllclasses().get("model.gameObjects.shapes.BatmanObject")
					.isInstance(p)) {
				MyLogger.getLogger().info("intersection of Batman with right stack");
				
				return true;
			} else if (rightStack.addPlate(p)) {
				MyLogger.getLogger().info("intersection of plate with right stack");
				MyLogger.getLogger().info("plate addded to right stack");
				p.setattached(true);
				notifyStacks();
				return true;
			}
		} else if ((Math.abs(p.getX() - leftStack.getPositionX()) <= deltaX)
				&& (Math.abs(p.getY() - leftStack.getPositiony()) <= deltaY)) {
			if (Shapesloader.getInstance().loadAllclasses().get("model.gameObjects.shapes.HarleyQuinnObject")
					.isInstance(p)) {
				MyLogger.getLogger().info("intersection of harleyquinn with left stack");
				return true;
			} if (Shapesloader.getInstance().loadAllclasses().get("model.gameObjects.shapes.BatmanObject")
					.isInstance(p)) {
				MyLogger.getLogger().info("intersection of Batman with left stack");
				return true;
			} else if (leftStack.addPlate(p)) {
				MyLogger.getLogger().info("intersection of plate with left stack");
				MyLogger.getLogger().info("plate addded to left stack");
				p.setattached(true);
				notifyStacks();
				return true;
			}
		}
		return false;
	}

	public boolean CheckScore(List<GameObject> control) {
		ArrayList<ImageObject> removedplates = rightStack.checkStack();

		if (removedplates.size() == 3) {
			for (int i = 0; i < removedplates.size(); i++) {
				control.remove(removedplates.get(i));
				rightStack.removePlate(removedplates.get(i));
			}
			return true;
		}
		removedplates = leftStack.checkStack();
		if (removedplates.size() == 3) {
			for (int i = 0; i < removedplates.size(); i++) {
				control.remove(removedplates.get(i));
				leftStack.removePlate(removedplates.get(i));
			}
			return true;

		}

		return false;

	}

	public void notifyStacks() {
		leftStack.notifyPlates(positionX);
		rightStack.notifyPlates(positionX);
	}

	public void notifyStopStacks(boolean s) {
		leftStack.StopMoving(s);
		rightStack.StopMoving(s);
	}

}
