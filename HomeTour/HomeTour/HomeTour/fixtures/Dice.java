package fixtures;

public class Dice extends Fixture implements Rollable {
	public Dice (String name, String shortDesc, String longDesc){
		super(name, shortDesc, longDesc);
	}
	
	public void roll() {
		while (true) {
		    int dice1=(int)(Math.random()*6+1);
		    int dice2=(int)(Math.random()*6+1);
		    int sum = dice1 + dice2;

		    System.out.println("Roll: total = " + sum); 

		    if (sum==2 || sum==3 || sum==12) {
		        System.out.println("You rolled a " + sum + " You LOSE :(");
		        break;
		    } else if(sum==7 || sum==11) { 
		        System.out.println("With a " + sum + " You WIN!!!!!!!");
		        break; 
		    }
		}
	}
}

	