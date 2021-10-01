package game;

import fixtures.*;

public class Main {
	
    private static RoomManager roomManager = new RoomManager(4);
    
    private static boolean running = true;
 	
    
    
    
    // Main method
    public static void main(String[] args) {
    	// Run init method to instantiate
    	roomManager.init();
		
		//Player instantiated
    	Player player = new Player();
    
    	System.out.println("Welcome to HomeTour! This is an interactive tour of a house."
    			+ "\nYou will be presented with a description of a place, and you will have to type in a commands to do things. "
				+ "\nType quit to end the game.");

    	
    	// Player starts in starting room
    	player.setCurrentRoom(roomManager.getStartingRoom());
    	//Input.collectInput();
    	
    	while (running) {
    		Input.printRoom(player);
    		String[] input = Input.collectInput();
    		Input.parse(input, player);
    	}
    	
    	if(running = false) {
    		System.out.println("Game Over");
    	}
	}
 
	public static void movePlayer(String details, Player player) {
    	
    	System.out.println("You attempted to move: " + details);
    	
    	// getExit from Room to find an exit in a direction
    	Room move = player.getCurrentRoom().getExit(details);
    	player.setCurrentRoom(move);
    }
    
    
    public static void printRoomExits(Player player) {
    	System.out.println("\nAdjacent Rooms:");
    	// exits connected to the current room
    	Room[] connected = player.getCurrentRoom().getExits();
    	
    	for (int i = 0; i < connected.length; i++) {
    		if (connected[i] != null) {
    			switch (i)  {
    			case 0:
    				System.out.print("\tGo North: ");
    				break;
    			case 1:
    				System.out.print("\tGo East: ");
    				break;
    			case 2:
    				System.out.print("\tGo South: ");
    				break;
    			case 3:
    				System.out.print("\tGo West: ");
    			}
    			System.out.println(connected[i].getName());
    		}
    	}
    }
	
    
    public static void printObjects(Room room) {
    	// exits connected to the current room
    	Fixture[] items = room.getItems();
    	
    	if (items != null && items.length>0) {
    		System.out.println("Items: ");
    		for (Fixture i : items) {
    			System.out.println("\t"+i.getName());
    		}
    	}
    }
    
    
    

    public static void endGame() {
    	running = false;
    }
}

