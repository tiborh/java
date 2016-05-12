package exam1;

/**
 * Write a description of class debugTask here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class debugTask
{
    public static int generate(int x)
    {
        System.out.print(x % 10);
        if ((x / 10) != 0) {
            generate(x / 10);
        }
        return x;
    }

    public static void main(String[] args){
        System.out.println(generate(523));
    }
}
