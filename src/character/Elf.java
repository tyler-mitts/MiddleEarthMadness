package character;

public class Elf extends MiddleEarthCharacter  {

	public Elf(String name, Double health, Double power) {
		super(name, health, power);
	}

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

	@Override
	public String getRace() {
		return "Elf";
	}

}
