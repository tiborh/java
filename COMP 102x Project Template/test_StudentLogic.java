import java.util.Random;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

import comp102x.ColorImage;
import comp102x.assignment.GameLogic;
import comp102x.assignment.GameRecord;
import comp102x.assignment.Goal;
/**
 * Write a description of class test_StudentLogic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test_StudentLogic extends StudentLogic
{
    /**
     * The method is called by the program periodically to update the positions of the goals.
     * 
     * @param goals goals is a 2D array of Goal objects that represents the goals displayed on the main game screen
     * 
     */
    public void updateGoalPositions(Goal[][] goals) {
        // if type is 1, it is STATIONARY
        // if type is 2, it is MOVABLE
        // value may be used for movement indicator
        incrementHeartBeatCounter();
        System.out.printf("Heart beat counter: %d\n",getHeartBeatCounter());        
        String[][][] neighbouringGoals = getNeighbouringGoals();
        //examine neighborhood
        if (!goals[0][0].isHit())
        {
            String currentGoal = "0,0";
            String[] theNeighbours = neighbouringGoals[0][0];
            String[] possibleJumps = new String[MAXN];
            int possibleJumpCounter = 0;
            for (String aNeighbour : theNeighbours)
            {
                if (aNeighbour != null)
                {
                    int[] theCoords = coordsToArray(aNeighbour);
                    if (goals[theCoords[0]][theCoords[1]].getType() == 2 && goals[theCoords[0]][theCoords[1]].isHit())
                    {
                        //System.out.println("to be swapped with:" + a.neighbour);
                        swapGoals(goals,currentGoal,aNeighbour);
                        break;
                    }
                }
            }
        }
            
        
        //show goals and status                
        for (Goal[] aRow : goals)
        {
            for (Goal aGoal : aRow)
            {
                if (aGoal.getValue() == getHeartBeatCounter())
                    System.out.printf("(%d %d %b)",aGoal.getType(),aGoal.getValue(),aGoal.isHit());
                else
                    System.out.print("            ");
                System.out.print("\t");
                if (!aGoal.isHit())
                    aGoal.setValue(aGoal.getValue()+1);
                //System.out.printf("(%d %d %b)\t",aGoal.getType(),aGoal.getValue(),aGoal.isHit());
                //a_goal.setValue(a_goal.getValue() + 1);
            }
            System.out.println();
        }
        System.out.println();
    }
 
    
    //from this point forward, the methods are not needed for a successful assignements
    //the following methods are used for testing purposes only
    
    public static void print_neighbour_grid()
    {
        for (int[][] a_row : neighbourGrid)
        {
            System.out.printf("( ");
            for (int[] a_col : a_row)
            {
                System.out.printf("( ");
                for (int a_coord : a_col)
                {
                    System.out.printf("%+d ",a_coord);
                }
                System.out.printf(") ");
            }
            System.out.printf(")\n");
        }

    }
    
    public static GameRecord[] read_high_scores(String input_filename) throws IOException
    {
        Scanner input = new Scanner(Paths.get(input_filename));
        GameRecord[] score_table;
        String[] the_lines = new String[10]; 

        int i;
        for (i = 0; input.hasNextLine() && i < the_lines.length; i++)
            the_lines[i] = input.nextLine();
          
        input.close();
            
        score_table = new GameRecord[i];
        
        for (i = 0; i < score_table.length; i++)
            score_table[i] = fill_game_record(the_lines[i]);
        
        return score_table;
    }
    
    public static GameRecord fill_game_record(String record_data)
    {
        String[] broken_line = record_data.split("\\s+");
        GameRecord out_record = fill_game_record(broken_line);
        
        return out_record;
    }
    
    public static GameRecord fill_game_record(String[] in_array)
    {
        GameRecord out_record = new GameRecord(in_array[0],Integer.parseInt(in_array[1]),Integer.parseInt(in_array[2]));        
        return out_record;
    }
    
    public static void print_high_score_table(GameRecord[] highScoreRecords) {
        for (GameRecord a_row : highScoreRecords)
            print_game_record(a_row);
    }
    
    public static void print_game_record(GameRecord a_record)
    {
        System.out.printf("%s:\t%d\t%d\n", a_record.getName(), a_record.getLevel(), a_record.getScore());
    }

    public static void print_coord_array(int[][] coord_array)
    {
        for (int[] a_coord : coord_array)
            print_coord_array(a_coord);
    }

    
    public static void print_coord_array(int[] coord_array)
    {
        for (int a_coord : coord_array)
            System.out.print(a_coord + " ");
        System.out.println();
    }
    
    public static void print_coord_array(String[] coord_array)
    {
        for (String a_coord : coord_array)
            System.out.println(a_coord);
    }
    
    public static String coords_to_string(int[] in_coords)
    {
        String out_string = "";
        for (int i = 0; i < in_coords.length; i++)
        {
            out_string += "" + in_coords[i];
            if (i != in_coords.length-1)
                out_string += ",";
        }
        return out_string;
    }

    
    public static void main(String[] argv) throws IOException
    {
        
        //testScoreTable = read_high_scores("highScore.1");
        GameRecord record_a = new GameRecord("Naomi",1,2);
        print_game_record(record_a);
        GameRecord record_b = new GameRecord("Tess",1,3);
        print_game_record(record_b);
        System.out.printf("Two records compared (a,b): %d\n", compareGameRecords(record_a,record_b));
        System.out.printf("Two records compared (b,a): %d\n", compareGameRecords(record_b,record_a));
        System.out.printf("Two records compared (a,a): %d\n", compareGameRecords(record_a,record_a));
        GameRecord record_c = new GameRecord("Vince",2,2);
        print_game_record(record_c);
        System.out.printf("Two records compared (a,c): %d\n", compareGameRecords(record_a,record_c));
        System.out.printf("Two records compared (b,c): %d\n", compareGameRecords(record_b,record_c));
        System.out.printf("Two records compared (c,a): %d\n", compareGameRecords(record_c,record_a));
        System.out.printf("Two records compared (c,c): %d\n", compareGameRecords(record_c,record_c));
        
        GameRecord[] testScoreTable = read_high_scores("highScore.001");
        System.out.println("The original array:");
        print_high_score_table(testScoreTable);

        testScoreTable = sortGameRecords(testScoreTable);
        System.out.println("The sorted array:");
        print_high_score_table(testScoreTable);
        
        StudentLogic a_logic = new StudentLogic();
        a_logic.printNeighbours();
        print_neighbour_grid();
        System.out.printf("Length of neighbourGrid: %d\n",neighbourGrid.length);
        int[] test_coord0 = {0,0};
        System.out.printf("Examining coordinate (%s):\n",coords_to_string(test_coord0));
        print_coord_array(whatNeighbours(test_coord0));
        int[] test_coord1 = {0,1};
        System.out.printf("Examining coordinate (%s):\n",coords_to_string(test_coord1));
        print_coord_array(whatNeighbours(test_coord1));
        int[] test_coord2 = {1,1};
        System.out.printf("Examining coordinate (%s):\n",coords_to_string(test_coord2));
        print_coord_array(whatNeighbours(test_coord2));
        int[] test_coord3 = {3,3};
        System.out.printf("Examining coordinate (%s):\n",coords_to_string(test_coord3));
        print_coord_array(whatNeighbours(test_coord3));
        System.out.printf("The same after conversion to integer array:\n");
        int[][] coords_array3 = coordsToArray(whatNeighbours(test_coord3));
        print_coord_array(coords_array3);
        
        System.out.println("an interesting test tool:");
        String testString = "1,3";
        System.out.println(java.util.Arrays.toString(testString.split(",")));
        System.out.println(java.util.Arrays.toString(coordsToArray("0,0")));
    }
}
