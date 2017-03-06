import java.util.ArrayList;

public class Cons<E> implements ImList<E> {
    private final E e;
    private final ImList<E> rest;
    private int list_size;
    private ArrayList<E> the_list;

    public Cons(E e, ImList<E> rest) {
        this.e = e;
        this.rest = rest;
        this.list_size = 0;
        this.the_list = new ArrayList<E>();
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
        if (list_size == 0) list_size = 1 + rest.size();
        return list_size;
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
    public ArrayList<E> get_list() {
        ArrayList<E> to_return = new ArrayList<>();
        to_return.add(e);
        to_return.addAll(rest.get_list());
        return to_return;
    }
        
    @Override
    public E get(int i) {
        if (the_list.size() == 0) {
            the_list.addAll(get_list());
        }        
        return the_list.get(i);
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
