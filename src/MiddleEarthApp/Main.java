package MiddleEarthApp;

import council.MiddleEarthCouncil;
import cms.CharacterManager;
import menu.MiddleEarthMenu;

public class Main {

	public static void main(String[] args) {
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager cms = council.getCharacterManager();
		
		MiddleEarthMenu menu = new MiddleEarthMenu(cms);
		menu.run();
	}

}
	