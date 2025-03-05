package character;

public abstract class MiddleEarthCharacter {
	private String name;
	private Double health;
	private Double power;
	
	//Initializes the info for the character
	MiddleEarthCharacter(String name, Double health, Double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	//Gets race via name of subclass
	public String getRace() {
		return getClass().getName();
	}
	
	//Creates abstract method for attack so special conditions can be made it race classes
	public abstract boolean attack(MiddleEarthCharacter target);
	
	
	
	@Override
	public String toString() {
		return "MiddleEarthCharacter [name=" + name + ", health=" + health + ", power=" + power + ", race=" + getRace() + "]";
	}
	
	//Displays character info through toString method
	void displayInfo() {
		toString();
	}
	
	//Getters and setters for character info
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getHealth() {
		return health;
	}

	public void setHealth(Double health) {
		this.health = health;
	}

	public Double getPower() {
		return power;
	}

	public void setPower(Double power) {
		this.power = power;
	}
}
