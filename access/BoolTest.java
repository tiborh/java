

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

/**
 * The test class BoolTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BoolTest
{
    Bool a;
    Bool b;
    Bool c;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        a = new Bool(true);
        b = new Bool();
        c = new Bool(false);
    }

    @Test
    public void testValuesOfCreatedObjects()
    {
        //Constructor test
        assertTrue("'a' should be true",a.isTrue());
        assertFalse("'b' should be false",b.isTrue());
        assertFalse("'c' should be false",c.isTrue());
    }
    
    @Test
    public void testNot()
    {
        assertFalse("'not a' should be false",a.not().isTrue());
        assertTrue("'not b' should be true",b.not().isTrue());
    }
    
    @Test
    public void testOr()
    {
        assertTrue("'a or b' should be true",a.or(b).isTrue());
        assertFalse("'b or c' should be false",b.or(c).isTrue());
        assertEquals("'a or b' should be true",a.or(b),new Bool(true));
    }
    
    @Test
    public void testAnd()
    {
        //Constructor test
        assertFalse("'a and b' should be false",a.and(b).isTrue());
        assertTrue("'a and not b' should be true",a.and(b.not()).isTrue());
    }
    
    @Test
    public void testEquality()
    {
        Bool d = null;
        Bool e = null;
        assertEquals("d should be equal to e",d,e);
        assertEquals("a should be equal to itself",a,a);
        assertEquals("b should be equal to itself",b,b);
        assertEquals("b should be equal to c",b,c);
        assertThat("a should not be equal to b",a,not(equalTo(b)));
        assertThat("b should not be equal to a",b,not(equalTo(a)));
        assertThat("c should not be equal to d",c,not(equalTo(d)));
        assertThat("d should not be equal to c",d,not(equalTo(c)));
    }
    
    @Test
    public void cloneTest()
    {
        Bool d = a.clone();
        Bool e = b.clone();
        assertTrue("d should be true",d.isTrue());
        assertFalse("e should be false",e.isTrue());
        assertFalse("a and d should not be aliases of the same object",a == d);
        Bool f = new Bool(a);
        assertTrue("f should be true",f.isTrue());
        assertFalse("a and f should not be aliases of the same object",a == f);
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
