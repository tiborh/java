import comp102x.IO;

/**
 * Write a description of class hello here.
 * 
 * @author (your name) 
 * @version (a version number o a date)
 */

public class course_grade
{
    public static void main(String[] args)
    {
        /*
         * Variable declaration
         */
              final int examWeight = 70;  // in percentage
              final int labWeight = 20;
              final int hwWeight = 10;
              double examScore;     // in percentage
              double labScore;
              double hwScore;
              double finalGrade;
              
        /*
         * Main part
         */
        // Ask student to input scores for exam. Lab and homework
        IO.output("Enter your exam grade: ");
        examScore = IO.inputDouble();
        IO.output("Enter your lab grade: ");
        labScore = IO.inputDouble();
        IO.output("Enter your homework grade: ");
        hwScore = IO.inputDouble();
        
        // Compute final grade as the weighted sum of exam, lab, and homework scores
        examScore = examScore * (examWeight / 100.0);
        labScore = labScore * (labWeight / 100.0);
        hwScore = hwScore * (hwWeight / 100.0);
        finalGrade = examScore + labScore + hwScore;
        
        // Output the final grade
        IO.outputln("Your final grade is " + finalGrade);
        
    }


}
