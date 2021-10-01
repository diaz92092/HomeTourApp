package fixtures;

public class Remote extends Fixture implements Hidable {
	
	public Remote(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);

	}

	public void hide() {
		System.out.println("You hid the remote! How are you going to turn the T.V. on now?");
	}
}
