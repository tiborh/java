import java.util.List;
/**
 * common functions
 * 
 * @author tibor
 * @version 0.0.1
 */
public class Common
{
    public static void printList(List<Long> inList)
    {
        if (inList.size() != 0)
            for (long an_item : inList)
                System.out.print(an_item + " ");
        else
            System.out.printf("List is empty.");
        System.out.println();
    }

    
}
