package explorers.characters.enemies;
import explorers.characters.Character;

/**
 * This code allows you to represent a generic witch to be used in a simple game.
 */
public class Witch extends Enemy
{
    public Witch(String name, String description)
    {
		super(name, description, Character.SPELL); 
		footprint = 'w';
	}	
}
