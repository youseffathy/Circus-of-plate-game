package model.clownBuilder.stack.state;

import java.awt.Color;
import java.util.ArrayList;

import model.clownBuilder.stack.StackIF;
import model.gameObjects.shapes.ImageObject;
import model.gameObjects.shapes.plate.PlatesPool;

public class FullStack implements StackState {
	private StackIF stack;

	public FullStack(StackIF stack) {
		this.stack = stack;
	}

	@Override
	public boolean AddPlate(ImageObject plate) {
		return false;
	}

	@Override
	public boolean removePlate(ImageObject plate) {
		stack.setState(stack.getUnfullstackState());
		stack.setLimit(stack.getLimit() + 15);
		// push the removed plate to the pool to reuse it
		PlatesPool.getInstance().PushPlate(plate);
		return stack.getStack().remove(plate);
	}

	@Override
	public ArrayList<ImageObject> checkConsecutivePlate() {
		ArrayList<ImageObject> arrayList = stack.getStack();
		int size = arrayList.size();
		if(size >=3) {
		Color color1 = arrayList.get(size - 1).getColor();
		Color color2 = arrayList.get(size - 2).getColor();
		Color color3 = arrayList.get(size - 3).getColor();
		if (color1.equals(color2) && color2.equals(color3)) {
			ArrayList<ImageObject> _3Consecutive = new ArrayList<>();
			_3Consecutive.add(arrayList.get(size - 1));
			_3Consecutive.add(arrayList.get(size - 2));
			_3Consecutive.add(arrayList.get(size - 3));
			return _3Consecutive;
		}
		}
		return new ArrayList<>();
	}
}
