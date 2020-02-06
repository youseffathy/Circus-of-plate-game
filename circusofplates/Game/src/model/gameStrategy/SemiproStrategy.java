package model.gameStrategy;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import model.clownBuilder.ClownEngineer;
import model.gameObjects.Clown;
import model.gameObjects.shapes.plate.PlateFactory;
import model.gameWorld.GameWorld;

public class SemiproStrategy implements GameStrategyIF{
	
	@Override
	public void setGamePlay(PlateFactory factory, List<GameObject> control, List<GameObject> moving , Clown clown , int width , int height,GameWorld gameWorld) {
		gameWorld.setControlSpeed(35);
		gameWorld.setSpeed(8);
		factory = PlateFactory.getInstance(6);
		ClownEngineer clownEnginner = new ClownEngineer(100, 480, 20,20);
		clownEnginner.makeClown();
		clown = clownEnginner.getClown();
		control.add(clown);
		gameWorld.setClowns(clown);
		gameWorld.setPlatesFactory(factory);
		for (int i = 0; i < 8; i++) {

			moving.add(factory.getPlate(width, height));

		}
		
	}

}
