package character;

public class Dwarf extends MiddleEarthCharacter {

	/**
	 * Creates a new Dwarf character
	 * @param name The name of the dwarf
	 * @param health The initial health value of the dwarf
	 * @param power The initial power value of the dwarf
	 */
	public Dwarf(String name, Double health, Double power) {
		super(name, health, power);
	}

	/**
	 * Returns the race of this character
	 * @return The string "Dwarf"
	 */
	@Override
	public String getRace() {
		return "Dwarf";
	}
	
	/**
	 * Attacks a target character based on race-specific rules
	 * Dwarves cannot attack other Dwarves or Wizards
	 * Dwarves deal 1.5x damage to Elves
	 * Dwarves deal normal damage to other races
	 * 
	 * @param target The character to attack
	 * @return true if attack was successful, false if attack couldn't be performed
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Dwarf" || target.getRace() == "Wizard") {
			return false;
		}
		
		if(target.getRace() == "Elf") {
			target.setHealth(target.getHealth() - (getPower() * 1.5));
			return true;
		}
		else {
			target.setHealth(target.getHealth() - getPower());
			return true;
		}
	}

}
