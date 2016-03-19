public class ifelse
{
    public ifelse(int x, int y, int z) {
        if(z < y)
            if(x > y)
                x = 10;
            else
                x = 3;
        
        System.out.println("x = " + x);
    }
    public static void main(String[] args)
    {
        //i)   x = 8,    y = 4,    z = 2
        int x = 8,    y = 4,    z = 2;
        ifelse test_set1 = new ifelse(x,y,z);
        
        //ii)  x = 2,    y = 4,    z = 8
        x = 2;    z = 8;
        ifelse test_set2 = new ifelse(x,y,z);
        
        //iii) x = 2,    y = 8,    z = 4
        y = 8; z = 4;
        ifelse test_set3 = new ifelse(x,y,z);
         
    }
}
