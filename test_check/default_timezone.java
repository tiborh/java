import java.util.*;

public class default_timezone
{
    public static void main(String[] args)
    {
        TimeZone dtz = TimeZone.getDefault();
        //String[] ids = dtz.getAvailableIDs();
        //for(int i = 0; i < ids.length; ++i)
        //    System.out.println(ids[i]);
        System.out.println(dtz.getDisplayName());
        System.out.println(dtz.getDisplayName(true,TimeZone.LONG));
        System.out.println(dtz.getDisplayName(true,TimeZone.SHORT));
        System.out.println(dtz.getID());
    }
}
