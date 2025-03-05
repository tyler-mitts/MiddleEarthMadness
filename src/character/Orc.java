package character;

public class Orc extends MiddleEarthCharacter {

	public Orc(String name, Double health, Double power) {
		super(name, health, power);
	}

	@Override
	public String getRace() {
		return "Orc";
	}

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
