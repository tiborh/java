/**
 * This code allows you to represent an ally that fights against Vampires.
 */
 public class VampireHunter extends Ally
 {
   	public VampireHunter(String name, String description)
   	{
		super(name, description,Character.TEETH);
		footprint = 'V';
	}
	
	private void secretSkillAgainstVampire()
	{
		System.out.println("This is my secret skill against Vampires");		
	}
}
