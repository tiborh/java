/**
 * This code allows you to represent an ally that fights against ghosts.
 */
 public class GhostBuster extends Ally
 {
    public GhostBuster(String name, String description)
    {
		super(name, description, Character.CHAINS);
		footprint = 'G';
	}

	private void secretSkillAgainstGhosts()
	{
		System.out.println("This is my secret skill against Ghosts");		
	}
}
