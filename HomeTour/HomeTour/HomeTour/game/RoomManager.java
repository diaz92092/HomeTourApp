package game;

import fixtures.*;

public class RoomManager {
	private Room startingRoom;
	
	private Room[] rooms;
	
	public RoomManager(int roomCount) {
		super();
		rooms = new Room[6];
	}
	
	public void init() {
		Room room1 = new Room(
				"Living Room",
				"An inviting living room",
				"You enter a large living area. There is a Chabudai, a table with short legs "
				+ "\nmade for using while sitting on the floor. Strangely there is a T.V. atop of this table along with a remote."
				+ "\n"
				+ "\nTo hide the remote "
				+ "\ntype: hide remote"
				+ "\n");
		this.rooms[0] = room1;
		
		Room room2 = new Room(
				"Kitchen",
				"A modern kitchen",
				"You notice cupboards and shelving on both sides. A small sink and an oven. The kitchen is a simple room with marble top counters on the west wall and a sink and drainboard on the east side of the room. The walls are finished with polished hardwood. (interact oven)");
		this.rooms[1] = room2;
		
		Room room3 = new Room(
				"Master Bedroom",
				"A dimmly-lighted room with very minimal furniture used. "
				+"Simple yet sophisticated.",
				"The south wall of the master beddrom is a large sun facing window.\nA sliding glass door leads to glass panel balcony. Window coverings incude custom real wood blinds that reduce the sun's glare and provide privacy while preserving the view. (roll dice)");
		this.rooms[2] = room3;
		
		Room room4 = new Room(
				"Hallway",
				"A well lit hallway",
				"The interior of this house is focused around a central hallway \nserving as the main avenue of foot traffic and the entrance area to the adjacent rooms.\nThe hallway flows into a large, wide staircase that provides the main departure\nfrom the entertainment area of the house to the bed rooms. (interact light)");
		this.rooms[3] = room4;
		Room room5 = new Room(
				"Bathroom",
				"A tidy bathroom",
				"The sink has a marble finish. This bath room is very clean, and smells of lavender potpourri.\nThere is also an amazing wide ceiling LED volume control \ncomplete shower system with a thermostatic valve. (interact sink)"
				+ " ");
		this.rooms[4] = room5;
		Room room6 = new Room(
				"Bedroom",
				"A Zen like bedroom with tatami floor",
				"This bedroom looks very welcoming, and so comfortable.\nThat has a lot to do with the natural colors used as well as the presence of the wooden ceiling beams and the contours of the ceiling.\nThere is a California king bed with plenty of pillows on it. (interact bed)");
		this.rooms[5] = room6;
			
		this.startingRoom = room1;
		
		
//		room1.setExits(room2, 1);
//		room1.setExits(room4, 3);
//		
//		room2.setExits(room1, 0);
//	
//		room3.setExits(room4, 3);
//	
//		room4.setExits(room1, 0);
//		room4.setExits(room5, 4);
//		room4.setExits(room6, 5);
//		room4.setExits(room3, 2);
//		
//		room5.setExits(room4, 3);
//		
//		room6.setExits(room4, 3);
		
		//setting exits to each room
				// 0 - North, 1 - East, 2 - South, 3 - West
				getRooms(0).setExits(getRooms(1), 0);
				getRooms(0).setExits(getRooms(3), 1);
				getRooms(1).setExits(null, null, getRooms(0), null);
				getRooms(2).setExits(getRooms(3), null, null, null);
				getRooms(3).setExits(getRooms(4), getRooms(5), getRooms(2), getRooms(0));
				getRooms(4).setExits(null, null, getRooms(3), null);
				getRooms(5).setExits(null, null, null, getRooms(3));

	

		
		// setItems declares varargs parameter for Fixtures objects
		
		room1.setItems(new Remote("Remote", "A Remote For The T.V.", "You probably shouldn't hide it."));
		room2.setItems(new Oven("Oven", "A Stainless Steel Fridge", "This oven looks new. From baking cakes to roasting chicken, this oveen can do it all!"));
		room3.setItems(new Dice("Dice", "A Pair Of Dice", "Are you feeling lucky."));
		room4.setItems(new Light("Light", "A Smart Light Switch", "You can turn off the lights."));
		room5.setItems(new Sink("Sink", "A Modern Sink", "Now may be a good time to wash your hands!"));
		room6.setItems(new Bed("Bed", "A King Sixed Bed", "This bed feels comfortable... Too comfortable."));
		
		
	}
	
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	
	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}
	
	public Room getRooms(int Room) {
		return rooms[Room];
	}
	
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

}
