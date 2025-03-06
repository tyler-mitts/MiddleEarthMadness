package council;
import cms.CharacterManager;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	private static CharacterManager characterManager;
	
	/**
	 * Private constructor for singleton pattern
	 * Initializes the character manager
	 */
	private MiddleEarthCouncil() {
		characterManager = new CharacterManager();
	}
	
	/**
	 * Gets the singleton instance of the MiddleEarthCouncil
	 * Creates a new instance if one doesn't exist
	 * 
	 * @return The singleton instance of MiddleEarthCouncil
	 */
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	/**
	 * Gets the character manager associated with this council
	 * 
	 * @return The CharacterManager instance
	 */
	public CharacterManager getCharacterManager() {
		return characterManager;
	}
}
