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
		return true;
	}

	@Override
	public String getRace() {
		return "Elf";
	}

}
