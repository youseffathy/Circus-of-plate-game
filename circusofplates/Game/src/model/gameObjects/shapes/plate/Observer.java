package model.gameObjects.shapes.plate;

public interface Observer {
	public void updateCoordinates(int x) ;
	public void setattached(boolean s) ;
	void setStopMoving(boolean s);
}
