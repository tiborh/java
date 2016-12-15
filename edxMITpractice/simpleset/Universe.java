package simpleset;

/** A Set<E> that contains every E. */
class Universe<E> implements Set {
    /** Make a universe. */
    public Universe() { }
    /** @return always true since this set contains every e */
    @Override
    public boolean contains(E e) { return true; }
}
