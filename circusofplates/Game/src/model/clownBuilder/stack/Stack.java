package model.clownBuilder.stack;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

import model.clownBuilder.stack.Iterator.Container;
import model.clownBuilder.stack.Iterator.Iterator;
import model.clownBuilder.stack.state.EmptyStack;
import model.clownBuilder.stack.state.FullStack;
import model.clownBuilder.stack.state.StackState;
import model.clownBuilder.stack.state.UnfullStack;
import model.gameObjects.shapes.ImageObject;
import model.gameObjects.shapes.plate.Shapesloader;

public class Stack implements StackIF, Container {

	private StackState fullstate;
	private StackState unfullstate;
	private StackState emptyState;
	private StackState currentstate;
	private int capacity;
	private ArrayList<ImageObject> plates;
	private int positionX;
	private int positionY;
	private int limit = 480 + 62;
	private int RelativeXtoClown; // 51-40 for left // 157-40 for the right

	public Stack(int x) {
		plates = new ArrayList<ImageObject>();
		RelativeXtoClown = x;
		fullstate = new FullStack(this);
		unfullstate = new UnfullStack(this);
		emptyState = new EmptyStack(this);
		currentstate = emptyState;
	}

	@Override
	public StackState getCurrentState() {
		return currentstate;
	}

	@Override
	public int getRelativeXtoClown() {
		return RelativeXtoClown;
	}

	@Override
	public StackState getEmptyState() {
		return emptyState;
	}

	@Override
	public StackState getFullstackState() {
		return fullstate;
	}

	@Override
	public StackState getUnfullstackState() {
		return unfullstate;
	}

	@Override
	public void setUnfullstackState(StackState state) {
		unfullstate = state;
	}

	@Override
	public void setfullstackState(StackState state) {
		fullstate = state;
	}

	@Override
	public void setEmptystackState(StackState state) {
		emptyState = state;
	}

	@Override
	public void setState(StackState state) {
		currentstate = state;
	}

	@Override
	public void setStack(ArrayList<ImageObject> plates) {
		this.plates = plates;
	}

	@Override
	public ArrayList<ImageObject> getStack() {
		// TODO Auto-generated method stub
		return plates;
	}

	@Override
	public boolean addPlate(ImageObject plate) {
		if (plates.size()+1 > 5) {
			setPositionY(getPositiony()-15);
			System.out.println();
		}
		if (plates.size() == capacity) {
			currentstate = fullstate;
		} else if (plates.size() < capacity) {
			currentstate = unfullstate;
		}
		return currentstate.AddPlate(plate);
	}

	@Override
	public boolean removePlate(ImageObject plate) {
		if (plates.size() > 5) {
			setPositionY(getPositiony()+15);
		}
		return currentstate.removePlate(plate);
	}

	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;

	}

	@Override
	public int getCapacity() {

		return capacity;
	}

	@Override
	public int getSize() {
		return plates.size();
	}

	@Override
	public int getPositionX() {
		return positionX;
	}

	@Override
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	@Override
	public int getPositiony() {
		return positionY;
	}

	@Override
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	@Override
	public void notifyPlates(int x) {
		for (int i = 0; i < plates.size(); i++) {
			plates.get(i).updateCoordinates(x + RelativeXtoClown);
		}
	}

	@Override
	public void StopMoving(boolean s) {
		for (int i = 0; i < plates.size(); i++) {
			plates.get(i).setStopMoving(s);
		}

	}

	@Override
	public int getLimit() {
		return limit;
	}

	@Override
	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public ArrayList<ImageObject> checkStack() {

		return currentstate.checkConsecutivePlate();
	}

	@Override
	public Stack DeepClone() {
		Stack s = new Stack(RelativeXtoClown);
		s.setCapacity(capacity);
		s.setPositionX(positionX);
		s.setPositionY(positionY);
		s.setLimit(limit);
		ArrayList<ImageObject> pList = new ArrayList<>();
		Map<String, Class<? extends ImageObject>> map = Shapesloader.getInstance().loadAllclasses();
		for (Iterator iterator = getIterator(); iterator.hasNext();) {
			ImageObject p = (ImageObject) iterator.next();
			ImageObject plateTemp;
			if (map.get("model.gameObjects.shapes.RegtanglePlateObject").isInstance(p)) {
				try {
					plateTemp = map.get("model.gameObjects.shapes.RegtanglePlateObject")
							.getConstructor(new Class[] { int.class, int.class, int.class, int.class, Color.class })
							.newInstance(p.getX(), p.getY(), p.getWidth(), p.getHeight(), p.getColor());
					plateTemp.setattached(true);
					plateTemp.setX(p.getX());
					pList.add(plateTemp);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {

				}
				
			} else if (map.get("model.gameObjects.shapes.ElipsePlateObject").isInstance(p)) {
				try {
					plateTemp = map.get("model.gameObjects.shapes.ElipsePlateObject")
							.getConstructor(new Class[] { int.class, int.class, int.class, int.class, Color.class })
							.newInstance(p.getX(), p.getY(), p.getWidth(), p.getHeight(), p.getColor());

					plateTemp.setattached(true);
					plateTemp.setX(p.getX());
					pList.add(plateTemp);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {

				}
			
			}
		}
		s.setStack(pList);
		s.setEmptystackState(new EmptyStack(s));
		s.setfullstackState(new FullStack(s));
		s.setUnfullstackState(new UnfullStack(s));
		if (currentstate instanceof EmptyStack) {
			s.setState(s.getEmptyState());
		} else if (currentstate instanceof FullStack) {
			s.setState(s.getFullstackState());
		} else if (currentstate instanceof UnfullStack) {
			s.setState(s.getUnfullstackState());
		}

		return s;
	}

	@Override
	public Iterator getIterator() {
		return new StackIterator(plates);
	}

	private class StackIterator implements Iterator {
		private ArrayList<ImageObject> list;
		private int index = 0;

		public StackIterator(ArrayList<ImageObject> list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			if (index < list.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (hasNext()) {
				return list.get(index++);
			}
			return null;
		}

	}
}
