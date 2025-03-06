package character;

public class Wizard extends MiddleEarthCharacter {

	/**
	 * Creates a new Wizard character
	 * @param name The name of the wizard
	 * @param health The initial health value of the wizard
	 * @param power The initial power value of the wizard
	 */
	public Wizard(String name, Double health, Double power) {
		super(name, health, power);
	}

	/**
	 * Returns the race of this character
	 * @return The string "Wizard"
	 */
	@Override
	public String getRace() {
		return "Wizard";
	}

	/**
	 * Attacks a target character based on race-specific rules
	 * Wizards cannot attack other Wizards or Humans
	 * Wizards deal 1.5x damage to Dwarves
	 * Wizards deal normal damage to other races
	 * 
	 * @param target The character to attack
	 * @return true if attack was successful, false if attack couldn't be performed
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Wizard" || target.getRace() == "Human") {
			return false;
		}
		
		if(target.getRace() == "Dwarf") {
			target.setHealth(target.getHealth() - (getPower() * 1.5));
			return true;
		}
		else {
			target.setHealth(target.getHealth() - getPower());
			return true;
		}
	}

}
