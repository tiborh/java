/**
 * Main class of the Java program.
 * This code allows you to test available positions
 * 
 */

public class maze {
    // 0 - obstacle
    // 1 - open space
    // 2 - path taken
    // 3 - goal 
    private static int[][] maze = 
        {{0, 0, 1, 1, 1, 1, 1, 1},
        {2, 0, 1, 0, 0, 0, 1, 1},
        {1, 0, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 1, 3, 1, 1},
        {0, 0, 1, 0, 1, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 0, 0},
        {1, 1, 1, 0, 1, 1, 0, 0}};

	// use symbols to make reading the output easier...
	// 0 - obstacle - '#'
	// 1 - open space - '.'
	// 2 - path taken - '+'
	// 3 - goal - '*'
	private static final char[] MAZE_SYMBOLS = {'#', '.', '+', '*' };        
        
    //Try to findPathFrom initial position if the maze is solved print the solution
	public static void main(String[] args) {
		if (findPathFrom(1, 0)) {
			print();
		} else {
			System.out.println("no solution found");
		}
	}
        
    //Testing available positions
    public static void test_maze(String[] args) {
        System.out.println("Che cking available positions...");
        for(int i = -1; i <= maze.length; ++i)
        {
            for(int j = -1; j <= maze[0].length; ++j)
                System.out.print(isAvailablePosition(i,j) ? "T" : "F");
            System.out.print("\n");
        }
        System.out.print("\n");
        for(int i = -1; i <= maze.length; ++i)
        {
            for(int j = -1; j <= maze[0].length; ++j)
                System.out.print(isUnAvailablePosition(i,j) ? "F" : "T");
            System.out.print("\n");
        }
    }
    

    private static boolean findPathFrom(int row, int col) {

		// when we reach the goal we have solved the problem
		if (maze[row][col] == 3) {
			return true;
		}

		// add the position to our path changing its value to '2'
		maze[row][col] = 2;

		//try all available neighbours 
		//North (row, col-1), South (row, col+1), East (row+1, col) and West (row-1, col)
		// if any of these return true then we have solved the problem
		if (isAvailablePosition(row - 1, col) && findPathFrom(row - 1, col)) {
			return true;
		}
		if (isAvailablePosition(row + 1, col) && findPathFrom(row + 1, col)) {
			return true;
		}
		if (isAvailablePosition(row, col - 1) && findPathFrom(row, col - 1)) {
			return true;
		}
		if (isAvailablePosition(row, col + 1) && findPathFrom(row, col + 1)) {
			return true;
		}

		//If none of previous positions are valid or reach the goal, it is necessary to revert the 
		//temporary state. This reversal or backtrack is what give name to the algorithm: backtracking
		maze[row][col] = 1;

		return false;
	}

    // A position is available if: (1) it is inside the bounds of the maze 
    // (2) if it is an open space or (3) it is the goal 
    private static boolean isAvailablePosition(int row, int col) {
        boolean result =  row >= 0 && row < maze.length
                && col >= 0 && col < maze[row].length
                && (maze[row][col] == 1 || maze[row][col] == 3);
                return result;
    }

    private static boolean isUnAvailablePosition(int row, int col) {
        boolean result =  row < 0 || row >= maze.length
                || col < 0 || col >= maze[row].length
                || (maze[row][col] != 1 && maze[row][col] != 3);
                return result;
    }
    
    //print the output using MAZE_SYMBOLS
	private static void print(){
		for(int row = 0; row < maze.length; ++row) {
			for(int col = 0; col < maze[row].length; ++col) {
				System.out.print(MAZE_SYMBOLS[maze[row][col]]);
			}
			System.out.println();
		}
	}

}