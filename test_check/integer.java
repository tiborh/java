
public class integer
{
    public static void main (String[] args)
    {
        Integer i1 = new Integer(2);
        Integer i2 = new Integer("2");
        //Integer i3 = new Integer(2.0); // No suitable constructor: only int and string are allowed.
        
        System.out.println("i1: " + i1);
        System.out.println("i2: " + i2);
        //System.out.println("i3: " + i3);
        
        Integer i4 = new Integer(2);
        System.out.println(i4.intValue() + ", " + i4.longValue() + ", " + i4.doubleValue());
        
        System.out.println("Integer.SIZE: " + Integer.SIZE + ", Float.SIZE: " + Float.SIZE + 
            ", Long SIZE:" + Long.SIZE + ", " + "Double Size: " + Double.SIZE);

    }
}
