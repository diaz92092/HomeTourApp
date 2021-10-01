package fixtures;


public class Sink extends Fixture implements Interactable {

    public Sink(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
    }
    public void interact() {
        System.out.println("You washed your hands!");
    }
}

