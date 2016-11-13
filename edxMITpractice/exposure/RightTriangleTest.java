package exposure;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class of RightTriangle.
 *
 * @author  tibor
 * @version 0.01
 */
public class RightTriangleTest
{
    double a;
    double b;
    double c;
    double[] sides;
    RightTriangle A;
    RightTriangle B;
    RightTriangle C;
    
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
        A = new RightTriangle(a, b, c);
        B = new RightTriangle(sides[0],sides[1],sides[2]);
        C = new RightTriangle(sides);
    }

    @Test
    public void testImmutabilityConstructor1() {
        sides[2] = 5.5;
        assertTrue("hypotenuse should stay the same",Math.abs(B.getHypotenuse() - c) < Double.MIN_VALUE);
    }

    @Test
    public void testImmutabilityConstructor2() {
        sides[2] = 5.5;
        assertTrue("hypotenuse should stay the same",Math.abs(C.getHypotenuse() - c) < Double.MIN_VALUE);
    }

    
    @Test
    public void testImmutabilityGetter() {
        double[] A_sides = A.getAllSides();
        A_sides[2] = 5.5;
        assertTrue("hypotenuse should stay the same",Math.abs(A.getHypotenuse() - c) < Double.MIN_VALUE);
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
