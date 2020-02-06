package model.gameStrategy;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import model.clownBuilder.ClownEngineer;
import model.gameObjects.Clown;
import model.gameObjects.shapes.plate.PlateFactory;
import model.gameWorld.GameWorld;

public class ProStrategy implements GameStrategyIF{

	@Override
	public void setGamePlay(PlateFactory factory, List<GameObject> control, List<GameObject> moving , Clown clown , int width , int height,GameWorld gameWorld) {
		gameWorld.setControlSpeed(35);
		gameWorld.setSpeed(7);
		factory = PlateFactory.getInstance(9);
		ClownEngineer clownEnginner = new ClownEngineer(100, 480, 17, 17);
		clownEnginner.makeClown();
		clown = clownEnginner.getClown();
		control.add(clown);
		gameWorld.setClowns(clown);
		gameWorld.setPlatesFactory(factory);
		for (int i = 0; i < 10; i++) {

			moving.add(factory.getPlate(width, height));

		}
		
		
	}
}
