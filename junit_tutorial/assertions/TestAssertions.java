package assertions;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class TestAssertions {
    //test data
    protected static String str1;
    protected static String str2;
    protected static String str3;
    protected static String str4;
    protected static String str5;
    protected static int val1;
    protected static int val2;
    protected static String[] expectedArray;
    protected static String[] resultArray;
    
    // Before: before each test case. BeforeClass: before tests start.
    @BeforeClass
    public static void setUp() {
        //test data
        str1 = new String ("abc");
        str2 = new String ("abc");
        str3 = null;
        str4 = "abc";
        str5 = "abc";

        val1 = 5;
        val2 = 6;

        expectedArray = new String[] {"one", "two", "three"};
        resultArray =  new String[] {"one", "two", "three"};
    }

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testEquality() {
        //Check that two objects are equal
        assertEquals(str1, str2);
    }

    @Test
    public void testTrue() {
        //Check that a condition is true
        assertTrue (val1 < val2);
    }

    @Test
    public void testFalse() {
        //Check that a condition is false
        assertFalse(val1 > val2);
    }

    @Test
    public void testNotNull() {
        //Check that an object isn't null
        assertNotNull(str1);
    }

    @Test
    public void testNull() {
        //Check that an object is null
        assertNull(str3);
    }

    @Test
    public void testSameness() {
        //Check if two object references point to the same object
        assertSame(str4,str5);
    }

    @Test
    public void testDifference() {
        //Check if two object references not point to the same object
        assertNotSame(str1,str3);
    }
    
    @Test
    public void testArrayEquality() {
        //Check whether two arrays are equal to each other.
        assertArrayEquals(expectedArray, resultArray);
    }
    
    @Ignore
    public void testFail() {
        // not yet knowing how to handle
        fail();
    }
}