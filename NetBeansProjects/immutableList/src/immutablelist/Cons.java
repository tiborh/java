/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immutablelist;

public class Cons<E> implements ImList<E> {
    private final E e;
    private final ImList<E> rest;

    public Cons(E e, ImList<E> rest) {
        this.e = e;
        this.rest = rest;
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public ImList<E> cons(E e) {
        return new Cons<>(e, this);
    }

    /**
     *
     * @return
     */
    @Override
    public E first() {
        return e;
    }

    /**
     *
     * @return
     */
    @Override
    public ImList<E> rest() {
        return rest;
    }
    
    @Override
    public String toString() {
        return " [ " + e + rest + "] ";
    }
}
