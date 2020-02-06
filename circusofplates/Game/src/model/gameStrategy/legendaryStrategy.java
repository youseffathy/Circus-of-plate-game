package model.gameStrategy;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import model.clownBuilder.ClownEngineer;
import model.gameObjects.Clown;
import model.gameObjects.shapes.plate.PlateFactory;
import model.gameWorld.GameWorld;

public class legendaryStrategy implements GameStrategyIF {

	@Override
	public void setGamePlay(PlateFactory factory, List<GameObject> control, List<GameObject> moving, Clown clown,
			int width, int height, GameWorld gameWorld) {
		gameWorld.setControlSpeed(30);
		gameWorld.setSpeed(6);
		factory = PlateFactory.getInstance(9);
		ClownEngineer clownEnginner = new ClownEngineer(100, 480, 14, 14);
		clownEnginner.makeClown();
		clown = clownEnginner.getClown();
		control.add(clown);
		gameWorld.setClowns(clown);
		gameWorld.setPlatesFactory(factory);
		for (int i = 0; i < 12; i++) {

			moving.add(factory.getPlate(width, height));

		}

		
	}

}
