package testRunner;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * source: https://www.tutorialspoint.com/junit/junit_environment_setup.htm
 * @author tutorialspoint.com
 */
public class TestJUnit {

    /**
    * basic test of JUnit
    * @return AssertionError.class
    */
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    /**
     * string equality check
     */
    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }
}