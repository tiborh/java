package Arrays;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Array2DTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Array2DTest
{
    private Array2D a1;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        a1 = new Array2D();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testFillFirstLastVals()
    {
        a1.fill(3);
        assertEquals(a1.get(0,0),3,0);
        assertEquals(a1.get(a1.getFirst()-1,a1.getSecond()-1),3,0);
    }
        
    @Test
    public void testFillSquare()
    {
        int testsize = 3;
        int testvalue = testsize;
        a1 = new Array2D(testsize);
        a1.fill(testvalue);
        int[][] A1 = a1.get();
        int[][] A2 = new int[testsize][testsize];
        for (int i = 0; i < testsize; ++i)
            for( int j = 0; j < testsize; ++j)
                A2[i][j] = testvalue;
        assertArrayEquals("failure - arrays are not the same", A2, A1);
    }
    
    @Test
    public void testFillRectangle()
    {
        int testvalue = 3;
        int myf = a1.getFirst();
        int mys = a1.getSecond();
        a1.fill(testvalue);
        int[][] A1 = a1.get();
        int[][] A2 = new int[myf][mys];
        for (int i = 0; i < myf; ++i)
            for( int j = 0; j < mys; ++j)
                A2[i][j] = testvalue;
        assertArrayEquals("failure - arrays are not the same", A2, A1);
    }
    
    @Test
    public void testFillWithArray()
    {
        int fillVal = 0;
        int myf = a1.getFirst();
        int mys = a1.getSecond();

        int[][] fillArr = new int[myf][mys];
        for (int i = 0; i < myf; ++i)
            for( int j = 0; j < mys; ++j)
                fillArr[i][j] = fillVal++;
        
        a1.fill(fillArr);
        int[][] A1 = a1.get();

        assertArrayEquals("failure - arrays are not the same", fillArr, A1);
    }
}
