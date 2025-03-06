package MiddleEarthApp;

import council.MiddleEarthCouncil;
import cms.CharacterManager;
import menu.MiddleEarthMenu;

public class Main {

	/**
	 * The main entry point for the Middle Earth Madness application
	 * Initializes the council, character manager, and menu system
	 * 
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager cms = council.getCharacterManager();
		
		MiddleEarthMenu menu = new MiddleEarthMenu(cms);
		menu.run();
	}

}
	