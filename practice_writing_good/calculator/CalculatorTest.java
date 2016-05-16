package calculator;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalculatorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalculatorTest
{
    Calculator calc = null;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        int savedVal = calc.getResult();
        int summand = 2;
        calc.add(summand);
        assertEquals(summand,savedVal+summand,0);
    }

    @Test
    public void testSubtract() {
        int savedVal = calc.getResult();
        int subtrahend = 1;
        calc.subtract(subtrahend);
        assertTrue(calc.getResult()==savedVal-subtrahend);
    }
}
