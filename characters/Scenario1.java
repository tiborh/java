/**
 * Main class of the Java program.
 * This code allows you to create different characters to be used in a simple
 * game. 
 */

 public class Scenario1 {
     
	public static void main(String[] args){
        System.out.println("Setting up the character");
	    Character heroJohn = new Character("John", "A clever boy of 16 years", 
	                                       10, Character.CLEVERNESS);
	    heroJohn.printInfo();
		Character enemyMary = new Character("Mary");
		enemyMary.printInfo();
	    /* 1st combat:
	       notes that cleverness beats spells and fight with his intelligence 
		   strengthens the character's health*/
		System.out.println("1st combat");
		heroJohn.fight(enemyMary);
		System.out.println("Info after the 1st combat");
		heroJohn.printInfo();
		enemyMary.printInfo();
		/* 2nd combat:
	       notes that the chains are less effective than cleverness and fight 
		   with them weakens the character's health */
		System.out.println("2nd combat");
		heroJohn.fight(enemyMary);
		System.out.println("Info after the 2nd combat");
		heroJohn.printInfo();
		enemyMary.printInfo();		
		/* 3rd combat: */
		System.out.println("3rd combat");
		heroJohn.fight(enemyMary);
		System.out.println("Info after the 3rd combat");
		heroJohn.printInfo();
		enemyMary.printInfo();
		
	}
}