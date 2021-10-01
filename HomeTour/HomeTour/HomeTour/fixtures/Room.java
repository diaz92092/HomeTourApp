package fixtures;


public class Room extends Fixture {
	
	/* the rooms adjacent to this one. 
	 * You might decide that a room in a particular direction 
	 * always uses a certain index, e.g. a north exit always goes in index 0,
	 * an east exit always goes in index 1, etc. If so, then the size of this 
	 * array depends on how many directions you want to support.
	 */
	private Room[] exits = new Room[4];
	
	/* 
	 * This array is a collection of the items we will 
	 * have in the room.
	 */
	private Fixture[] items;
	
	public Room(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
	}
	
	public Room [] getExits() {
		return this.exits;
	}
	
	/*
	 * This method is used to gain access to the specific exit from the room object
	 */
	public Room getExit(String direction) {
		int index = 0;
		direction = direction.toUpperCase();
		switch (direction) {
		case "NORTH":
		case "N":
			index = 0;
			break;
		case "EAST":
		case "E":
			index = 1;
			break;
		case "SOUTH":
		case "S":
			index = 2;
			break;
		case "WEST":
		case "W":
			index = 3;
			break;
		}
		// If statement checks if room exists in corresponding direction
		if (index >= this.exits.length || this.exits[index] == null) {
			System.out.println("There is no room in that direction");
			// Return the current room if no room in that direction
			return this;
		}
		return this.exits[index];
	}
	
	// Exits setter method
	public void setExits(Room...exits) {
		this.exits = exits;
	}
	
	// Overloaded setter method. Helps to set single exit based on index of the array
	public void setExits(Room exit, int index) {
		this.exits[index] = exit;
	}
	
	// Fixtures getter method
	public Fixture[] getItems() {
		return items;
	}
	
	// Fixtures setter method 
	public void setItems(Fixture... items) {
		this.items = items;
	}
	
}
