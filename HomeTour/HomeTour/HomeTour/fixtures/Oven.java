package fixtures;

public class Oven extends Fixture implements Interactable {
	
	public Oven(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);

	}

	public void interact() {
		System.out.println("You opened the Oven... now close it!");
	}
}