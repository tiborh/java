package explorers.characters.enemies;
import explorers.characters.Character;

/**
 * This code allows you to represent a generic ghost to be used in a simple game.
 */
public class Ghost extends Enemy 
{
    public Ghost(String name, String description)
    {
		super(name, description, Character.CHAINS); 
		footprint = 'g';
	}	
}

