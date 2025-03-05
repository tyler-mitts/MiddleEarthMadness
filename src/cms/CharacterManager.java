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
				//Character found
				return characters[i];
			}
		}
		// Character not found
		return null;
	}
	
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		for(int i = 0; i < size; i++) {
			if(characters[i] == character) {
				//Character found
				characters[i].setName(name);
				characters[i].setHealth(health);
				characters[i].setPower(power);
				return true;
			}
			//Character not found
			return false;
		}
	}
	
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		for(int i = 0; i < size; i++) {
			if(characters[i] == character) {
				//Character found
				for(int j = i; j < size - 1; j++) {
					characters[j] = characters[j + 1];
				}
				characters[size-1] = null;
				size--;
				return true;
			}
		}
		//Character not found
		return false;
	}
	
	public void displayAllCharacters() {
		if(size == 0) {
			System.out.println("No characters found");
			return;
		}
		for(int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
}
