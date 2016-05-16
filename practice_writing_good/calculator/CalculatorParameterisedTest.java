package calculator;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorParameterisedTest
{
    Calculator calc = null;
    private int param;
    private int result;

    @Parameters
    public static Collection<Object[]> squareNumbers() {
        Object[][] numbers = new Object[][] {{2,4}, {3,9}, {4,16}};
        return Arrays.asList(numbers);
    }

    public CalculatorParameterisedTest(int param, int result) {
        this.param = param;
        this.result = result;
    }

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
        result = 0;
    }

    @Test
    public void testSquare() {
        calc.square(this.param);
        assertEquals(this.result, calc.getResult(), 0);
    }
}
