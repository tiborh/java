
/**
 * to create characters
 * 
 * @author tibor
 * @version 0.01
 * @since 2015-06-05
 */
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Setting up the characters");
        Character john = new Character("John",
                "This character has a long long story, unworthy of retelling.",
                10,4);
        john.printInfo();
        john.setSecretWeapon(Character.CLEVERNESS); 
        john.printInfo();
        Character jack = new Character("Jack",
                "This character has no life.",
                10,7);
        jack.printInfo();
        
        /* 1st combat:
	       notes that cleverness beats spells and fight with his intelligence 
		   strengthens the character's health*/
		System.out.println("1st combat");
		john.fight(jack);
		System.out.println("Info after the 1st combat");
		john.printInfo();
		jack.printInfo();
		/* 2nd combat:
	       notes that the chains are less effective than cleverness and fight 
		   with them weakens the character's health */
		System.out.println("2nd combat");
		john.fight(jack);
		System.out.println("Info after the 2nd combat");
		john.printInfo();
		jack.printInfo();
    }
}
