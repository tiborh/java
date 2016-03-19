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
    //from this point forward, the methods are not needed for a successful assignements
    //the following methods are used for testing purposes only
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
        GameRecord[] testScoreTable = read_high_scores("highScore.001");
        System.out.println("The original array:");
        print_high_score_table(testScoreTable);
        
        StudentLogic a_logic = new StudentLogic();
        
        /*
        System.out.println("an interesting test tool:");
        String testString = "1,3";
        System.out.println(java.util.Arrays.toString(testString.split(",")));
        System.out.println(java.util.Arrays.toString(coordsToArray("0,0")));
        */
    }
}
