package game;

import java.util.Scanner;

import fixtures.*;

public class Input {
	// Prints the player's current location
	 
	public static void printRoom(Player player) {
		System.out.println("\nCURRENT ROOM\n");
		System.out.println(player.getCurrentRoom().getName());
		System.out.println(player.getCurrentRoom().getShortDesc());
		System.out.println(player.getCurrentRoom().getLongDesc());
		Main.printObjects(player.getCurrentRoom());
		Main.printRoomExits(player);
		
	}

	// gathers input as an array
	 
	@SuppressWarnings("resource")
	public static String[] collectInput() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		String[] phrase = input.split(" ");
		return phrase;
	}

	// parse input & perform actions
	 
	public static void parse(String[] command, Player player) {
		
		String action = command[0].toUpperCase().intern();
		
		String details = null;

		if (command.length > 1) {
			details = command[1].toUpperCase().intern();
		}

		if (action == "GO" | action == "MOVE") {
			if (details != null) {
				// player move
				movePlayer(details, player);
			} else {
				// If direction not entered
				System.out.println("Enter a direction");
			}
		} else if (action == "INTERACT") {
			if (details != null) {
				// try to interact with an object
				objectInteraction(details, player);
			} else {
				// If you do not enter an item name...
				System.out.println("Please enter item name");
			}
		} 
		else if (action == "HIDE") {
			if (details != null) {
				// try to interact with an object
				objectHiding(details, player);
			} else {
				// If you do not enter an item name...
				System.out.println("Please enter item name");
			}
		} 
		else if (action == "ROLL") {
			if (details != null) {
				// try to interact with an object
				objectRolling(details, player);
			} else {
				// If you do not enter an item name...
				System.out.println("Please enter item name");
			}
		}else if (action == "QUIT") {
			Main.endGame();
			System.out.println("Game Over!");
		}
	}

	
	public static void movePlayer(String details, Player player) {
		System.out.println("You are attempting to move: " + details);
		 // Find an exit in a direction
		
		Room move = player.getCurrentRoom().getExit(details);
		player.setCurrentRoom(move);
	}


	public static void objectInteraction(String details, Player player) {
		Fixture[] items = null;
		if ((items = player.getCurrentRoom().getItems()) != null) {
			for (Fixture i : items) {
				if (i.getName().equalsIgnoreCase(details) & (i instanceof Interactable)) {
					((Interactable) i).interact();
				} else {
					System.out.println("Item not found");
				}
			}
		} else {
			System.out.println("There are no interactable items");
		}
	}
	public static void objectHiding(String details, Player player) {
		Fixture[] items = null;
		if ((items = player.getCurrentRoom().getItems()) != null) {
			for (Fixture i : items) {
				if (i.getName().equalsIgnoreCase(details) & (i instanceof Hidable)) {
					((Hidable) i).hide();
				} else {
					System.out.println("Item not found");
				}
			}
		} else {
			System.out.println("There are no hidable items");
		}
	}
	public static void objectRolling(String details, Player player) {
		Fixture[] items = null;
		if ((items = player.getCurrentRoom().getItems()) != null) {
			for (Fixture i : items) {
				if (i.getName().equalsIgnoreCase(details) & (i instanceof Rollable)) {
					((Rollable) i).roll();
				} else {
					System.out.println("Item not found");
				}
			}
		} else {
			System.out.println("There are no rollable items");
		}
	}
}
