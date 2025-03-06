package character;

public class Human extends MiddleEarthCharacter {

	/**
	 * Creates a new Human character
	 * @param name The name of the human
	 * @param health The initial health value of the human
	 * @param power The initial power value of the human
	 */
	public Human(String name, Double health, Double power) {
		super(name, health, power);
	}

	/**
	 * Returns the race of this character
	 * @return The string "Human"
	 */
	@Override
	public String getRace() {
		return "Human";
	}
	
	/**
	 * Attacks a target character based on race-specific rules
	 * Humans cannot attack other Humans or Orcs
	 * Humans deal 1.5x damage to Wizards
	 * Humans deal normal damage to other races
	 * 
	 * @param target The character to attack
	 * @return true if attack was successful, false if attack couldn't be performed
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Human" || target.getRace() == "Orc") {
			return false;
		}
		
		if(target.getRace() == "Wizard") {
			target.setHealth(target.getHealth() - (getPower() * 1.5));
			return true;
		}
		else {
			target.setHealth(target.getHealth() - getPower());
			return true;
		}
	}

}
