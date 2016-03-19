/**
 * Main class of the Java program.
 * This code allows you to create different characters to be used in a simple
 * game. 
 */

public class Scenario2 
{     
    public static void main(String[] args)
    {
        Character heroJohn = new Character("John", 
                "A clever boy of 16 years. " +
                "\n" +
                "The hero of this story",
                Character.CLEVERNESS);
        Witch witchMary = new Witch("Mary the witch", 
                "An old and ugly woman.\n" +
                "A malevolent witch");
        Ghost ghostGeorge = new Ghost("George the ghost",
                "A white and silly ghost.");
        Vampire vampireVince = new Vampire("Vince the vampire",
                "A weakling vampire.");

        heroJohn.printInfo();
        witchMary.printInfo();
        witchMary.scare("I will be your worst nightmare");
        ghostGeorge.printInfo();
        vampireVince.printInfo();

        int counter = 0;
        while (heroJohn.isAlive() && (witchMary.isAlive() || ghostGeorge.isAlive() || vampireVince.isAlive()))
        {
            System.out.println("Combat " + ++counter);
            System.out.println("Info after combat " + counter);

            if (witchMary.isAlive())
            {
                heroJohn.fight(witchMary);
                witchMary.printInfo();
            }

            if (ghostGeorge.isAlive())
            {
                ghostGeorge.fight(witchMary);
                ghostGeorge.printInfo();
            }

            if (vampireVince.isAlive())
            {
                vampireVince.fight(witchMary);
                vampireVince.printInfo();
            }

            heroJohn.printInfo();
            if (counter == 15)
                break;
        }       

    }
}
