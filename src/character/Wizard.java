package character;

public class Wizard extends MiddleEarthCharacter {

	public Wizard(String name, Double health, Double power) {
		super(name, health, power);
	}

	@Override
	public String getRace() {
		return "Wizard";
	}

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
