package ps3;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * Test suite for BookCopy ADT.
 */
public class BookCopyTest {

    Book testBook = new Book("Lucius Apuleius Madaurensis",Arrays.asList("Metamorphoses"),170);
    Book nullBook = null;
    
    /*
     * Testing strategy
     * ==================
     * 
     * Book tests are not performed as they are taken care of in BookTest
     * Partition:
     *    Invariant tests
     *    Condition change tests
     */

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test(expected=AssertionError.class)
    public void testNullBook() {
        BookCopy a = new BookCopy(nullBook);
    }
   
    @Test(expected=AssertionError.class)
    public void testNullCond() {
        BookCopy a = new BookCopy(testBook);
        a.setCondition(null);
    }
    
    @Test
    public void testBookReturned() {
        BookCopy a = new BookCopy(testBook);
        assertEquals(testBook, a.getBook());
    }
    
    
    @Test
    public void testBookCondition() {
        BookCopy a = new BookCopy(testBook);
        assertEquals(a.getCondition(), BookCopy.Condition.GOOD);
        a.setCondition(BookCopy.Condition.GOOD);
        assertEquals(a.getCondition(), BookCopy.Condition.GOOD);
        a.setCondition(BookCopy.Condition.DAMAGED);
        assertEquals(a.getCondition(), BookCopy.Condition.DAMAGED);
    }
    

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */

}
