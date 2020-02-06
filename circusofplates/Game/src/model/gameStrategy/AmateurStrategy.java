package model.gameStrategy;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import model.clownBuilder.ClownEngineer;
import model.gameObjects.Clown;
import model.gameObjects.shapes.plate.PlateFactory;
import model.gameWorld.GameWorld;

public class AmateurStrategy implements GameStrategyIF {

	@Override
	public void setGamePlay(PlateFactory factory, List<GameObject> control, List<GameObject> moving, Clown clown,
			int width, int height, GameWorld gameWorld) {
		gameWorld.setControlSpeed(40);
		gameWorld.setSpeed(10);
		factory = PlateFactory.getInstance(3);
		ClownEngineer clownEnginner = new ClownEngineer(100, 480, 25, 25);
		clownEnginner.makeClown();
		clown = clownEnginner.getClown();
		control.add(clown);
		gameWorld.setClowns(clown);
		gameWorld.setPlatesFactory(factory);
		for (int i = 0; i < 6; i++) {

			moving.add(factory.getPlate(width, height));

		}

	}

}
