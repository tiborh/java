import comp102x.IO;
/**
 * Power program
 * 
 * @author Tibor 
 * @version 0.01
 */
public class power
{
    // instance variables - replace the example below with your own
    private int base;
    private int power;
    private long product;

    public static void main(String[] args)
    {
        power sample = new power();
        //sample.print_product();
    }
    
    /**
     * Constructor for objects of class power
     */
    public power()
    {
        // initialise instance variables
        filler();
    }

    private int fill_n(String ask)
    {
        System.out.print(ask + ": ");
        return IO.inputInteger();
    }

    private void filler()
    {
        base = fill_n("base");
        power = fill_n("power");
        product = power(base,power);
        print_product();
    }
    
    private long power(int inNumber, int inPower)
    {
        if (inPower <= 0)
            return 1;
        else if (inPower == 1)
            return inNumber;
        else
            return inNumber * power(inNumber,inPower-1);
    }
    
    public void new_power()
    {
        filler();
    }
    
    private void print_product()
    {
        System.out.println("product: " + product);
    }
}
