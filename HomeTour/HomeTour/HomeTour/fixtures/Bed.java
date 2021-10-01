package fixtures;

public class Bed extends Fixture implements Interactable {

	    public Bed(String name, String shortDesc, String longDesc) {
			super(name, shortDesc, longDesc);
	    }
	    public void interact() {
	        System.out.println("Your nap turned into a deep slumber..."
	        		+ "\n"
	        		+ "Good Morning!");
	    }
	}

