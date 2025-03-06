package character;

public class Elf extends MiddleEarthCharacter  {

	/**
	 * Creates a new Elf character
	 * @param name The name of the elf
	 * @param health The initial health value of the elf
	 * @param power The initial power value of the elf
	 */
	public Elf(String name, Double health, Double power) {
		super(name, health, power);
	}

	/**
	 * Attacks a target character based on race-specific rules
	 * Elves cannot attack other Elves or Dwarves
	 * Elves deal 1.5x damage to Orcs
	 * Elves deal normal damage to other races
	 * 
	 * @param target The character to attack
	 * @return true if attack was successful, false if attack couldn't be performed
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Elf" || target.getRace() == "Dwarf") {
			return false;
		}
		
		if(target.getRace() == "Orc") {
			target.setHealth(target.getHealth() - (getPower() * 1.5));
			return true;
		}
		else {
			target.setHealth(target.getHealth() - getPower());
			return true;
		}
		
	}
	
	/**
	 * Returns the race of this character
	 * @return The string "Elf"
	 */
	@Override
	public String getRace() {
		return "Elf";
	}

}
