package generic_functional_interface;

/**
 * To illustrate the use of anonymous classes in interpreting the functional interface
 * 
 * @author Pierre-Yves Saumont
 * @version 0.1
 */
public class Main
{
    public static Function<Integer,Integer> triple = new Function<Integer,Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg * 3;
        }
    };
    public static Function<Integer,Integer> square = new Function<Integer,Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg * arg;
        }
    };

    public static Function<Integer,Integer> compose(final Function<Integer,Integer> f1, final Function<Integer,Integer> f2) {
        return new Function<Integer,Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return f1.apply(f2.apply(arg));
            }
        };
    }
          
    public static void main(String[] argv) {
        System.out.println("triple test:\n\ttriple.apply(2) == " + triple.apply(2));
        System.out.println("square test:\n\tsquare.apply(3) == " + square.apply(3));
        System.out.println("Traditional composition:\n\tsquare.apply(triple.apply(2)) == " + square.apply(triple.apply(2)) );        
        System.out.println("Closure style composition:\n\tcompose(triple, square).apply(3) == " + compose(triple, square).apply(3));
        System.out.println("\tcompose(square, triple).apply(3) == " + compose(square, triple).apply(3));
    }
}
