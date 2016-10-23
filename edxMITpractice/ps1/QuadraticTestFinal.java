package ps1;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class QuadraticTestFinal 
{
    /*
     * Additional testing strategy
     * Partitions:
     *    a=0
     *    roots are integer, real, or complex
     * 
     * Each of these parts is covered by at least one test case below.
     */

    // covers a=0
    @Test
    public void testOneDegenerateRoot() {
        assertEquals(makeSet(3), Quadratic.roots(0, -5, 5*3));
    }
    
    // covers both roots real but not integers
    @Test
    public void testRealRoots() {
        // roots are 1/2 and 1/3
        assertEquals(makeSet(), Quadratic.roots(6, -5, 1));
    }
    
    // covers both roots complex but not integers
    @Test
    public void testComplexRoots() {
        assertEquals(makeSet(), Quadratic.roots(1, -2, 2));
    }

    // returns a set of the integers passed as parameters
    private static Set<Integer> makeSet(int... elements) {
        Set<Integer> set = new HashSet<>();
        for (int x: elements) {
            set.add(x);
        }
        return set;
    }
}
