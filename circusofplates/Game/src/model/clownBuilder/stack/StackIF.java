package model.clownBuilder.stack;

import java.util.ArrayList;

import model.clownBuilder.stack.state.StackState;
import model.gameObjects.shapes.ImageObject;

public interface StackIF {
	/**
	 * 
	 * @param state
	 */
	public void setUnfullstackState(StackState state);
	/**
	 * 
	 * @param state
	 */
	public void setfullstackState(StackState state);
	/**
	 * 
	 * @param state
	 */
	public void setEmptystackState(StackState state);

	/**
	 * 
	 * @return
	 */
	public StackState getCurrentState();

	/**
	 * 
	 * @return
	 */
	public int getRelativeXtoClown();

	/**
	 * 
	 * @param plates
	 */
	public void setStack(ArrayList<ImageObject> plates);

	/**
	 * 
	 * @return
	 */
	public ArrayList<ImageObject> getStack();

	/**
	 * state
	 * 
	 * @param plate
	 * @param key
	 * @return
	 */
	public boolean addPlate(ImageObject plate);

	/**
	 * state
	 * 
	 * @param positionFromTop
	 * @return
	 */
	public boolean removePlate(ImageObject plate);

	/**
	 * state
	 * 
	 * @param capacity
	 */
	public void setCapacity(int capacity);

	/**
	 * 
	 * @return
	 */
	public int getCapacity();

	/**
	 * 
	 * @return
	 */
	public int getSize();

	/**
	 * 
	 * @return
	 */
	public int getPositionX();

	/**
	 * 
	 */
	public void setPositionX(int positionX);

	/**
	 * 
	 * @return
	 */
	public int getPositiony();

	/**
	 * 
	 * @param positiony
	 */
	public void setPositionY(int positiony);

	/**
	 * 
	 * @param x
	 */
	public void notifyPlates(int x);

	/**
	 * 
	 * @param s
	 */
	public void StopMoving(boolean s);

	/**
	 * 
	 * @param x
	 */
	public void setLimit(int x);

	/**
	 * 
	 * @return
	 */
	public int getLimit();

	/**
	 * 
	 * @return
	 */
	public StackState getFullstackState();

	/**
	 * 
	 * @return
	 */
	public StackState getUnfullstackState();

	/**
	 * 
	 * @param state
	 */
	public void setState(StackState state);

	/**
	 * 
	 * @return
	 */
	public ArrayList<ImageObject> checkStack();

	public StackState getEmptyState();
	public Stack DeepClone(); 
}
