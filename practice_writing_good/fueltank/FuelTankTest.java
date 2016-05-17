package fueltank;

/**
 * Tests for class FuelTank.
 * 
 * All tests in the folder "test" are executed 
 * when the "Test" action is invoked.
 * 
 */

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class FuelTankTest
{
    private FuelTank ft;
    private int capacity;
    private int initial;
                
    @Before
    public void setUp() throws Exception {
        capacity = 40;
        initial = 0;
        ft = new FuelTank(capacity,initial);
    }
         
    @Test
    public void testGetTankLevel()
    {
        assertEquals(initial,ft.getTankLevel(),0);
        double testVal = 12;
        ft.fill(testVal);
        assertEquals(testVal,ft.getTankLevel(),0);
    }
    
    @Test
    public void testGetTankMax()
    {
        assertEquals(capacity,ft.getTankMax(),0);
    }
    
    @Test
    public void testCapacity()
    {
        assertEquals(ft.getCapacity(),ft.getTankMax(),0);
    }
        
    @Test
    public void testEmpty()
    {
        assertTrue(ft.empty());
        ft.fill(1);
        assertFalse(ft.empty());
    }
    
    @Test
    public void testHalfFullTank()
    {
        ft.fill(ft.getTankMax()/2);
        assertEquals(ft.getTankMax()/2,ft.getTankLevel(),0);
    }
    
    @Test
    public void testFullTank() {
        assertFalse(ft.full());
    }
 
    @Test
    public void testConsume()
    {
        double half = ft.getTankMax()/2;
        ft.fill(ft.getTankMax());
        ft.consume(half);
        assertEquals(ft.getTankLevel(),half,0);        
    }
    
    @Test
    public void testFillUp()
    {
        double savedLevel = ft.getTankLevel();
        double filledAmount = ft.fill();
        assertEquals(savedLevel + filledAmount,ft.getTankMax(),0);
        assertEquals(ft.fill(),0.0,0);
    }
    
    @Test
    public void testClone()
    {
        FuelTank ftclone = ft.clone();
        double ta = 2.0;
        ftclone.fill(ta);
        assertEquals(ft.getTankLevel()+ta,ftclone.getTankLevel(),0.0);
    }
        
    @Test
    public void firstFuelTestRecord()
    {
    }
}


