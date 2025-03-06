package character;

public abstract class MiddleEarthCharacter {
	private String name;
	private Double health;
	private Double power;
	
	/**
	 * This is a constructor that creates a Character
	 * with a a given name, health, and power.
	 * @param name
	 * 					The name to give the character
	 * @param health
	 * 					The health to give the character
	 * @param power
	 * 					The attack power to give the character
	 */
	MiddleEarthCharacter(String name, Double health, Double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	/**
	 * Returns the race of the given character
	 * @return
	 * 					Race of character
	 */
	public abstract String getRace();
	
	/**
	 * Attacks a provided target
	 * @param target
	 * 					MiddleEarthCharacter to attack
	 * @return
	 * 					Returns true if attack damaged target,
	 * 					false if target is invalid or ineffective
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	
	
	/**
	 * Creates a string representation of the MiddleEarthCharacter
	 */
	@Override
	public String toString() {
		return "MiddleEarthCharacter [name=" + name + ", health=" + health + ", power=" + power + ", race=" + getRace() + "]";
	}
	
	/**
	 * Prints out the string representation of the character
	 */
	public void displayInfo() {
		System.out.println(toString());
	}
	
	/**
	 * Returns name of MiddleEarthCharacter
	 * @return
	 * 					name of MiddleEarthCharacter
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of MiddleEarthCharacter
	 * @param name
	 * 					
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the current health of the character
	 * @return The health value of the character
	 */
	public Double getHealth() {
		return health;
	}

	/**
	 * Sets the health of the character
	 * @param health The new health value to set
	 */
	public void setHealth(Double health) {
		this.health = health;
	}

	/**
	 * Returns the current power of the character
	 * @return The power value of the character
	 */
	public Double getPower() {
		return power;
	}

	/**
	 * Sets the power of the character
	 * @param power The new power value to set
	 */
	public void setPower(Double power) {
		this.power = power;
	}
}
