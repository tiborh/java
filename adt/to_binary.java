import java.util.Stack;
import java.util.Random;
/**
 * to illustrate the usage of Abstract Data Type (ADT) Stack
 * 
 * @author Hong Kong University (modified by tibor)
 * @version 0.1
 */
public class to_binary
{
    private Stack<Integer> s = new Stack<Integer>();
    private Random rand_gen = new Random();
    private int input_number = 0;
    private int rand_upper_limit = 16;
    
    /**
     * Constructs a "to-binary" converter
     * 
     * @param a_num number to convert
     */
    public to_binary(int a_num)
    {
        set_input_number(a_num);
    }

    /**
     * Constructs a "to-binary" converter, initialising it to random number
     */
    public to_binary()
    {        
        set_random_input_number();
    }

    public void set_random_upper_limit(int new_limit)
    {
        rand_upper_limit = new_limit;
    }
    
    public void set_input_number(int new_number)
    {
        input_number = new_number;
    }
    
    public void set_random_input_number(int new_limit)
    {
        set_random_upper_limit(new_limit);
        set_random_input_number();
    }
    
    public void set_random_input_number()
    {
        input_number = rand_gen.nextInt(rand_upper_limit) + 1;
    }

    /**
     * Prepares the stack from input_number
     */
    private void prepare_stack()
    {
        int num = input_number;
        while (num > 0)
        {
            int a_bit = num % 2;
            //s.push(Integer.valueOf(a_bit));
            //simplifiable to (because of autoboxing):
            s.push(a_bit);
            num /= 2;
        }        
    }
    
    /**
     * gets prepare_stack() to do the conversion and prints the stack content
     */
    public void print_binary()
    {
        prepare_stack();
        while (!s.empty())
        {
            //int a_bit = s.pop().intValue();
            //Simplifiable to (because of unboxing):
            int a_bit = s.pop();
            System.out.print(a_bit);
        }
        System.out.println();
    }
}
