package Arrays;

public class Array2DSquare extends Array2D
{
    Array2DSquare()
    {
        super(3,3);
    }

    Array2DSquare(int size)
    {
        super(size);
    }
    
    Array2DSquare(int first, int second)
    {
        super(first,first);
        System.err.println("Only the first value is used: "+first);
    }

    @Override
    void fill()
    {
        for (int i=fmax-1; i >= 0; i--) {
            for (int j=0; j < fmax; j++) {
                if (i < j) {
                    d2[i][j] = 0;
                } else if (i == j) {
                    d2[i][j] = 1;
                } else {
                    d2[i][j] = 2;
                }
            }
        }
    }
    
    /**Array2DSquare*/
    public static void main (String[] argv)
    {
        Array2DSquare sq = new Array2DSquare(5);
        sq.fill();
        System.out.println(sq);
    }
}
