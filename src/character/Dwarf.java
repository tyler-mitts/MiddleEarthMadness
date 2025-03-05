package character;

public class Dwarf extends MiddleEarthCharacter {

	public Dwarf(String name, Double health, Double power) {
		super(name, health, power);
	}

	//Returns the name of the race of this subclass
	@Override
	public String getRace() {
		return "Dwarf";
	}
	
	//Decides if and how much to attack based on the target's race
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
