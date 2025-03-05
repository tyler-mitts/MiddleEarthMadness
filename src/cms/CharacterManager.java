package cms;
import java.util.Arrays;

import character.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	public CharacterManager(int capacity) {
		characters = new MiddleEarthCharacter[capacity];
		size = 0;
	}
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		if(size == characters.length) {
			//Logic for doubling array size
		}
		characters[size++] = c;
		return true;
	}
	
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < size; i++) {
			if(characters[i].getName() == name) {
				return characters[i];
			}
		}
		return null;
	}
}
