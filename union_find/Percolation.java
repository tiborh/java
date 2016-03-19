/**
 * percolation exercise from
 * http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 * 
 * @author by tibor
 * @version 0.01
 */
public class Percolation implements Percolate
{
    private char[][] grid;
    private final int grid_size;
    private final char BLOCKED = 'B';
    private final char OPEN = 'O';
    private final char FULL = 'F';
    /** create 8-by-8 grid, with all sites blocked
     * 
     */
    public Percolation()
    {
        this(8);
    }
    
    /** create N-by-N grid, with all sites blocked
     * 
     * @param N size of the grid
     */
    public Percolation(int N)
    {
        if (N <= 0)
            throw new IllegalArgumentException();
        else
        {
            grid = new char[N][N];
            grid_size = N;
            fill_grid(BLOCKED);
        }   
    }

    private void fill_grid(char filler)
    {
        if (grid == null)
            constants.logger.severe("Grid is undefined.");
        else
        {
            for (int i = 0; i < grid_size; i++)
                for (int j = 0; j < grid_size; j ++)
                    grid[i][j] = filler;
        }
    }

    /**
     * Prints the grid to stdout
     */
    public void printGrid()
    {
        if (grid == null)
            System.out.println("null: <empty grid>");
        else
        {
            for (int i = 0; i < grid_size; i++)
            {
                for (int j = 0; j < grid_size; j ++)
                    System.out.print(grid[i][j] + "|");
                System.out.println();
            }
        }
    }
    
    /**
     * returns the size of the grid
     * 
     * @return the size of the grid as an integer
     */
    public int getGridSize()
    {
        return grid_size;
    }
    
    /**
     * open site (row i, column j) if it is not already
     * 
     * @param i the row to open
     * @param j the column to open
     */
    public void open(int i, int j)
    {
        i--;
        j--;
        if (i < 0 || j < 0 || i > grid_size || j > grid_size)
            throw new IndexOutOfBoundsException();

            if (!isOpen(i+1,j+1))
            grid[i][j] = OPEN;
        else
            constants.logger.info("Grid is (" + i + "," + j + ") already open.");
    }
    
    /**
     * is site (row i, column j) open?
     * 
     * @param i the row to open
     * @param j the column to open
     * 
     * @return true if open, false if not 
     */
    public boolean isOpen(int i, int j)
    { 
        i--;
        j--;
        if (i < 0 || j < 0 || i > grid_size || j > grid_size)
            throw new IndexOutOfBoundsException();

        if (grid[i][j] == BLOCKED)
            return false;
        else
            return true;
    }
    
    /**
     * is site (row i, column j) full?
     * 
     * @param i the row to open
     * @param j the column to open
     * 
     * @return true if full, false if not
     */
    public boolean isFull(int i, int j)
    {
        i--;
        j--;
        if (i < 0 || j < 0 || i > grid_size || j > grid_size)
            throw new IndexOutOfBoundsException();

        if (grid[i][j] == FULL)
            return true;
        else
            return false;
    }
        
    /**
     * does the system percolate?
     * 
     * @return true if it does, false if it does not
     */
    public boolean percolates()
    {
        return false;
    }
    
    public static void main (String[] args)
    {
        System.out.println("Creating a new grid:");
        Percolation a_grid = new Percolation();
        a_grid.printGrid();
        System.out.println("Opening a diagonal line:");
        for (int i = 0; i < a_grid.getGridSize(); i++)
            a_grid.open(i+1,i+1);
        a_grid.printGrid();
        System.out.println("Trying to open an already open one:");
        a_grid.open(1,1);
        try
        {
            a_grid.open(-1,0);
        } catch (IndexOutOfBoundsException e)
        {
            System.out.println("Caught exception: IndexOutOfBoundsException");
            e.printStackTrace();
        }
        
    }
}
