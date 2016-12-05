package ps3;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * Test suite for Library ADT.
 */
public class SmallLibraryTest {

    /*
     * Note: all the tests you write here must be runnable against any
     * Library class that follows the spec.  JUnit will automatically
     * run these tests against both SmallLibrary and BigLibrary.
     */


    /**
     * Testing strategy
     * ==================
     * 
     * 1. buying test one copy, two copies
     * 2. checkout test: only one checked out, both checked out
     * 3. checkin test: one checked in, both checked in
     * 4. isAvailable Test (Question: available at all, or available for lending?) (probably second)
     * 5. allCopies: test if full set is returned, (zero set may also be useful
     * 6. availableCopies: subset test
     *    a. test case when same as 5.
     * 7. find tests (presumption: whole word only):
     *    a. find all?
     *    b. ordering?
     *       i. year order
     *    c. exact matching
     *       i. of author
     *       ii. of title
     *    d. partial matching
     *       i. of author
     *       ii. of title
     * 8. Lose checked in and checked out book too.
     * Make sure you have partitions.
     */

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    // TODO: put JUnit @Test methods here that you developed from your testing strategy
    @Test
    public void testExampleTest() {
        Library library = new SmallLibrary();
        Book book = new Book("This Test Is Just An Example", Arrays.asList("You Should", "Replace It", "With Your Own Tests"), 1990);
        assertEquals(Collections.emptySet(), library.availableCopies(book));
    }
    
    @Test
    public void testLose() {
        Library library = new SmallLibrary();
        Book book = new Book("HB", Arrays.asList("CSF"), 1950);
        
        BookCopy copy1 = library.buy(book);
        BookCopy copy2 = library.buy(book);
        assertEquals("Size of allCopies now should be 2",2,library.allCopies(book).size());
        
        // lost copy was checked out, >1 copies of book
        library.checkout(copy2);
        assertEquals("Available books now should be one",library.availableCopies(book).size(),1);
        library.lose(copy2);
        Set<BookCopy> allCopies = library.allCopies(book);
        assertEquals("Size of allCopies should be 1.",allCopies.size(),1);
        assertEquals("Should be only a single copy in the library.",new HashSet<>(Arrays.asList(copy1)), allCopies); 
        
        // lost copy was available, 1 copy of book
        library.lose(copy1);
        assertFalse("Book now should not be available.",library.isAvailable(copy1));
        assertTrue("Library should be empty now.",library.allCopies(book).isEmpty()); 
    }    

    

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */

}
