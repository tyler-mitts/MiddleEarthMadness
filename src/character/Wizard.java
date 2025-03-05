package character;

public class Wizard extends MiddleEarthCharacter {

	public Wizard(String name, Double health, Double power) {
		super(name, health, power);
	}

	//Returns the name of the race of this subclass
	@Override
	public String getRace() {
		return "Wizard";
	}

	//Decides if and how much to attack based on the target's race
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
