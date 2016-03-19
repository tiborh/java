public class Car implements Explorer
{
    private String name;

    public Car(String name)
    {
        this.name = name;
    }

    public char getFootprint()
    {
        return 'c';

    }

    public void explore(Maze mazeToExplore)
    {
        if (mazeToExplore.findPathFrom(1, 0))
            mazeToExplore.print(getFootprint());
        else
            System.out.println("no solution found");
    }
}