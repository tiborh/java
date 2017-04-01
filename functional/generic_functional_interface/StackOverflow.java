package generic_functional_interface;


/**
 * A lot of functions will result in stack overflow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackOverflow
{
    public static Function<Integer,Integer> stackOverflow(int fnum) {
        //int fnum = 10_000; 
        Function<Integer, Integer> g = x -> x;
        Function<Integer, Integer> f = x -> x + 1;
        for (int i = 0; i < fnum; i++) {
            g = Main.compose(f, g);
        };
        return g;
    }
    
    public static void main(String[] argv) {
        Function<Integer,Integer> sof = stackOverflow(10_000);
        System.out.println("Stack overflow:");
        System.out.println(sof.apply(0));
    }
}
