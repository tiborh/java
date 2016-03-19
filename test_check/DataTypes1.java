import java.util.*;
/**
 * Write a description of class DataTypes1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataTypes1
{

    /**
     * Constructor for objects of class DataTypes1
     */
    public DataTypes1()
    {
        // initialise instance variables
        
    }

    public static boolean[] logical_check(boolean[] arr)
    {
        boolean[] out_arr = new boolean[2];
        
        out_arr[0] = (arr[0] && arr[1]) || arr[2];
        out_arr[1] = !(arr[0] && (arr[1] || arr[2]));
        
        return out_arr;
    }
    
    public static boolean range_examine(int x)
    {
        boolean b = false;
        //b = 50 =< x && x =< 10; //<=
        b = 50 <= x || x <= 10;
        System.out.println("b: "+b);
        b = 50 < x || !(x > 9);
        System.out.println("b: "+b);
        //b = 51 ≤ x ≤ 9; //illegal character
        //b = 50 ≤ x && x ≤ 10; //same
        //b = 51 <= x <= 9; //bad operator type
        b = 50 < x || x < 10;
        System.out.println("b: "+b);
        //b = 50 < x < 10; //same
        return b;
    }
    
    public static String grade_check(int score)
    {
        String grade = new String();
        if (score >= 90) {
            grade = "A";
        }
        if (score >= 80 && score <= 89) {
            grade = "B";
        }
        if (score >= 70 && score <= 79) {
            grade = "C";
        }
        if (score >= 60 && score <= 69) {
            grade = "D";    
        }
        if (score < 60) {
            grade = "F";
        }
        return grade;
    }
    
    public static String grade_check2(int score)
    {
        String grade;
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";    
        } else {
            grade = "F";
        }
        return grade;
    }
    
    public static void main(String[] argv)
    {
        // put your code here
        {
            int a = 4;
            int b = 2;
            int c = a/b; //2
            String result = a+"/"+b+"="+c; 
            System.out.println (result);
        }
        {
            int a = 5;
            int b = 2;
            String c = "52";
            String result = a+"+"+b+"="+c;
            System.out.println (result);
        }
        
        {
            int n = 10;
            if (n % 5 == 0) {
                System.out.println(n);
            } else {
                System.out.println(n - 1);
            }
        }
        
        {
            int a = 9;
            System.out.println("examining: "+a);
            range_examine(a);
            a = 10;
            System.out.println("examining: "+a);
            range_examine(a);
            a = 25;
            System.out.println("examining: "+a);
            range_examine(a);
            a = 50;
            System.out.println("examining: "+a);
            range_examine(a);
            a = 51;
            System.out.println("examining: "+a);
            range_examine(a);
        }
        
        {
            List<boolean[]> rowList = new ArrayList<boolean[]>();
            
            rowList.add(new boolean[] { false, false, false });
            rowList.add(new boolean[] { false, false, true });
            rowList.add(new boolean[] { false, true, false });
            rowList.add(new boolean[] { false, true, true });
            rowList.add(new boolean[] { true, false, false });
            rowList.add(new boolean[] { true, false, true });
            rowList.add(new boolean[] { true, true, false });
            rowList.add(new boolean[] { true, true, true });
            
            for (boolean[] row : rowList) {
                System.out.print("Row = " + Arrays.toString(row));
                System.out.println(" result: " + Arrays.toString(logical_check(row)));
            }
        }
        
        {
            int[] scores = {91,90,89,81,80,79,71,70,69,61,60,59};
            
            for (int a_score : scores)
            {
                System.out.println("Score: " + a_score + " grade 1: " + grade_check(a_score) + " grade 2: " + grade_check2(a_score));
            }
        }
        
        {
            int p = 1;
            int q = 2;
            int r = 3;
            if (r > p + q) {
                r = 2 * p;
            }
            else if (r < p + q) {
                r = 2 * q;
            }
            else {
                q = 2 * r;
            }
            System.out.println("The value of r: " + r + " q: " + q);
        }
        
        {
             String a = "This is a String.";
             String b = "This is another String.";
             String c = "Another String this is."; 
            {
                if (b.length() > c.length()) {
                    System.out.println(b);
                } else if (c.length() > b.length()) {
                    System.out.println(c);
                } else {
                    System.out.println(b.charAt(0) + "" + c.charAt(0));
                }
            }
            {
                if (a.length() > b.length()) {
                    System.out.println(a);
                } else if (b.length() > a.length()) {
                    System.out.println(b);
                } else {
                    System.out.println(a + b);
                }
            }
        }
    }
}
