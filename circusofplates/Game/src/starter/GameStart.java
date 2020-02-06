package starter;


import controller.Controller;
import view.MainMenu;


public class GameStart {
	private static 	MainMenu mainMenu;
	private static Controller controller;
	public static void main(String[] args) {
		mainMenu = new MainMenu();
		controller = new Controller(mainMenu);
		mainMenu.setVisible(true);
	
	}


}
