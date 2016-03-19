package explorers.characters.enemies;
import explorers.characters.Character;

/**
 * This code allows you to represent a generic enemy to be used in a simple game.
 */
public class Enemy extends Character
{
	public static final String DEFAULT_SCARY_MSG = "Do you want to know what the fear is?";
	
	public Enemy(String name, String description, int secretWeapon)
	{
		super(name, description,secretWeapon);
	}

	public void scare()
	{
		System.out.println(DEFAULT_SCARY_MSG);
	}
	
	public void scare (String otherScaryMessage)
	{
	    System.out.println(otherScaryMessage);
	}
}

