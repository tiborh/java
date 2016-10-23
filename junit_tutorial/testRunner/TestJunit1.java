package testRunner;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestJunit1 {
    protected int num;
    protected String temp;
    protected String str;
    
    @Before
    public void setUp() {
        num = 5;
        temp = null;
        str = "Junit is working fine";
    }

    @Test
    public void checkNumber() {
        //check for false condition
        assertFalse(num > 6);    
    }
    
    @Test
    public void checkString() {
        //check for not null value
        assertNotNull(str);        
    }
    
    @Test
    public void checkNullString() {
        //check for not null value
        assertNull(temp);        
    }
    
    @Test
    public void testAdd() {
        //check for equality
        assertEquals("Junit is working fine", str);
    }
}