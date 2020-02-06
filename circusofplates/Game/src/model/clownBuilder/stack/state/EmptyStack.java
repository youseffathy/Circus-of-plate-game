package model.clownBuilder.stack.state;

import java.util.ArrayList;

import model.clownBuilder.stack.StackIF;
import model.gameObjects.shapes.ImageObject;

public class EmptyStack implements StackState {
	private StackIF stack;

	public EmptyStack(StackIF stack) {
		this.stack = stack;
	}

	@Override
	public boolean AddPlate(ImageObject plate) {
		stack.getStack().add(plate);
		plate.setY(stack.getLimit());
		stack.setLimit(stack.getLimit() - 15);
		plate.setX(stack.getPositionX());
		stack.setState(stack.getUnfullstackState());
		return true;
	}

	@Override
	public boolean removePlate(ImageObject plate) {	
		return false;
	}

	@Override
	public ArrayList<ImageObject> checkConsecutivePlate() {
		return new ArrayList<>();
	}

}
