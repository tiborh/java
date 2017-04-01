package functional_interface;

/**
 * To illustrate the use of anonymous classes in interpreting the functional interface
 * 
 * @author Pierre-Yves Saumont
 * @version 0.1
 */
public class Main
{
    public static Function triple = new Function() {
        @Override
        public int apply(int arg) {
            return arg * 3;
        }
    };
    public static Function square = new Function() {
        @Override
        public int apply(int arg) {
            return arg * arg;
        }
    };

    public static Function compose(final Function f1, final Function f2) {
        return new Function() {
            @Override
            public int apply(int arg) {
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
