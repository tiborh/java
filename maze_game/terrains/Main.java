package terrains;

/**
 * Main class of the Java program.
 */
public class Main 
{
    public static void main(String[] args)
    {
        Maze mazeToExplore = new Maze();
        Maze aux = mazeToExplore.clone();

        if (aux.findPathFrom(1, 0)) 
        {
	        System.out.println("maze solved");
			aux.print();
			System.out.println("original maze");
			mazeToExplore.print();
			
		} else 
		{
		    System.out.println("no solution found");
		}
    }
}
