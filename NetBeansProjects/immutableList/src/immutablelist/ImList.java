/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immutablelist;

/**
 * Write a description of interface ImList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * @param <E>
 */
public interface ImList<E> {
    public static <E> ImList<E> empty() {
        return new Empty<>();
    }
    public ImList<E> cons(E e);
    public E first();
    public ImList<E> rest();
}