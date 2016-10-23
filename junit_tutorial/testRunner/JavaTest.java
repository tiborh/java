package testRunner;

import junit.framework.*;
import org.junit.Before;
import org.junit.Test;

public class JavaTest extends TestCase {
    protected int value1, value2;

    @Before
    protected void setUp(){
        value1 = 3;
        value2 = 3;
    }

    @Test
    public void testAdd(){
        double result = value1 + value2;
        assertTrue(result == 6);
    }
}