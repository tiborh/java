package math;

public class sqrt
{
    private double root;

    /**
     * @param num is an integer number greater than 0 
     * @precondition num > 0
     * @postcondition root >= num
     */
    sqrt(int num)
    {
        root = Math.sqrt(new Integer(num).doubleValue());
        
    }

    public double getRoot() { return root; }
    
    public static void main(String[] argv)
    {
        if (argv.length == 0)
        {
            sqrt a = new sqrt(4);
            System.out.println(a.getRoot());
        } else {
            for(String aNum: argv)
            {
                sqrt a = new sqrt(Integer.parseInt(aNum));
                System.out.println(a.getRoot());
            }
        }
    }
}
