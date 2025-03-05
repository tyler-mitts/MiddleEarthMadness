package character;

public class Human extends MiddleEarthCharacter {

	public Human(String name, Double health, Double power) {
		super(name, health, power);
	}

	@Override
	public String getRace() {
		return "Human";
	}

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
