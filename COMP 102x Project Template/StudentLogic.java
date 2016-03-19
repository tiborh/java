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
 * Implements the student logic of the project assignment: Shooting Game
 * 
 * @author Tibor
 * @version 0.01
 */
public class StudentLogic implements GameLogic{
    /** Number of rows in the goal matrix */
    final static int ROWS = 3;
    /** Number of columns in the goal matrix */
    final static int COLS = 4;
    
    /** Maximumn number of neighbours around a goal */
    final static int MAXN = 8;

    /** the matrix to store coordinates of neighbouring goals for each goal */
    private String[][][] neighbouringGoals = new String[ROWS][COLS][MAXN];
    
    /** the matrix that shows the relative positions of possible neighbours */
    final static int[][][] neighbourGrid = { { {-1,-1}, {-1,0}, {-1,1} },
                                             {  {0,-1},  {0,0},  {0,1} },
                                             {  {1,-1},  {1,0},  {1,1} } };

    /** For measuring how many times updateGoalPositions has been called. Synchronised to goal values. */
    private int heartBeatCounter = 0;
    
    /** Random genarator for update goals */
    Random randGen = new Random();

    /** initialises student logic */
    public StudentLogic()
    {
        fillUpNeighbours();
        //printNeighbours();
    }
    
    /**
     * The method generates an intermediate football image for the shooting animation
     * 
     * @param depthImages   an array of football images of different depths
     * @param initialStep   represents the initial step of the shooting animation 
     * @param currentStep   represents the current step of the shooting animation 
     * @param finalStep     represents the final step of the shooting animation 
     * @param initialScale  represents the initial scale of the football
     * @param finalScale    represents the final scale of the football
     * @param initalX       represents the initial x position of the football
     * @param finalX        represents the final x position of the football
     * @param initialY      represents the initial y position of the football
     * @param finalY        represents the final y position of the football
     * 
     * @return the selected depth image
     */
    public ColorImage generateIntermediateFootballImage(ColorImage[] depthImages, 
                                                        int initialStep,
                                                        int currentStep,
                                                        int finalStep,
                                                        double initialScale,
                                                        double finalScale,
                                                        int initialX,
                                                        int finalX,
                                                        int initialY,
                                                        int finalY)
    {
        // ColorImage will be returned
        ColorImage selectedImage;
        
        // in all the equations the same ratio appears, so it is best treated as a coefficient
        double stepCoefficient = ((double)currentStep - initialStep) / (finalStep - initialStep);   
        
        // Index of image to select from deptImages array
        int imageIndex = (int) ((depthImages.length - 1) * stepCoefficient);
        
        // Select the image
        selectedImage = depthImages[imageIndex];
        
        // Set the X and Y positions of the image
        selectedImage.setX((int) (initialX + (finalX - initialX) * stepCoefficient));
        selectedImage.setY((int) (initialY + (finalY - initialY) * stepCoefficient));
        
        // Set the scale of the image
        selectedImage.setScale(initialScale + (finalScale - initialScale) * stepCoefficient);
        
        return selectedImage;
    }

    /**
     * Swaps two goals in the goals matrix
     * 
     * @param goals is a 2D array of Goal objects that represents the goals displayed on the main game screen
     * @param goalA one of the goals to swap
     * @param goalB the other of the goals to swap
     */
    public void swapGoals(Goal[][] goals, String goalA, String goalB)
    {
        int[] coordsA = coordsToArray(goalA);
        int[] coordsB = coordsToArray(goalB);
        Goal tempGoal = goals[coordsA[0]][coordsA[1]];
        goals[coordsA[0]][coordsA[1]] = goals[coordsB[0]][coordsB[1]];
        goals[coordsB[0]][coordsB[1]] = tempGoal;
        
    }

