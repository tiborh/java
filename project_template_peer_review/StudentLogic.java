//import java.util.Random;
//For ArrayList from Collections Framework using
import java.util.*;

import comp102x.ColorImage;
import comp102x.assignment.GameLogic;
import comp102x.assignment.GameRecord;
import comp102x.assignment.Goal;
/** 
 * The important logic of the game:  shooting animation, update the positions of the 
 * goals
 */
public class StudentLogic implements GameLogic{
    /**
     * Class describes a scheme to move the goal. A row and a column will move the goal and by what 
     * position.
     */
    public class MovingScheme {
        final int ROW_FROM;
        final int COLUMN_FROM;
        final int ROW_TO;
        final int COLUMN_TO;
        public MovingScheme (int rowFrom, int columnFrom, int rowTo, int columnTo){
            ROW_FROM = rowFrom;
            COLUMN_FROM = columnFrom;
            ROW_TO = rowTo;
            COLUMN_TO = columnTo;            
        }
        public String toString (){
            return ("[" + ROW_FROM + ", " + COLUMN_FROM + "]->[" + ROW_TO + ", " + COLUMN_TO + "]");            
        }             
    }
    /**
     * The method generates an intermediate football image for the shooting animation.
     *  
     * The method performs select of the football image from the depthImages array, sets the image
     * position and scale according to the current step of the shooting animation by calculate all 
     * values with the special formula.
     * 
     * @param   depthImages     an array of football images of different depths
     * @param   initialStep     initial step of the shooting animation
     * @param   currentStep     current step of the shooting animation
     * @param   finalStep       final step of the shooting animation
     * @param   initialScale    represent the initial scale of the football image
     * @param   finalScale      represent the final scale of the football image
     * @param   initialX        represent the initial x positions of the football image
     * @param   finalX          represent the final x positions of the football image
     * @param   initialY        represent the initial y positions of the football image
     * @param   finalY          represent the final y positions of the football image
     * 
     * @return  football image
     */   
    public ColorImage generateIntermediateFootballImage (   ColorImage[] depthImages, 
                                                            int initialStep, 
                                                            int currentStep, 
                                                            int finalStep, 
                                                            double initialScale, 
                                                            double finalScale, 
                                                            int initialX, 
                                                            int finalX, 
                                                            int initialY, 
                                                            int finalY) {
        // double coefficient indicates how the scale and foolball position changes in time 
        double coefficient = (currentStep - initialStep)/ (double)(finalStep - initialStep);
        //choose the appropriate football image
        ColorImage footballImage = depthImages[(int) ((depthImages.length - 1)*coefficient)];
        //set the appropriate football image size
        footballImage.setX((int) (initialX + (finalX - initialX)*coefficient));
        footballImage.setY((int) (initialY + (finalY - initialY)*coefficient));        
        //set the appropriate football image scale
        footballImage.setScale(initialScale + (finalScale - initialScale)*coefficient);
        return footballImage;
    }
    
