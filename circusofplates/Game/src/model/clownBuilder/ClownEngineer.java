package model.clownBuilder;

import model.clownBuilder.stack.StackIF;
import model.gameObjects.Clown;

public class ClownEngineer {
	private ClownBuilder clownBuilderHouse;
	private int positionX;
	private int positionY;
	private int leftStackCapacity;
	private int rightStackCapacity;
	
	public ClownEngineer(int PositionX, int positionY, int leftStackCapacity, int rightStackCapacity) {
		clownBuilderHouse = new ClownBuilderHouse();
		this.positionX = PositionX;
		this.positionY = positionY;
		this.leftStackCapacity = leftStackCapacity;
		this.rightStackCapacity = rightStackCapacity;
	}
	
	public void makeClown() {
		clownBuilderHouse.setClownIntitialPosition(positionX, positionY);
		clownBuilderHouse.buildClown();
		clownBuilderHouse.createLeftStack();
		clownBuilderHouse.createRightStack();
		clownBuilderHouse.setLeftCapacity(leftStackCapacity);
		clownBuilderHouse.setRightCapacity(rightStackCapacity);
		clownBuilderHouse.setStackSPositions();
		clownBuilderHouse.addStacksToClown();
	}
	
	public Clown getClown() {
		return clownBuilderHouse.getClown();
	}

}
