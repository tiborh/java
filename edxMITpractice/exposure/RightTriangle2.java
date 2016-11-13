package exposure;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.commons.lang3.ArrayUtils;

/** Represents an immutable right triangle. */
class RightTriangle2 {
    /*A*/     private List<Double> sides;

    // sides[0] and sides[1] are the two legs,
    // and sides[2] is the hypotenuse, so declare it to avoid having a
    // magic number in the code:
    /*B*/     private static final int HYPOTENUSE = 2;

    /** Make a right triangle.
     * @param legA, legB  the two legs of the triangle
     * @param hypotenuse    the hypotenuse of the triangle.
     *C*       *        Requires hypotenuse^2 = legA^2 + legB^2 
     *           (within the error tolerance of double arithmetic)
     */
    public RightTriangle2(double legA, double legB, double hypotenuse) {
        assert(legA*legA + legB*legB - hypotenuse * hypotenuse < Double.MIN_VALUE);
        /*D*/         this.sides = Collections.unmodifiableList(Arrays.asList(legA, legB, hypotenuse));
    }

    public RightTriangle2(double[] sides) {
        assert(sides.length == 3);
        assert(sides[0]*sides[0] + sides[1]*sides[1] - sides[2]*sides[2] < Double.MIN_VALUE);
        Double[] sidesDouble = ArrayUtils.toObject(sides);
        /*D*/         this.sides = Collections.unmodifiableList(Arrays.asList(sidesDouble));
    }

    
    /** Get all the sides of the triangle.
     *  @return three-element array with the triangle's side lengths
     */
    public List<Double> getAllSides() {
        /*E*/         return sides;
    }

    /** @return length of the triangle's hypotenuse */ 
    public double getHypotenuse() {
        return sides.get(HYPOTENUSE);
    }

    /** @param factor to multiply the sides by
     *  @return a triangle made from this triangle by 
     *  multiplies all side lengths by factor.
     */
    public RightTriangle2 scale(double factor) {
        return new RightTriangle2 (sides.get(0)*factor, sides.get(1)*factor, sides.get(2)*factor);
    }

    /** @return a regular triangle made from this triangle.
     *  A regular right triangle is one in which
     *  both legs have the same length.
     */
    public RightTriangle2 regularize() {
        double bigLeg = Math.max(sides.get(0), sides.get(1));
        return new RightTriangle2 (bigLeg, bigLeg, sides.get(2));
    }
    
    public String toString() {
        return ("a == " + sides.get(0) + "; b == " + sides.get(1) + "; c == " + sides.get(2));
    }

    public static void main (String[] argv) {
        RightTriangle2 A = new RightTriangle2(3, 4, 5);
        System.out.println("A: " + A);
        List<Double> B = A.getAllSides();
        System.out.println("All sides: " + B);
        System.out.println("Hypotenuse: " + A.getHypotenuse());
        Double[] B_helper = new Double[] {B.get(0),B.get(1),5.5};
        B = Arrays.asList(B_helper);
        System.out.println("B: " + B);
        System.out.println("A: " + A);
    }
}
