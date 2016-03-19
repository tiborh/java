package missing_constructor;

/**
 * Compile time error when tried to compile
 * 
 * @author UC San Diego
 * @version 0.01
 */
public class child extends parent
{
    public child()
    {
        // compiler inserts super(), which does not exist, giving hard to understand explanation
        this.setName("Student");
    }
}
