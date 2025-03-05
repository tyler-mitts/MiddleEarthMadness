package character;

public class Orc extends MiddleEarthCharacter {

	public Orc(String name, Double health, Double power) {
		super(name, health, power);
	}

	//Returns the name of the race of this subclass
	@Override
	public String getRace() {
		return "Orc";
	}
	
	//Decides if and how much to attack based on the target's race
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
