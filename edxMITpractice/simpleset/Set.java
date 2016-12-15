package simpleset;

/** Represents an immutable set of elements of type E. */
interface Set<E> {
    /** @return true iff this set contains e as a member */
    public boolean contains(E e);
}
