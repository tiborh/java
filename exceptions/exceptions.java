
/**
 * to show and test various exceptions
 * 
 * @author tibor
 * @version 0.01
 * @since 2015-06-05
 */
public class exceptions
{
    public void arithmetic()
    {
        try 
        {
            int a = 7 / 0;
        }
        catch (ArithmeticException e)
        {
            System.out.println(e);
        }
    }

    public void array()
    {
        int[] a = {1,2,3,4,5,6,7};
        try 
        {
            for (int i = 0; i <= a.length; ++i)
                System.out.print("a[" + i + "]: " + a[i] + ",\n");
            System.out.println();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
    }

    public void number()
    {
        try
        {
            String s = "FOOBAR";
            int i = Integer.parseInt(s);
            // this line of code will never be reached
            System.out.println("int value = " + i);
        }
        catch (NumberFormatException e)
        {
            System.out.println(e);
            //nfe.printStackTrace();
        }
    }
    
    public void nullpointer()
    {
        try
        {
            Integer num;
            num = null;
            int a = 4 / num;
        }
        catch (NullPointerException e)
        {
            System.out.println(e);
        }
    }
    
    public void classcast()
    {
        try
        {
            Object x = new Integer(0);
            System.out.println((String)x);
        }
        catch (ClassCastException e)
        {
            System.out.println(e);
        }
    }
    
    private void illegal_state(String s) throws IllegalStateException
    {
        if (s == null)
            throw new IllegalStateException("input is null");
        System.out.println(s);
    }
    
    public void illstate()
    {
        try
        {
            illegal_state(null);
        }
        catch (IllegalStateException e)
        {
            System.out.println(e);
        }
    }

    private void illegal_argument(int i) throws IllegalArgumentException
    {
        if (i == 0)
            throw new IllegalArgumentException("input is 0");
        System.out.println(i);
    }
    
    public void illarg()
    {
        try
        {
            illegal_argument(0);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
    
}
