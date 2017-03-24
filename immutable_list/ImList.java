
/**
 * Write a description of interface ImList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ImList<E> {
    public static <E> ImList<E> empty() {
        return new Empty<E>();
    }
    public ImList<E> cons(E e);
    public E first();
    public ImList<E> rest();
    public int size();
    public boolean isEmpty();
    public boolean contains(E e);
    public E get(int i);
    public ImList<E> append(ImList<E> other);
    public ImList<E> reverse();
}
