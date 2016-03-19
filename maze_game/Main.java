import explorers.Explorer;
import explorers.vehicles.Car;
import explorers.characters.Character;
import explorers.characters.allies.*;
import explorers.characters.enemies.*;
import terrains.Maze;
/**
 * Main class of the Java program
 * This code allows to create different objects (characters and cars)
 * that explore and solve a Maze with different footprints.
 * @author: uc3m
 * @version: 1.0
 */
public class Main 
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
        Vampire vampireFred = new Vampire("Fred the vampire",
                "The most elegant enemy.");       
        WitchHunter witchHunterEve = new WitchHunter("Eve the witch hunter", 
                "Fight against witches");
        GhostBuster ghostBusterPeter = new GhostBuster("Peter the ghostbuster",
                "Fight against ghosts.");
        VampireHunter vampireHunterEddy = new VampireHunter("Eddy the vampire hunter",
                "Fight against vampires.");     

        int[][] maze =  
            {{0, 0, 1, 1, 1, 1, 1, 1},
                {2, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 3, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 0, 1, 1, 0, 0}}; 

        Maze sampleMaze = new Maze(maze);

        //polymorphism using superclasses 
        Character [] characters = {heroJohn, witchMary, ghostGeorge, vampireFred,
                witchHunterEve,ghostBusterPeter, vampireHunterEddy};
        for(int i=0; i<characters.length;i++)
            characters[i].printInfo();

        //polymorphism using interfaces    
        Car myFerrari = new Car("Ferrari");

        System.out.println("All exploring: hero +, witch w, ghost g, vampire v, witchHunter W, ghostbuster G, vampireHunter V, ferrari c");
        Explorer [] explorers = {heroJohn, witchMary, ghostGeorge, vampireFred,
                witchHunterEve,ghostBusterPeter, vampireHunterEddy, myFerrari};
        for(int i=0; i<explorers.length; i++)
            explorers[i].explore(sampleMaze);
    }
}
