import comp102x.IO;

/**
 * Write a description of class hello here.
 * 
 * @author (your name) 
 * @version (a version number o a date)
 */

public class cs101_grade
{
    /*
     * Variable declaration
     */
    private static final int exam_weight = 70;  // in percentage
    private static final int lab_weight = 20;
    private static final int hw_weight = 10;
    private double exam_score = 75;     // in percentage
    private double lab_score = 50;
    private double hw_score = 25;
    private double final_grade;
    private String student_name = "Joe Doe";

    public cs101_grade() {}
    
    public cs101_grade(String name) {
        student_name = name;
    }

    public void main()
    {
        get_scores();
        set_final_grade();
        output_result();
    }

    public void get_scores() {
        System.out.print("Enter your exam grade: ");
        exam_score = IO.inputDouble();
        System.out.print("Enter your lab grade: ");
        lab_score = IO.inputDouble();
        System.out.print("Enter your homework grade: ");
        hw_score = IO.inputDouble();
    }
    
    public double compute_grade(double exam_score, double lab_score, double hw_score) {
        exam_score = exam_score * (exam_weight / 100.0);
        lab_score = lab_score * (lab_weight / 100.0);
        hw_score = hw_score * (hw_weight / 100.0);
        
        return exam_score + lab_score + hw_score;
    }

    public void set_final_grade() {
        final_grade = compute_grade(exam_score, lab_score, hw_score);
    }

    public void output_result() {
        System.out.println("For " + student_name + 
                           ": exam score = " + exam_score + 
                           " lab score = " + lab_score + 
                           " homework score = " + hw_score +
                           " final grade = " + final_grade);
    }
}
