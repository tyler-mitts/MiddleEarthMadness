package menu;

import java.util.Scanner;
import cms.CharacterManager;
import character.*;

public class MiddleEarthMenu {
	private Scanner scanner;
	private CharacterManager characterManager;
	
	/**
	 * Constructs a new MiddleEarthMenu with the specified character manager
	 * 
	 * @param characterManager The character manager to use for this menu
	 */
	public MiddleEarthMenu(CharacterManager characterManager) {
		this.scanner = new Scanner(System.in);
		this.characterManager = characterManager;
	}

	/**
	 * Displays the main menu options to the user
	 */
	public void displayMainMenu() {
		System.out.println("\n===== MIDDLE-EARTH CHARACTER MANAGEMENT SYSTEM =====");
        System.out.println("1. Add a new character");
        System.out.println("2. View all characters");
        System.out.println("3. Update a character");
        System.out.println("4. Delete a character");
        System.out.println("5. Execute all characters' attack actions");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
	}
	
	/**
	 * Runs the main menu loop
	 * Displays the menu, gets user input, and executes the selected option
	 * until the user chooses to exit
	 */
	public void run() {
        boolean running = true;
        
        while (running) {
            displayMainMenu();
            int choice = getUserChoice(1, 6);
            
            switch (choice) {
                case 1:
                    addCharacterMenu();
                    break;
                case 2:
                    viewAllCharactersMenu();
                    break;
                case 3:
                    updateCharacterMenu();
                    break;
                case 4:
                    deleteCharacterMenu();
                    break;
                case 5:
                    executeAttacksMenu();
                    break;
                case 6:
                    System.out.println("Exiting the system. Farewell!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
	
	/**
	 * Gets and validates user input for menu choices
	 * 
	 * @param min The minimum valid choice
	 * @param max The maximum valid choice
	 * @return The validated user choice
	 */
	private int getUserChoice(int min, int max) {
        int choice = -1;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                
                if (choice >= min && choice <= max) {
                    validInput = true;
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        
        return choice;
    }

	/**
	 * Displays the menu for adding a new character
	 * Gets user input for character details and creates the character
	 */
	private void addCharacterMenu() {
        System.out.println("\n----- Add a New Character -----");
        System.out.println("Select character race:");
        System.out.println("1. Elf");
        System.out.println("2. Dwarf");
        System.out.println("3. Human");
        System.out.println("4. Orc");
        System.out.println("5. Wizard");
        System.out.print("Enter your choice (1-5): ");
        
        int raceChoice = getUserChoice(1, 5);
        
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter character health: ");
        double health = scanner.nextDouble();
        
        System.out.print("Enter character power: ");
        double power = scanner.nextDouble();
        scanner.nextLine();
        
        MiddleEarthCharacter newCharacter = null;
        
        switch (raceChoice) {
            case 1:
                newCharacter = new Elf(name, health, power);
                break;
            case 2:
                newCharacter = new Dwarf(name, health, power);
                break;
            case 3:
                newCharacter = new Human(name, health, power);
                break;
            case 4:
                newCharacter = new Orc(name, health, power);
                break;
            case 5:
                newCharacter = new Wizard(name, health, power);
                break;
        }
        
        if (characterManager.addCharacter(newCharacter)) {
            System.out.println("Character added successfully!");
        } else {
            System.out.println("Failed to add character.");
        }
    }

	/**
	 * Displays all characters in the character manager
	 */
	private void viewAllCharactersMenu() {
        System.out.println("\n----- All Characters -----");
        characterManager.displayAllCharacters();
    }
	
	/**
	 * Displays the menu for updating an existing character
	 * Gets user input for new character details and updates the character
	 */
	private void updateCharacterMenu() {
        System.out.println("\n----- Update a Character -----");
        System.out.print("Enter the name of the character to update: ");
        String name = scanner.nextLine();
        
        MiddleEarthCharacter character = characterManager.getCharacter(name);
        
        if (character != null) {
            System.out.println("Current character details:");
            character.displayInfo();
            
            System.out.print("Enter new name (or press Enter to keep current): ");
            String newName = scanner.nextLine();
            if (newName.isEmpty()) {
                newName = character.getName();
            }
            
            System.out.print("Enter new health (or -1 to keep current): ");
            double newHealth = scanner.nextDouble();
            if (newHealth == -1) {
                newHealth = character.getHealth();
            }
            
            System.out.print("Enter new power (or -1 to keep current): ");
            double newPower = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer
            if (newPower == -1) {
                newPower = character.getPower();
            }
            
            if (characterManager.updateCharacter(character, newName, (int)newHealth, (int)newPower)) {
                System.out.println("Character updated successfully!");
            } else {
                System.out.println("No changes were made to the character.");
            }
        } else {
            System.out.println("Character not found.");
        }
    }
	
	/**
	 * Displays the menu for deleting a character
	 * Gets user input for which character to delete and confirms the deletion
	 */
	private void deleteCharacterMenu() {
		System.out.println("\n----- Delete a Character -----");
		System.out.println("Enter the name of the character to delete:");
		String name = scanner.nextLine();
		
		MiddleEarthCharacter character = characterManager.getCharacter(name);
        
        if (character != null) {
            System.out.println("Character to delete:");
            character.displayInfo();
            
            System.out.print("Are you sure you want to delete this character? (y/n): ");
            String confirm = scanner.nextLine().toLowerCase();
            
            if (confirm.equals("y")) {
                if (characterManager.deleteCharacter(character)) {
                    System.out.println("Character deleted successfully!");
                } else {
                    System.out.println("Failed to delete character.");
                }
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Character not found.");
        }

	}
	
	/**
	 * Displays the menu for executing attacks between characters
	 * Gets user input for attacker and target and executes the attack
	 */
	private void executeAttacksMenu() {
        System.out.println("\n----- Execute Attack Actions -----");
        
        if (characterManager.getSize() < 2) {
            System.out.println("Need at least 2 characters for a battle!");
            return;
        }
        
        System.out.println("Available characters:");
        characterManager.displayAllCharacters();
        
        System.out.print("Enter the name of the attacker: ");
        String attackerName = scanner.nextLine();
        
        System.out.print("Enter the name of the target: ");
        String targetName = scanner.nextLine();
        
        MiddleEarthCharacter attacker = characterManager.getCharacter(attackerName);
        MiddleEarthCharacter target = characterManager.getCharacter(targetName);
        
        if (attacker != null && target != null) {
            System.out.println("\n" + attacker.getName() + " (" + attacker.getRace() + ") attacks " + 
                              target.getName() + " (" + target.getRace() + ")!");
            
            boolean attackResult = attacker.attack(target);
            
            if (attackResult) {
                System.out.println("Attack was successful!");
                System.out.println(target.getName() + "'s health reduced to " + target.getHealth());
            } else {
                System.out.println("Attack was ineffective!");
            }
        } else {
            System.out.println("One or both characters not found.");
        }
    }
}
