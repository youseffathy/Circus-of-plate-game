package model.clownBuilder.stack.state;

import java.util.ArrayList;

import model.gameObjects.shapes.ImageObject;

public interface StackState {
	public boolean AddPlate(ImageObject plate);
	public boolean removePlate(ImageObject plate);
	public ArrayList<ImageObject> checkConsecutivePlate();
}
