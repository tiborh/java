package explorers.characters.enemies;
import explorers.characters.Character;

/**
 * This code allows you to represent a generic vampire to be used in a simple game.
 */ 
public class Vampire extends Enemy 
{
    public Vampire(String name, String description)
    {
		super(name, description, Character.TEETH); 
		footprint = 'v';
	}
}
