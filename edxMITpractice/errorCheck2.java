
/**
 * Write a description of class errorCheck2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class errorCheck2
{
    public static void main(String[] argv)
    {
        int big = 200000; // 200,000
        big *= big;  // big should be 4 billion now
        System.out.println(big);
        long bigger = 200000;
        bigger *= bigger;
        System.out.println(bigger);
        double probability = 1/5; // integer division
        System.out.println(probability); 
        double prob2 = 1.0/5;
        System.out.println(prob2);
        double sum = 7;
        double n = 0;
        double average = sum/n;
        System.out.println(average);
    }
}
