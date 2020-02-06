package model.clownBuilder;

import model.clownBuilder.stack.Stack;
import model.clownBuilder.stack.StackIF;
import model.gameObjects.Clown;

public class ClownBuilderHouse implements ClownBuilder {
	private StackIF leftStack;
	private StackIF rightStack;
	private int positionX;
	private int positionY;
	private int leftStackCapacity;
	private int rightStackCapacity;

	private Clown clown;

	@Override
	public void createLeftStack() {
		leftStack = new Stack(51 - 40);
	}

	@Override
	public void createRightStack() {
		rightStack = new Stack(157 - 40);

	}

	@Override
	public void setLeftCapacity(int capacity) {
		leftStack.setCapacity(capacity);

	}

	@Override
	public void setRightCapacity(int capacity) {
		rightStack.setCapacity(capacity);

	}

	@Override
	public void addStacksToClown() {
		clown.SetLeftStack(this.leftStack);
		clown.setRightStack(this.rightStack);
	}

	@Override
	public Clown getClown() {
		return clown;
	}

	@Override
	public void setClownIntitialPosition(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	@Override
	public void buildClown() {
		clown = new Clown(positionX, positionY);
	}

	@Override
	public void setStackSPositions() {
		leftStack.setPositionX(positionX + 51);
		leftStack.setPositionY(positionY);
		rightStack.setPositionX(positionX + 157);
		rightStack.setPositionY(positionY);
	}

}