    /**
     * The method is called by the program periodically to update the positions of the goals. The value of the not-yet-hit goals is synchronised with heartBeat.
     * Heartbeat is also used for not moving the same goal twice during the same heart beat.
     * 
     * @param goals is a 2D array of Goal objects that represents the goals displayed on the main game screen
     * 
     */
    public void updateGoalPositions(Goal[][] goals) {
        // if type is 1, it is STATIONARY
        // if type is 2, it is MOVABLE
        // value is used to synchronise acitve goals with heartbeat
        //System.out.printf("Heart beat counter: %d\n",++heartBeatCounter);
        ++heartBeatCounter;
                       
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if (goals[row][col].getValue() == heartBeatCounter)
                {
                    if (!goals[row][col].isHit())
                    {
                        goals[row][col].setValue(goals[row][col].getValue() + 1);
                        String[] theNeighbours = getNeighbouringGoals(row,col);
                        String[] possibleJumps = getPossibleJumps(goals,theNeighbours);
                        if (possibleJumps != null)
                        {
                            int swapIndex = 0;
                            if (possibleJumps.length > 1)
                                swapIndex = randGen.nextInt(possibleJumps.length);
                            swapGoals(goals,row + "," + col,possibleJumps[swapIndex]);
                        }
                    }
                    
                }
            }
        }
    }

    /**
     * gets neighboring goals from neighbouringGoals table
     * 
     * @param row the row number in neighbouringGoals
     * @param col the column number in neighbouringGoals
     * 
     * return a string array with neighbouring coordinates
     */
    public String[] getNeighbouringGoals(int row, int col)
    {
        String[] rawOut = neighbouringGoals[row][col];
        
        int lengthCounter = 0;
        for (String aString : rawOut)
            if (aString != null)
                lengthCounter++;
        String[] outArray = new String[lengthCounter];
        System.arraycopy(rawOut, 0, outArray, 0, lengthCounter);
        
        return outArray;
    }
    
    /**
     * gets neighboring goals from neighbouringGoals table
     * 
     * @param inCoord the coordinates in neighbouringGoals where the neighbour data is stored.
     * 
     * return a string array with neighbouring coordinates
     */
    public String[] getNeighbouringGoals(String inCoord)
    {
        int[] currentCoords = coordsToArray(inCoord);
        return getNeighbouringGoals(currentCoords[0],currentCoords[1]);
    }
    
    /**
     * Filters from possible neighbours those where a jump can be made
     * 
     * @param goals a 2D array of Goal objects that represents the goals displayed on the main game screen
     * @param theNeighbours the list of neighbouring goals
     * 
     * return a string array with coordinates of possible jumps
     */
    public String[] getPossibleJumps(Goal[][] goals, String[] theNeighbours)
    {
        String[] outArray;
        int hitCounter = 0;
        for (String aCoord : theNeighbours)
        {
            int[] theCoord = coordsToArray(aCoord);
            //System.out.printf("The coords: %d,%d\n",theCoord[0],theCoord[1]);
            if (goals[theCoord[0]][theCoord[1]].isHit() && goals[theCoord[0]][theCoord[1]].getType() == 2)
                hitCounter++;
        }
        if (hitCounter == 0)
            return null;
        outArray = new String[hitCounter];
        hitCounter = 0;
        for (String aCoord : theNeighbours)
        {
            int[] theCoord = coordsToArray(aCoord);
            if (goals[theCoord[0]][theCoord[1]].isHit() && goals[theCoord[0]][theCoord[1]].getType() == 2)
            {
                outArray[hitCounter] = aCoord;
                hitCounter++;
            }
        }
        return outArray;
    }
       
    /**
     * The method compares the record of the current game play with
     * those of previous game plays and update the highscore records.
     * 
     * @param highScoreRecords  represents the 1D array of the GameRecords of previous game plays
     * @param name              the name of the current game player
     * @param level             the level of the current game play
     * @param score             the score of the current game play
     * 
     * @return a new GameRecord array with current score added if among the top ten
     */
    public GameRecord[] updateHighScoreRecords(GameRecord[] highScoreRecords, 
                                               String name, 
                                               int level, 
                                               int score)
    {
        // creating new game record array
        GameRecord[] currentHighScores;
        // creating entry for current record
        GameRecord currentScore = new GameRecord(name,level,score);
        
        // determining the number of records already present
        int numberOfRecords = highScoreRecords.length;
        //System.out.printf("Length of highScoreRecords: %d\n",numberOfRecords);
        
        // filling up currentHighScores array
        if (numberOfRecords == 0)
        {
            //System.out.println("current record is the only record");
            currentHighScores = new GameRecord[1];
            currentHighScores[0] = currentScore;
        } else if (numberOfRecords < 10 && !isNameOnRecord(highScoreRecords,name))
        {
            //System.out.println("new name and there is still space on the list");
            currentHighScores = new GameRecord[numberOfRecords + 1];
            for (int i = 0; i < numberOfRecords; i++)
                currentHighScores[i] = highScoreRecords[i];
            currentHighScores[numberOfRecords] = currentScore;
        } else if (numberOfRecords == 10 && !isNameOnRecord(highScoreRecords,name))
        {
            //System.out.println("full list and name is not on the list");
            if (isThereLowerScore(highScoreRecords,currentScore))
            {
                int indexToReplace = getIndexToReplace(highScoreRecords);
                currentHighScores = updateRecord(highScoreRecords, indexToReplace, currentScore);
            } else
            {
                currentHighScores = new GameRecord[numberOfRecords];
                System.arraycopy(highScoreRecords, 0, currentHighScores, 0, numberOfRecords);
            }
        } else if (isNameOnRecord(highScoreRecords,name) && isCurrentRecordHigher(highScoreRecords,currentScore))
        {
            //System.out.println("higher score for the same name");
            currentHighScores = updateRecord(highScoreRecords, currentScore);
        } else
        {
            //System.out.println("else: catchall");
            currentHighScores = new GameRecord[numberOfRecords];
            System.arraycopy(highScoreRecords, 0, currentHighScores, 0, numberOfRecords);
        }
        
        currentHighScores = sortGameRecords(currentHighScores);
        
        return currentHighScores;
    }
    
    /**
     * The method checks if a name is already in the high score table
     * 
     * @param highScoreRecords represents the 1D array of the GameRecords of previous game plays
     * @param name             the name of the current game player
     * 
     * @return true if the name is on the records, false if the name is not on the records
     */
    public static boolean isNameOnRecord(GameRecord[] highScoreRecords, String name)
    {
        for (GameRecord aRecord : highScoreRecords)
            if (aRecord.getName().toLowerCase().equals(name.toLowerCase()))
                return true;
                
        return false;
    }
    
    /**
     * The method checks if a current score is higher than the one in the high score table
     * 
     * @param highScoreRecords represents the 1D array of the GameRecords of previous game plays
     * @param currentRecord    the current game record
     * 
     * @return true if the current record is higher, false if the current record is lower or not on the list
     */
    public static boolean isCurrentRecordHigher(GameRecord[] highScoreRecords, GameRecord currentRecord)
    {
        // get the name out for shorter expressions later
        String currentName = currentRecord.getName();

        for (GameRecord aRecord : highScoreRecords)
            if (aRecord.getName().toLowerCase().equals(currentName.toLowerCase()))
                if (compareGameRecords(currentRecord,aRecord) > 0)
                    return true;
                
        return false;
    }
    
    /**
     * The method checks if there is lower score in the high score table than the score of the current record
     * 
     * @param highScoreRecords represents the 1D array of the GameRecords of previous game plays
     * @param currentRecord    the current game record
     * 
     * @return true if there is lower score, and false if there is not
     */
    public static boolean isThereLowerScore(GameRecord[] highScoreRecords, GameRecord currentRecord)
    {           
        for (GameRecord aRecord : highScoreRecords)
            if (compareGameRecords(currentRecord,aRecord) > 0)
                return true;
        
        return false;
    }
    
    /**
     * The method gets the index of the minimum score record
     * 
     * @param highScoreRecords represents the 1D array of the GameRecords of previous game plays
     * 
     * @return the index of the record to be replaced
     */
    public static int getIndexToReplace(GameRecord[] highScoreRecords)
    {
        int minScoreIndex = 10;
        GameRecord minScoreRecord = highScoreRecords[0];
        
        for (int i = 1; i < highScoreRecords.length; i++)
        {
            if (compareGameRecords(highScoreRecords[i],minScoreRecord) < 0)
            {
                minScoreRecord = highScoreRecords[i];
                minScoreIndex = i;
            }
        }
        
        return minScoreIndex;
    }
    
    /**
     * The method updates the high score table record where the name is identical to the one in currentRecord
     * 
     * @param highScoreRecords represents the 1D array of the GameRecords of previous game plays
     * @param currentRecord    the current game record
     * 
     * @return the updated high score record array
     */
    public static GameRecord[] updateRecord(GameRecord[] highScoreRecords, GameRecord currentRecord) {
        // creating new game record array
        GameRecord[] currentHighScores = new GameRecord[highScoreRecords.length];
        
        // get the name out:
        String currentName = currentRecord.getName();
        
        for (int i = 0; i < highScoreRecords.length; i++)
        {
            if (highScoreRecords[i].getName().toLowerCase().equals(currentName.toLowerCase()))
                currentHighScores[i] = currentRecord;
            else
                currentHighScores[i] = highScoreRecords[i];
        }
                
        return currentHighScores;
    }
    
    /**
     * The method updates the high score table with currentRecord at indexToReplace
     * 
     * @param highScoreRecords  represents the 1D array of the GameRecords of previous game plays
     * @param indexToReplace    the index where the record will be replaced by currentRecord
     * @param currentRecord     the current game record
     * 
     * @return the updated high score record array
     */
    public static GameRecord[] updateRecord(GameRecord[] highScoreRecords, int indexToReplace, GameRecord currentRecord) {
        // creating new game record array
        GameRecord[] currentHighScores = new GameRecord[highScoreRecords.length];
                
        for (int i = 0; i < highScoreRecords.length; i++)
        {
            if (i == indexToReplace)
                currentHighScores[i] = currentRecord;
            else
                currentHighScores[i] = highScoreRecords[i];
        }
                
        return currentHighScores;
    }
    
    /**
     * The method returns with a sorted version of the input high scores array, in descending order
     * 
     * @param highScoreRecords  represents the 1D array of the GameRecords of previous game plays
     * 
     * @return the sorted high score record array
     */
    public static GameRecord[] sortGameRecords(GameRecord[] highScoreRecords) {
        // used often, so a variable is better defined
        int numberOfRecords = highScoreRecords.length;

        //make a copy to defend the original one
        GameRecord[] sortedInputTable = new GameRecord[numberOfRecords];
        System.arraycopy(highScoreRecords, 0, sortedInputTable, 0, numberOfRecords);
                
        int maxIndex;
                
        for (int i = 0; i < numberOfRecords; i++)
        {
            maxIndex = i;
            for (int j = i+1; j < numberOfRecords; j++)
                if (compareGameRecords(sortedInputTable[maxIndex],sortedInputTable[j]) < 0)
                    maxIndex = j;

            if (compareGameRecords(sortedInputTable[maxIndex],sortedInputTable[i]) != 0)
                sortedInputTable = swapGameRecords(sortedInputTable, maxIndex, i);
        }
                
        return sortedInputTable;
    }

    
     /**
     * The method swaps two records in the high score records
     * 
     * @param highScoreRecords  represents the 1D array of the GameRecords of previous game plays
     * @param indexA            the index of the first record in the swap
     * @param indexB            the index of the second record in the swap
     * 
     * @return the modified high score record array
     */   
    public static GameRecord[] swapGameRecords(GameRecord[] highScoreRecords, int indexA, int indexB)
    {
        int numberOfRecords = highScoreRecords.length;
                
        // make a copy of the original record table
        GameRecord[] inputTable = new GameRecord[numberOfRecords];
        System.arraycopy(highScoreRecords, 0, inputTable, 0, numberOfRecords);
        
        // the swap
        GameRecord tempRecord = inputTable[indexA];
        inputTable[indexA] = inputTable[indexB];
        inputTable[indexB] = tempRecord;
        
        return inputTable;
    }
    
    /**
     * The method compares two game records
     * 
     * @param gameRecordA       first game record to compare
     * @param gameRecordB       second game record to compare
     * 
     * @return zero if the two records are equal, 
     *         less than zero if gameRecordA is less than gameRecordB, 
     *         more than zero if gameRecordA is greater than gameRecordB
     */
    public static int compareGameRecords(GameRecord gameRecordA, GameRecord gameRecordB)
    {
        int scoreA = gameRecordA.getScore();
        int scoreB = gameRecordB.getScore();
        int levelA = gameRecordA.getLevel();
        int levelB = gameRecordB.getLevel();
        
        if (scoreA > scoreB || scoreA < scoreB)
            return scoreA - scoreB;
        if (scoreA == scoreB)
        {
            if (levelA == levelB)
                return 0;
            if (levelA > levelB || levelA < levelB)
                return (levelA - levelB) * 16;
        }
            
        return -1000;
    }
    
    /**
     * Converts an array of string coordinates into a 2D int array of coordinates
     * 
     * @param coordStrings contains the list of coordinate strings, e.g. {"1,3","2,2"}
     * 
     * @return a 2D integer array with the coordinates, e.g. {{1,3},{2,3}}
     */
    public static int[][] coordsToArray(String[] coordStrings)
    {
        int[][] coordIntArray = new int[coordStrings.length][];
        for (int i = 0; i < coordStrings.length; i++) {
            coordIntArray[i] = coordsToArray(coordStrings[i]);
        }
        return coordIntArray;
    }
    
    /**
     * Converts a comma separated coordinate string into an integer array
     * 
     * @param coordString contains the comma separated coordinate string, e.g. "1,3"
     * 
     * @return an integer array with the coordinates, e.g. {1,3}
     */
    public static int[] coordsToArray(String coordString)
    {
        String[] coordStrArray = coordString.split(",");
        int[] coordIntArray = new int[coordStrArray.length];
        for (int i = 0; i < coordStrArray.length; i++)
            coordIntArray[i] = Integer.parseInt(coordStrArray[i]);
        return coordIntArray;
    }

    /** 
     * increments heardBeatCounter 
     */
    public void incrementHeartBeatCounter()
    {
        ++heartBeatCounter;
    }
    
    /** 
     * gets the value of heartBeatCounter
     */
    public int getHeartBeatCounter()
    {
        return heartBeatCounter;
    }

    /** 
     * gets the value of neighbouringGoals
     */
    public String[][][] getNeighbouringGoals()
    {
        return neighbouringGoals;
    }

    /**
     * The method fills up neighbouringGoals array
     */
    public void fillUpNeighbours()
    {
        for (int rows = 0; rows < ROWS; rows++)
        {
            for (int cols = 0; cols < COLS; cols++)
            {
                int[] theCoords = {rows,cols};
                String[] theNeighbours = whatNeighbours(theCoords);
                for (int neighCounter = 0; neighCounter < theNeighbours.length; neighCounter++)
                    neighbouringGoals[rows][cols][neighCounter] = theNeighbours[neighCounter];
            }
        }
    }

    /**
     * The method gives all neighbouring coordinates of inCoords in a ROWS by COLS array.
     * 
     * @param inCoords the input coordinate
     * 
     * @return an array of coordinate strings
     */
    public static String[] whatNeighbours(int[] inCoords)
    {
        String[] insideArray = new String[MAXN];
        int arrayCounter = 0;
        
        for (int[][] aRow : neighbourGrid)
        {
            for (int[] aCell : aRow)
            {
                int rowCoord = inCoords[0] + aCell[0];
                int colCoord = inCoords[1] + aCell[1];
                if ((rowCoord >= 0 && rowCoord < ROWS) && (colCoord >= 0 && colCoord < COLS) && !(rowCoord == inCoords[0] && colCoord == inCoords[1]))
                {
                    insideArray[arrayCounter++] = rowCoord + "," + colCoord;
                }
            }
        }
        
        String[] actualNeighbours = new String[arrayCounter];
        System.arraycopy(insideArray, 0, actualNeighbours, 0, arrayCounter);
        
        return actualNeighbours;
    }

    /**
     * the method prints out the neighbouringGoals table to the console.
     */
    public void printNeighbours()
    {
        for (int rows = 0; rows < ROWS; rows++)
        {
            for (int cols = 0; cols < COLS; cols++)
            {
                System.out.print("(");
                if (neighbouringGoals[rows][cols] != null)
                {
                    for (int neighs = 0; neighs < neighbouringGoals[rows][cols].length; neighs++)
                    {
                        if (neighbouringGoals[rows][cols][neighs] != null)
                        {
                            System.out.print("(" + neighbouringGoals[rows][cols][neighs] + ")");
                            if (neighs != neighbouringGoals[rows][cols].length - 1 && neighbouringGoals[rows][cols][neighs+1] != null)
                                System.out.print(", ");
                        }
                    }
                }
                System.out.print(") ");
            }
            System.out.println();
        }
    }
        
}
