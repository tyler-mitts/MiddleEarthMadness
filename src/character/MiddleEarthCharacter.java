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
	
	//Creates abstract method for the race to be identified in the race classes
	public abstract String getRace();
	
	//Creates abstract method for attack so special conditions can be made it race classes
	public abstract boolean attack(MiddleEarthCharacter target);
	
	
	
	@Override
	public String toString() {
		return "MiddleEarthCharacter [name=" + name + ", health=" + health + ", power=" + power + ", race=" + getRace() + "]";
	}
	
	//Displays character info through toString method
	public void displayInfo() {
		System.out.println(toString());
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
