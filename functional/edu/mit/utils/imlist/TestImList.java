package edu.mit.utils.imlist;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestImList.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestImList
{
    private ImList<Integer> nil;
    private ImList<Integer> x;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        nil = ImList.empty();
        x = nil.cons(2).cons(1).cons(0);  // [0,1,2]
    }

    @Test
    public void testEmpty()
    {
        assertTrue(nil.isEmpty());
        assertFalse(nil.contains(0));
        assertEquals(0,nil.size());
    }
    
    @Test
    public void testZero()
    {
        ImList<Integer> zero = nil.cons(0);     // [0]
        assertFalse(zero.isEmpty());
        assertTrue(zero.contains(0));
        assertTrue(0==zero.get(0));
        assertEquals(1,zero.size());
    }
    
    @Test
    public void testThreeMembers()
    {
        assertEquals(3,x.size());
        assertTrue(x.contains(1));
        assertTrue(2==x.get(2));
        assertTrue(0==x.first());
        assertTrue(1==x.rest().first());
        assertTrue(2==x.rest().rest().first());
        assertTrue(2==x.rest().rest().first());
    }
    
    @Test
    public void testContains()
    {
        ImList<Integer> y = x.rest().cons(4);
        assertEquals(3,y.size());
        assertTrue(y.contains(4));
        assertTrue(y.contains(2));
        assertFalse(y.contains(3));
    }
    
    @Test
    public void testGet()
    {
        assertEquals((int)0,(int)x.get(0));
        assertEquals((int)1,(int)x.get(1));
        assertEquals((int)2,(int)x.get(2));
    }
    
    @Test
    public void testAppend()
    {
        ImList<Integer> y = x.rest().cons(4);
        ImList<Integer> z = x.append(y);
        assertEquals(6,z.size());
        assertEquals((int)4,(int)z.get(3));
        assertEquals((int)2,(int)z.get(5));
    }
    
    @Test
    public void testReverse()
    {
        ImList<Integer> y = x.reverse();
        assertEquals((int)2,(int)y.get(0));
        assertEquals((int)1,(int)y.get(1));
        assertEquals((int)0,(int)y.get(2));
    }
    
    @Test
    public void testStringList()
    {
        ImList<Object> airports = 
            ImList.empty().cons("SFO").cons("IAD").cons("BOS");
        assertEquals(3,airports.size());
        assertTrue(airports.contains("SFO"));
        assertTrue(airports.contains("BOS"));
        assertEquals("SFO",airports.get(2));
        assertEquals("BOS",airports.get(0));
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
}
