package character;

public class Human extends MiddleEarthCharacter {

	public Human(String name, Double health, Double power) {
		super(name, health, power);
	}

	//Returns the name of the race of this subclass
	@Override
	public String getRace() {
		return "Human";
	}
	
	//Decides if and how much to attack based on the target's race
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
