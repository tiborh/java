import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class FinalExamPractice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalExamPractice
{
    static String b = "hello";

    public static boolean leap(int y) {
        String tmp = String.valueOf(y);
        if (tmp.charAt(2) == '1' || tmp.charAt(2) == '3' || tmp.charAt(2) == 5
        || tmp.charAt(2) == '7' || tmp.charAt(2) == '9') {
            if (tmp.charAt(3)=='2'||tmp.charAt(3)=='6') {
                System.out.println("R1: true");
                return true; /*R1*/
            } else {
                System.out.println("R2: false");
                return false; /*R2*/
            }
        }else{
            if (tmp.charAt(2) == '0' && tmp.charAt(3) == '0') {
                System.out.println("R3: false");
                return false; /*R3*/
            }
            if (tmp.charAt(3)=='0'||tmp.charAt(3)=='4'||tmp.charAt(3)=='8') {
                System.out.println("R4: true");
                return true; /*R4*/
            }
        }
        System.out.println("R5: false");
        return false; /*R5*/
    }

    public static void finalTest() 
    {
        char vowel0 = 'a';
        final char vowel1 = vowel0;

        String vowel2 = vowel1 + "eiou";
        final String vowel3 = vowel2;

        char[] vowel4 = new char[] { vowel0, 'e', 'i', 'o', 'u' };
        final char[] vowel5 = vowel4;

        vowel0 = vowel1;
        //vowel1 = vowel0;
        vowel2 = vowel3;
        //vowel3 = vowel2;
        //vowel2[0] = 'x';
        //vowel3[0] = 'x';
        vowel4 = vowel5;
        //vowel5 = vowel4;
        vowel4[0] = 'x';
        vowel5[0] = 'x' ;
    }

    public static void finalTest2() {
        String a = "hello";
        final String c = a;
        final String d = b;
        a = "bye";
        b = "bye-bye";
        //c = "bye";
        //d = "bye";
    }

    public static void listMutation() {
        String x = "hello";
        final List<String> y = new ArrayList<>();
        y.add("one");
        final List<String> z = Collections.unmodifiableList(y);
        System.out.println(z);
        y.add("two");
        System.out.println(z);
    }

    public static void main(String[] argv) {
        // wrong answer, no error
        double oneThird = 1/3;
        System.out.println("oneThird: " + oneThird);

        int sum = 0;
        int n = 0;

        List<List<Integer>> a;
        String[] b;
        ArrayList<String> c;
    }
}
