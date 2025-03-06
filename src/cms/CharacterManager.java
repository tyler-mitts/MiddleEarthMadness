package cms;
import java.util.Arrays;

import character.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	/**
	 * Constructs a new CharacterManager with an initial capacity of 1
	 */
	public CharacterManager() {
		characters = new MiddleEarthCharacter[1];
		size = 0;
	}
	
	/**
	 * Adds a character to the manager
	 * Automatically expands the array if needed
	 * 
	 * @param c The character to add
	 * @return true if the character was successfully added
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		if(size == characters.length) {
			characters = Arrays.copyOf(characters, characters.length * 2);
		}
		characters[size++] = c;
		return true;
	}
	
	/**
	 * Retrieves a character by name
	 * 
	 * @param name The name of the character to find
	 * @return The character if found, null otherwise
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < size; i++) {
			if(characters[i].getName().equals(name)) {
				//Character found
				return characters[i];
			}
		}
		// Character not found
		return null;
	}
	
	/**
	 * Gets the current number of characters in the manager
	 * 
	 * @return The number of characters
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Updates a character's attributes
	 * 
	 * @param character The character to update
	 * @param name The new name for the character
	 * @param health The new health value for the character
	 * @param power The new power value for the character
	 * @return true if the character was found and updated, false otherwise or if no actual changes were made
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		for(int i = 0; i < size; i++) {
			if(characters[i] == character) {
				//Character found
				if (!name.equals(characters[i].getName()) || health != characters[i].getHealth() || power != characters[i].getPower()) {
					characters[i].setName(name);
					characters[i].setHealth((double)health);
					characters[i].setPower((double)power);
					return true;
				}
				else 
					return false;
			}
		}
		//Character not found
		return false;
	}
	
	/**
	 * Removes a character from the manager
	 * 
	 * @param character The character to delete
	 * @return true if the character was found and deleted, false if not found
	 */
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
	
	/**
	 * Displays information about all characters currently in the manager
	 * Prints a message if no characters are found
	 */
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
