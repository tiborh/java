
/**
 * Simplest lambda expressions
 * 1. Create a Functional Interface
 * 2. Implement the functional inteface in a method
 * 3. Define the lambda expression
 * 4. Instantiate the class
 * 5. Use the implemented functional interface methods
 * 
 * @author tibor
 * @version 0.1
 */
public class SimpleLambda
{
    interface MathUnary {
        int operation(int a);   
    }
    
    interface MathBinary {
        int operation(int a, int b);
    }
    
    private int operate(int a, MathUnary mOpt){
        return mOpt.operation(a);
    }

    private int operate(int a, int b, MathBinary mOpt){
        return mOpt.operation(a,b);
    }

    /**
     * everything is done in main, args are not used
     */
    public static void main(String[] argv)
    {
        SimpleLambda tester = new SimpleLambda();
        MathUnary sq = x -> x * x;
        MathBinary times = (x,y) -> x * y;
        int a = 3;
        System.out.println(a + " squared is " + tester.operate(a,sq));
        int b = 4;
        System.out.println(a + " times " + b + " is " + tester.operate(a,b,times));
        System.out.println(a + " squared twice is " + tester.operate(tester.operate(a,sq),sq));
    }
}
