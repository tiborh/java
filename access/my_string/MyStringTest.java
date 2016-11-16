package my_string;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MyStringTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyStringTest
{
    MyString ms1;
    MyString ms2;
    int ms1Length;
    int ms1FirstChar;
    int ms1LastChar;
    int ms2MidChar;
    MyString ms1FirstHalf;
    MyString ms1SecondHalf;
    MyString ms2MidPart;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        ms1 = MyString.valueOf(true);
        ms2 = MyString.valueOf(false);
        ms1Length = ms1.length();
        ms1FirstChar = ms1.charAt(0);
        ms1LastChar = ms1.charAt(3);
        ms2MidChar = ms2.charAt(2);
        ms1FirstHalf = ms1.substring(0, 2);
        ms1SecondHalf = ms1.substring(2, 4);
        ms2MidPart = ms2.substring(1, 4);
    }

    @Test
    public void valueOfTests() {
        assertEquals("ms1 should give the string \"true\"",ms1.toString(),"true");
        assertEquals("ms2 should give the string \"false\"",ms2.toString(),"false");
    }
    
    @Test
    public void charAtTests() {
        assertEquals("ms1FistChar should be 't'",ms1FirstChar,'t');
        assertEquals("ms1LastChar should be 'e'",ms1LastChar,'e');
        assertEquals("ms2MidChar should be 'l'",ms2MidChar,'l');
    }
    
    @Test
    public void subStringTests() {
        assertEquals("ms1.substrint(0,1) should give the string \"tr\"",
            ms1FirstHalf.toString(),"tr");
        assertEquals("ms1.substrint(2,3) should give the string \"ue\"",
            ms1SecondHalf.toString(),"ue");
        assertEquals("ms2.substrint(1,3) should give the string \"als\"",
            ms2MidPart.toString(),"als");
        assertEquals("ms2.substrint(2,2) should give the string \"l\"",
            ms2.substring(2,3).toString(),"l");        
    }
    
    @Test
    public void lengthTests() {
        
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
