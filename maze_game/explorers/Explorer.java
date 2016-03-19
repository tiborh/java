package explorers;
import terrains.Maze;

public interface Explorer
{
    public void explore(Maze mazeToExplore);
    public char getFootprint();
}
