package exposure;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * The test class of RightTriangle2.
 *
 * @author  tibor
 * @version 0.01
 */
public class RightTriangle2Test
{
    double a;
    double b;
    double c;
    double[] sides;
    RightTriangle2 A;
    RightTriangle2 B;
    RightTriangle2 C;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */    
    @Before
    public void setUp()
    {
        a = 3.0;
        b = 4.0;
        c = 5.0;
        sides = new double[]{a,b,c};
    }

    @Test
    public void testImmutabilityConstructor1() {
        B = new RightTriangle2(sides[0],sides[1],sides[2]);
        sides[2] = 5.5;
        assertTrue("hypotenuse should stay the same",Math.abs(B.getHypotenuse() - c) < Double.MIN_VALUE);
    }

    @Test
    public void testImmutabilityConstructor2() {
        C = new RightTriangle2(sides);
        sides[2] = 5.5;
        assertTrue("hypotenuse should stay the same",Math.abs(C.getHypotenuse() - c) < Double.MIN_VALUE);
    }

    
    @Test(expected=UnsupportedOperationException.class)
    public void testImmutabilityGetter() {
        A = new RightTriangle2(a, b, c);
        List<Double> A_sides = A.getAllSides();        
        A_sides.set(2, 5.5);
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
