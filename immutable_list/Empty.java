
/**
 * Write a description of class Empty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empty<E>
{
    public Empty() {
    }
    public ImList<E> cons(E e) {
        return new Cons<>(e, this);
    }
    public E first() {
        throw new UnsupportedOperationException();
    }
    public ImList<E> rest() {
        throw new UnsupportedOperationException();
    }  
}
