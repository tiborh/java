package factorial;

/**
 * Write a description of class factorial3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class factorial3
{
    static int factorial(int number) {
        if(number <= 1) {
            return 1;
        }
        return number * factorial(number-1); 
    }

    public static void main(String[] args) {
        System.out.println("4: "+factorial(4));
        System.out.println("3: "+factorial(3));
        System.out.println("2: "+factorial(2));
        System.out.println("1: "+factorial(1));        
    }

}
