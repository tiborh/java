package exposure;

import java.util.Arrays;

/** Represents an immutable right triangle. */
class RightTriangle {
    /*A*/     private final double[] sides;

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
    public RightTriangle(double legA, double legB, double hypotenuse) {
        assert(legA*legA + legB*legB - hypotenuse * hypotenuse < Double.MIN_VALUE);
        /*D*/         this.sides = new double[] { legA, legB, hypotenuse };
    }

    public RightTriangle(double[] sides) {
        assert(sides.length == 3);
        assert(sides[0]*sides[0] + sides[1]*sides[1] - sides[2]*sides[2] < Double.MIN_VALUE);
        this.sides = new double[]{sides[0],sides[1],sides[2]};
    }
    
    /** Get all the sides of the triangle.
     *  @return three-element array with the triangle's side lengths
     */
    public double[] getAllSides() {
        double[] returnArr = new double[sides.length];
        /** Make object data unexposed to the outside world */
        System.arraycopy(sides, 0, returnArr, 0, sides.length);
        /*E*/         return returnArr;
    }

    /** @return length of the triangle's hypotenuse */ 
    public double getHypotenuse() {
        return sides[HYPOTENUSE];
    }

    /** @param factor to multiply the sides by
     *  @return a triangle made from this triangle by 
     *  multiplies all side lengths by factor.
     */
    public RightTriangle scale(double factor) {
        return new RightTriangle (sides[0]*factor, sides[1]*factor, sides[2]*factor);
    }

    /** @return a regular triangle made from this triangle.
     *  A regular right triangle is one in which
     *  both legs have the same length.
     */
    public RightTriangle regularize() {
        double bigLeg = Math.max(sides[0], sides[1]);
        return new RightTriangle (bigLeg, bigLeg, sides[2]);
    }
    
    public String toString() {
        return ("a == " + sides[0] + "; b == " + sides[1] + "; c == " + sides[2]);
    }

    public static void main (String[] argv) {
        RightTriangle A = new RightTriangle(3, 4, 5);
        System.out.println(A);
        double[] B = A.getAllSides();
        System.out.println("All sides: " + Arrays.toString(B));
        System.out.println("Hypotenuse: " + A.getHypotenuse());
        B[2] = 3.5;
        System.out.println("B: " + Arrays.toString(B));
        System.out.println(A);
    }
}
