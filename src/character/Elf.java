package character;

public class Elf extends MiddleEarthCharacter  {

	public Elf(String name, Double health, Double power) {
		super(name, health, power);
	}

	//Decides if and how much to attack based on the target's race
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
	
	//Returns the name of the race of this subclass
	@Override
	public String getRace() {
		return "Elf";
	}

}
