package ps3;

/**
 * BookCopy is a mutable type representing a particular copy of a book that is held in a library's
 * collection.
 */
public class BookCopy implements Cloneable{

    final private Book theBook;
    private Condition bookCondition;
    
    // rep invariant
    // theBook is not null
    // bookCondition is not null
    
    // abstraction function
    // represents a copy of a Book in the library
    
    // safety from rep exposure argument
    // Book is immutable, no danger there
    // BookCondition is private, so it cannot be accessed directly
    
    public static enum Condition {
        GOOD, DAMAGED
    };
    
    /**
     * Make a new BookCopy, initially in good condition.
     * @param book the Book of which this is a copy
     */
    public BookCopy(Book book) {
        theBook = book;
        bookCondition = Condition.GOOD;
        checkRep();
    }
    
    // assert the rep invariant
    private void checkRep() {
        assert(theBook != null);
        assert(bookCondition != null);
    }
    
    /**
     * @return the Book of which this is a copy
     */
    public Book getBook() {
        return new Book(theBook.getTitle(),theBook.getAuthors(),theBook.getYear());
    }
    
    /**
     * @return the condition of this book copy
     */
    public Condition getCondition() {
        if (bookCondition == Condition.GOOD)
            return Condition.GOOD;
        return Condition.DAMAGED;
    }

    /**
     * Set the condition of a book copy.  This typically happens when a book copy is returned and a librarian inspects it.
     * @param condition the latest condition of the book copy
     */
    public void setCondition(Condition condition) {
        bookCondition = condition;
        checkRep();
    }
    
    @Override
    public BookCopy clone() {
        BookCopy aClone = new BookCopy(this.getBook());
        aClone.setCondition(this.getCondition());
        
        return aClone;
    }
        
    /**
     * @return human-readable representation of this book that includes book.toString()
     *    and the words "good" or "damaged" depending on its condition
     */
    public String toString() {
        return(theBook.toString() + ", " + (bookCondition == Condition.GOOD ? "In good condition" : "A damaged copy"));
    }

//     @Override
//     public boolean equals(Object that) {
//         if (that == null)
//             return false;        
//         if (super.equals(that)) return true;
//         if (!(that instanceof BookCopy)) return false;
//         if (!BookCopy.class.isAssignableFrom(that.getClass())) return false;
//         
//         final BookCopy other = (BookCopy) that;
//         if (!this.getBook().equals(other.getBook()))
//             return false;
//         if (!this.getCondition().equals(other.getCondition()))
//             return false;
//         
//         return true;
//     }
    
//     @Override
//     public int hashCode() {
//         int sum = this.getBook().hashCode();
//         int multiplier = (this.getCondition() == Condition.GOOD) ? 4 : 7;
//         return(sum * multiplier);
//     }
    
    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */

}
