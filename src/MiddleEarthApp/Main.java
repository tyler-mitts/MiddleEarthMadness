package MiddleEarthApp;

import character.MiddleEarthCharacter;
import character.Elf;
import character.Orc;

public class Main {

	public static void main(String[] args) {
		Elf George = new Elf("George",100.0,25.0);
		Orc Bob = new Orc("Bob",150.0,30.0);
		
		Bob.displayInfo();
		George.attack(Bob);
		Bob.displayInfo();
		
	}

}
