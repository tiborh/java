package ps1;

import java.util.Set;
import java.util.HashSet;
import java.lang.ArithmeticException;


public class Quadratic {

    /**
     * Find the integer roots of a quadratic equation, ax^2 + bx + c = 0.
     * @param a coefficient of x^2
     * @param b coefficient of x
     * @param c constant term.  Requires that a, b, and c are not ALL zero.
     * @return all integers x such that ax^2 + bx + c = 0.
     */
    public static Set<Integer> roots(long a, long b, long c){
        //System.out.println("Input: " + a + ", " + b + ", " + c);
        assert(!(a == 0 && b == 0 && c == 0));
        Set<Integer> resultSet = new HashSet<Integer>();

        if (a == 0) {
            int x = (int)(-c/b);
            resultSet.add(x);
        } else {
            long underRoot = b*b - 4*a*c;
            if (underRoot < 0)
                return resultSet;
            long divisor = 2*a;
            double x1real = (-b + Math.sqrt(underRoot)) / divisor;
            double x2real = (-b - Math.sqrt(underRoot)) / divisor;
            if ((x1real < 1.0 && x2real < 1.0) && (x1real > 0.0 && x2real > 0.0))
                return resultSet;
            int x1 = (int)x1real;
            int x2 = (int)x2real;
            resultSet.add(x1);
            resultSet.add(x2);
        }
        //throw new RuntimeException("not implemented yet;");
        return resultSet;
    }

    /**
     * Main function of program.
     * @param args command-line arguments
     */
    public static void main(String[] args){
        System.out.println("For the equation x^2 - 4x + 3 = 0, the possible solutions are:");
        Set<Integer> result = roots(1, -4, 3);
        System.out.println(result);
        
        int r1 =  45_000; // a root ~45,000 means c is ~2,000,000,000, which is close to the maximum integer 2^31 - 1
        int r2 = -45_000;
        System.out.println(Quadratic.roots(1, -r1-r2, r1*r2));
        
        System.out.println(Quadratic.roots(0, -5, 15));
        System.out.println(Quadratic.roots(6, -5, 1));
        System.out.println(Quadratic.roots(1, -2, 2));
    }
}
