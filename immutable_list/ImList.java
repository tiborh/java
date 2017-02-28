
/**
 * Write a description of interface ImList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ImList<E> {
    public static <E> ImList<E> empty() {
        return new Empty<>();
    }
    public ImList<E> cons(E e);
    public E first();
    public ImList<E> rest();
}