    /**
     * The method is called by the program periodically to update the positions of the goals.
     * 
     * The method iterates over all goals. For each goal find all possible variants of its movement. 
     * All variants are stored in the list. While the list is not empty it randomly selected one 
     * moving scheme. The chosen scheme is removed. Other variants for moving this goal are also 
     * deleted (see the description of the method movingSchemeErase).
     * 
     * @param goals goals array
     */
    public void updateGoalPositions(Goal[][] goals) {
        //determine the size of the array
        int columns = goals[0].length;        
        int rows = goals.length;
        //ArrayList from Collections Framework stores all found possible movements
        ArrayList <MovingScheme> possibleMovesTable = new ArrayList <MovingScheme> ();
        //iterates over all goals
        for (int rowPos = 0; rowPos < rows; rowPos++){
            for (int columnPos = 0; columnPos < columns; columnPos++){
                //if the goal is movable and was not hit, find allpossible moves for this goal and
                //store in the list
                if ((goals[rowPos][columnPos].getType() == Goal.MOVABLE) && 
                    !(goals[rowPos][columnPos].isHit())){
                    possibleMovesTable.addAll(possibleMovesForGoal (goals, rowPos, columnPos));
                }
            }
        }
        Random random = new Random();
        while (possibleMovesTable.size() > 0){
            //find random moving scheme
            MovingScheme movingScheme = possibleMovesTable.remove(random.nextInt((possibleMovesTable.size())));
            //move the goal
            moveGoal (goals, movingScheme);
            //delete inappropriate variants
            movingSchemeErase (possibleMovesTable, movingScheme);
        }
    }    
    /**
     * The method removes from the list that schemes, which coincide with the scheme of the place 
     * from the target is moved, or the place where the target is moved.
     * 
     * @param   possibleMovesTable  list of moving schemes
     * @param   movingScheme        moving scheme which compares with schemes from list
     */
    public void movingSchemeErase (ArrayList <MovingScheme> possibleMovesTable, MovingScheme movingScheme){
        Iterator <MovingScheme> possibleMovesTableIterator = possibleMovesTable.iterator();
        //find until list have schemes
        while (possibleMovesTableIterator.hasNext()){
             MovingScheme movingSchemeInTable = possibleMovesTableIterator.next();
             //compare scheme from list with the movingScheme
             if (   ((movingSchemeInTable.ROW_FROM == movingScheme.ROW_FROM) && 
                    (movingSchemeInTable.COLUMN_FROM == movingScheme.COLUMN_FROM)) ||
                    ((movingSchemeInTable.ROW_TO == movingScheme.ROW_TO) && 
                    (movingSchemeInTable.COLUMN_TO == movingScheme.COLUMN_TO))){
                        //if conditions are satisfied remove scheme from list
                        possibleMovesTableIterator.remove();
             }              
        }        
    }
    /**
     * The method searches for all possible movements of goal in "row - colomn" position.
     * 
     * @param   goals           goal array
     * @param   row             goal row position
     * @param   column          goal column position
     * @return  possibleMoves   list of all possible moves for goal
     */
    public ArrayList <MovingScheme> possibleMovesForGoal (Goal[][] goals, int row, int column){
        //ArrayList from Collections Framework stores all found possible movements
        ArrayList <MovingScheme> possibleMoves = new ArrayList <MovingScheme> ();
        //iterate through all possible nearby goals
        for (int rowBias = -1; rowBias <= 1; rowBias++){
            for (int columnBias = -1; columnBias <= 1; columnBias++){
                try {
                    //if the goal is hit - save it as a possible variant to move
                    if (goals[row + rowBias][column + columnBias].isHit()){
                        possibleMoves.add(new MovingScheme (row, column, row + rowBias, column + columnBias));
                    }
                } catch (Exception e) {/*Do nothing*/}
            }
        }
        return possibleMoves;
    }
    /**
     * The method moves the goal in accordance with the scheme of movement.
     * 
     * @param   goals           goals array
     * @param   movingScheme    scheme of movement
     */
    public void moveGoal (Goal[][] goals, MovingScheme movingScheme){
        //swap the two goals
        Goal goal = goals [movingScheme.ROW_FROM][movingScheme.COLUMN_FROM];
        goals [movingScheme.ROW_FROM][movingScheme.COLUMN_FROM] = 
            goals [movingScheme.ROW_TO][movingScheme.COLUMN_TO];
        goals [movingScheme.ROW_TO][movingScheme.COLUMN_TO] = goal;
    }
    /**
     * The method is called by the program when the game finishes and compares the record of the current game 
     * play with those of previous game plays and update the highscore records. Update realizes in according with:
     * If there are no previous game play records, return a new GameRecord array of 
     * size 1 containing the current record.
     * If the player's name doesn't exist in the previous records and there are less 
     * than 10 previous records, return a new GameRecord array containing all the 
     * previous records and the new record.
     * If the player's name doesn't exist in the previous records and there are 10 
     * previous records, return a new GameRecord array containing the best 10 records. 
     * A record is better than the other one if it has a higher score, or the two 
     * records have the same score, but it has a higher level. 
     * If the player's name exists in the previous records and the current record is 
     * better than the previous record, return a new GameRecord array containing all 
     * the previous records, but with the score and level of the player updated to 
     * those of the current game play.
     * If the player's name exists in the previous records and the current record is 
     * the same or is worse than the previous record, return a new GameRecord array 
     * containing all the previous records.
     * In all of the cases listed above, the records in the returned GameRecord array 
     * should be sorted first by score, and then by level in descending order, and then
     * by name in alphabetical order.
     * 
     * @param   highScoreRecords    1D array of the GameRecords of prevous game plays with the maximum size HIGH_SCORE_RECORDS_ALL
     * @param   name                represents the name of the current game play. This method returns a 1D array of GameRecords after processing the record of the current game play.
     * @param   level               represents the level of the current game play
     * @param   score               represents the score of the current game play
     * @return  1D array of GameRecords after processing the record of the current game play
     */
    public GameRecord[] updateHighScoreRecords(GameRecord[] highScoreRecords, String name, int level, int score) {
        //save the maximum number of prevous game plays results
        final int HIGH_SCORE_RECORDS_ALL = 10;
        /**
         * Class for comparing the GameRecord. The records are sorte first by score, and then by level in 
         * descending order, and then by name in alphabetical order.
         */
        class GameRecordComparator implements Comparator <GameRecord> {
            private boolean RECORDS_DIFFER_ONLY_BY_NAMES = false;
            public int compare (GameRecord gameRecord1, GameRecord gameRecord2){
                //sort in descending order by score and level
                if (gameRecord1.getScore() > gameRecord2.getScore()){
                    RECORDS_DIFFER_ONLY_BY_NAMES = false;
                    return -1;
                } else if (gameRecord1.getScore() < gameRecord2.getScore()){
                    RECORDS_DIFFER_ONLY_BY_NAMES = false;
                    return 1;
                } else if (gameRecord1.getLevel() > gameRecord2.getLevel()){
                    RECORDS_DIFFER_ONLY_BY_NAMES = false;
                    return -1;
                } else if (gameRecord1.getLevel() < gameRecord2.getLevel()){
                    RECORDS_DIFFER_ONLY_BY_NAMES = false;
                    return 1;
                } else {
                    //sort in alphabetical order by name if the score and level are have no differ
                    RECORDS_DIFFER_ONLY_BY_NAMES = true;
                    return (gameRecord1.getName().compareTo(gameRecord2.getName()));
                }
            }
        }
        GameRecord gameRecord = new GameRecord (name, level, score); 
        //array for construct the output of method
        GameRecord[] outputHighScoreRecords;
        //include first record if no records in the highScoreRecords
        if (highScoreRecords.length == 0){ 
            outputHighScoreRecords = new GameRecord[1];
            outputHighScoreRecords [0] = gameRecord;
            return outputHighScoreRecords;
        }
        //do not change the array, if such a record is already in the array
        if (Arrays.binarySearch (highScoreRecords, gameRecord, new GameRecordComparator()) >= 0) return highScoreRecords;
        //if the size of array less then his maximum size to copy highScoreRecords in output array, 
        //add new record and sort it
        if (highScoreRecords.length < HIGH_SCORE_RECORDS_ALL) {
            outputHighScoreRecords = Arrays.copyOf (highScoreRecords, highScoreRecords.length + 1);
            outputHighScoreRecords [highScoreRecords.length] = gameRecord;
            Arrays.sort (outputHighScoreRecords, new GameRecordComparator());
            return outputHighScoreRecords;
        } else {//this work if array with records has the maximum size
            outputHighScoreRecords = new GameRecord [HIGH_SCORE_RECORDS_ALL];
            GameRecordComparator gameRecordComparator = new GameRecordComparator ();
            //biasFlag will be point on that gameRecord do not insert yet output array
            int biasFlag = 0;
            for (int i = 0; i < HIGH_SCORE_RECORDS_ALL; i++){    
                if ((biasFlag == 0) && 
                    //conditions of order in array
                    (((gameRecordComparator.compare(gameRecord, highScoreRecords[i]) < 0) &&
                    (gameRecordComparator.RECORDS_DIFFER_ONLY_BY_NAMES == false)) ||
                    ((gameRecordComparator.compare(gameRecord, highScoreRecords[i]) > 0) &&
                    (gameRecordComparator.RECORDS_DIFFER_ONLY_BY_NAMES == true)))){
                    //insert the gameRecord
                    biasFlag = 1;
                    outputHighScoreRecords[i] = gameRecord;
                }
                //displace the remaining records
                try {
                    outputHighScoreRecords [i + biasFlag] = highScoreRecords[i];
                } catch (Exception e) {/*Do nothing*/}
            }
        }
        //control (but not a mandatory) sort
        Arrays.sort (outputHighScoreRecords, new GameRecordComparator());
        return outputHighScoreRecords;
    }   
}


