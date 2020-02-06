package model.memento;

import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import model.clownBuilder.ClownEngineer;
import model.clownBuilder.stack.Stack;
import model.clownBuilder.stack.StackIF;
import model.clownBuilder.stack.Iterator.Iterator;
import model.gameObjects.Clown;
import model.gameObjects.shapes.ImageObject;

// Memento Design Pattern

public class Originator {
	private Iterator iterator;
	private int score;
	private List<GameObject> constant;
	private List<GameObject> moving;
	private List<GameObject> control;
	private Clown clown;
	private long Timpaused;
	private long TimePlayed;
	public void set(int score, List<GameObject> moving, List<GameObject> control, List<GameObject> constant,
			Clown clown , long Timpaused , long TimePlayed) {
		this.moving = moving;
		this.control = control;
		this.score = score;
		this.constant = constant;
		this.clown = clown;
		this.Timpaused = Timpaused;
		this.TimePlayed = TimePlayed;
	}

	public Memento storeInMemento() {
		List<GameObject> controlMemento = new LinkedList<GameObject>();
		// clown memento
		ClownEngineer clownEnginner = new ClownEngineer(clown.getX(), clown.getY(), clown.getLeftStack().getCapacity(),
				clown.getLeftStack().getCapacity());
		Stack left = clown.getLeftStack().DeepClone();
		Stack right = clown.getRightStack().DeepClone();
		clownEnginner.makeClown();
		Clown newClown = clownEnginner.getClown();
		newClown.SetLeftStack(left);
		newClown.setRightStack(right);
		controlMemento.add(newClown);
		// controlled plates

		for (iterator = left.getIterator(); iterator.hasNext();) {
			ImageObject plate = (ImageObject) iterator.next();
			controlMemento.add(plate);
		}

		for (iterator = right.getIterator(); iterator.hasNext();) {
			ImageObject plate = (ImageObject) iterator.next();
			controlMemento.add(plate);
		}
		// constant objects
		List<GameObject> constantMemento = new LinkedList<GameObject>();
		for (GameObject gameObject : constant) {
			constantMemento.add(((ImageObject)gameObject).deepClone());
		}
		// moving plates

		List<GameObject> movingMemento = new LinkedList<GameObject>();
		for (GameObject plate : moving) {
	
			movingMemento.add(((ImageObject)plate).deepClone());
		}
		return new Memento(score, movingMemento, controlMemento, constantMemento,Timpaused , TimePlayed);
	}

	public void RestoreFromMemento(Memento memento) {
		this.moving = memento.getMoving();
		this.control = memento.getControl();
		this.score = memento.getScore();
		this.constant = memento.getConstant();
		this.TimePlayed =  memento.getTimePlayed();
		this.Timpaused = memento.getTimpaused();
		for (GameObject clown : control) {
			if (clown instanceof Clown) {
				this.clown = (Clown) clown;
			}
		}
	}
}