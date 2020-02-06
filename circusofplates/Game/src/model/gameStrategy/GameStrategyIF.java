package model.gameStrategy;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import model.gameObjects.Clown;
import model.gameObjects.shapes.plate.PlateFactory;
import model.gameWorld.GameWorld;

public interface GameStrategyIF {

	public void setGamePlay(PlateFactory factory, List<GameObject> control, List<GameObject> moving, Clown clown,
			int width, int height, GameWorld gameWorld);
}
