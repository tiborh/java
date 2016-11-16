package rectangle;


/** An immutable square. */
public class ImmutableSquare implements ImmutableRectangle
{
    private final int side;
    /** Make a new side x side square. */
    public ImmutableSquare(int side) { this.side = side; }
    /** @return the width of this square */
    public int getWidth() { return side; }
    /** @return the height of this square */
    public int getHeight() { return side; }
}
