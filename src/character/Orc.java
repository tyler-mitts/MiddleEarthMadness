package character;

public class Orc extends MiddleEarthCharacter {

	/**
	 * Creates a new Orc character
	 * @param name The name of the orc
	 * @param health The initial health value of the orc
	 * @param power The initial power value of the orc
	 */
	public Orc(String name, Double health, Double power) {
		super(name, health, power);
	}

	/**
	 * Returns the race of this character
	 * @return The string "Orc"
	 */
	@Override
	public String getRace() {
		return "Orc";
	}
	
	/**
	 * Attacks a target character based on race-specific rules
	 * Orcs cannot attack other Orcs or Elves
	 * Orcs deal 1.5x damage to Humans
	 * Orcs deal normal damage to other races
	 * 
	 * @param target The character to attack
	 * @return true if attack was successful, false if attack couldn't be performed
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Orc" || target.getRace() == "Elf") {
			return false;
		}
		
		if(target.getRace() == "Human") {
			target.setHealth(target.getHealth() - (getPower() * 1.5));
			return true;
		}
		else {
			target.setHealth(target.getHealth() - getPower());
			return true;
		}
	}

}
