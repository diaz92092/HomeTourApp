package fixtures;

//This abstract class will be used as a base for anything that can be looked at or interacted with.
public abstract class Fixture {
	
	/*
	 * The name, short, and long descriptions
	 * are protected to provide access within
	 * implementing classes, no matter what
	 * package they are declared in.
	 */
	
	// a short name or title for the fixture
	protected String name;
	
	// a one-sentence-long description of a fixture, used to briefly mention the fixture
	protected String shortDesc;
	
	// a paragraph-long description of the thing, displayed when the player investigates the fixture thoroughly (looks at it, or enters a room)
	protected String longDesc;
	
	// parameterized constructor
	public Fixture(String name, String shortDesc, String longDesc) {
		
		/* if a class is inheriting the properties of another class, 
		 * the subclass automatically acquires the default constructor of the superclass. 
		 * But if you want to call a parameterized constructor of the superclass,
		 * you need to use the super key word. 
		 */
		super();
		this.name = name;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public String getShortDesc() {
		return shortDesc;
	}
	
	public String getLongDesc() {
		return longDesc;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
		
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
		
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	
	/*
	 * The default toString() method in Object would print the hash code. 
	 * We can override toString() method in our class to print proper output.
	 */
	@Override
	public String toString() {
		return "Fixture (name=" + name + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc + ")";
	}
}




