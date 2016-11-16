package rectangle;

/** An immutable rectangle. */
public class ImRect implements ImmutableRectangle
{
    private final int width,height;
    /** Make a new side x side square. */
    public ImRect(int width, int height) { 
        this.width = width;
        this.height = height;
    }
    /** @return the width of this rectangle */
    public int getWidth() { return width; }
    /** @return the height of this rectangle */
    public int getHeight() { return height; }
}
