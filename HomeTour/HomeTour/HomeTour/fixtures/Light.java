package fixtures;

public class Light extends Fixture implements Interactable {
	
	public Light(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);

	}
	boolean state = false;
	public void interact() {
		if(state) {
		System.out.println("The lights are on!");
		this.state = !this.state;
	}
		else {
			System.out.println("You turn off the lights. It's pretty dark now!");
			this.state = !this.state;
		}
}
}



