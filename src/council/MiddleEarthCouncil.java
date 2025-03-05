package council;
import cms.CharacterManager;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	private static CharacterManager characterManager;
	
	private MiddleEarthCouncil() {
		characterManager = new CharacterManager();
	}
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	public static CharacterManager getCharacterManager() {
		return characterManager;
	}
}
