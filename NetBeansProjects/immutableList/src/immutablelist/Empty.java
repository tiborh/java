/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immutablelist;

/**
  * Write a description of class Empty here.
  * 
  * @author (your name) 
  * @version (a version number or a date)
  * @param <E>
  */
public class Empty<E> implements ImList<E> {
    public Empty() {
    }
    @Override
    public ImList<E> cons(E e) {
        return new Cons<>(e, this);
    }
    @Override
    public E first() {
        throw new UnsupportedOperationException();
    }
    @Override
    public ImList<E> rest() {
        throw new UnsupportedOperationException();
    } 
    @Override
    public String toString() {
        return " [] ";
    }
}
