package MiddleEarthApp;

import character.MiddleEarthCharacter;
import character.Elf;
import character.Orc;
import council.MiddleEarthCouncil;
import cms.CharacterManager;

public class Main {

	public static void main(String[] args) {
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		System.out.println(council);
		System.out.println(MiddleEarthCouncil.getInstance());
		CharacterManager cms = council.getCharacterManager();
		
		cms.displayAllCharacters();
		
		Elf George = new Elf("George",100.0,25.0);
		Orc Bob = new Orc("Bob",150.0,30.0);
		
		cms.addCharacter(George);
		cms.displayAllCharacters();
		cms.addCharacter(Bob);
		cms.displayAllCharacters();
		System.out.println(cms.updateCharacter(Bob, "Bob", 150, 45));
		System.out.println(cms.updateCharacter(Bob, "Bob", 150, 45));
		cms.getCharacter("George").attack(cms.getCharacter("Bob"));
		cms.displayAllCharacters();
		cms.deleteCharacter(George);
		cms.displayAllCharacters();
	}

}
	