package supergrid;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareGridTest
{

    SquareGrid sq = null;
    int size = 2;

    @Before
    public void setUp() throws Exception
    {
      size += 2;
      sq = new SquareGrid(size);
    }

    @Test
    public final void testDisplayZoneNE()
    {
        assertTrue(sq.displayZone(size-1, size-1).equals("NE"));
    }
    
    @Test
    public final void testDisplayZoneNW()
    {
        assertTrue(sq.displayZone(size-(size/2+1), size-1).equals("NW"));
    }
    
    @Test
    public final void testDisplayZoneSE()
    {
        assertTrue(sq.displayZone(size-1, size-(size/2+1)).equals("SE"));
    }
    
    @Test
    public final void testDisplayZoneSW()
    {
        assertTrue(sq.displayZone(size-(size/2+1), size-(size/2+1)).equals("SW"));
    }
    
    @Test
    public final void testDisplayZoneCenter()
    {
        assertTrue(sq.displayZone(size-(size/2), size-(size/2)).equals("SW"));
    }
}
