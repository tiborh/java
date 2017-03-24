
public class Cons<E> implements ImList<E> {
    private final E e;
    private final ImList<E> rest;

    public Cons(E e, ImList<E> rest) {
        this.e = e;
        this.rest = rest;
    }

    @Override
    public ImList<E> cons(E e) {
        return new Cons<>(e, this);
    }

    @Override
    public E first() {
        return e;
    }

    @Override
    public ImList<E> rest() {
        return rest;
    }
    
    @Override
    public String toString() {
        return " [ " + e + rest + "] ";
    }

    @Override
    public int size() {
        return 1 + rest.size();
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public boolean contains(E e) {
        if (this.e == e)
            return true;
        else
            return rest.contains(e);
    }
    
    @Override
    public E get(int i) {
        if (i == 0)
            return e;
        else 
            return rest.get(i-1);
    }
    
    @Override
    public ImList<E> append(ImList<E> other) {
        if (other.isEmpty())
            return this;
        else
            return rest.append(other).cons(e);
    }
    
    @Override
    public ImList<E> reverse() {
        ImList<E> nil = ImList.empty();
        if (this.isEmpty())
            return this;
        else 
            return rest.reverse().append(nil.cons(e));
    }
}
