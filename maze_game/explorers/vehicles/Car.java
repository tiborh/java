package explorers.vehicles;
import explorers.Explorer;
import terrains.Maze;
/**
 * This class model a simple Car
 * @author uc3m
 * @version 1.0
 */
public class Car implements Explorer
{
    /**
     * Variable to specify the name of the Car
     */
    private String name;

    /**
     * Construct a new car using the specified name
     * @param name The String to be used as the name of the car
     */
    public Car(String name)
    {
        this.name = name;
    }

    /**
     * Returns the footprint of the Car 
     * @return The footprint of the Car (a character 'c')
     */
    public char getFootprint()
    {
        return 'c';
    }

    /**
     * Explores the maze given as parameter
     * @param mazeToExplore The Maze being explored by the Car
     */
    public void explore(Maze mazeToExplore)
    {
        if (mazeToExplore.findPathFrom(1, 0))
            mazeToExplore.print(getFootprint());
        else
            System.out.println("no solution found");
    }
}
