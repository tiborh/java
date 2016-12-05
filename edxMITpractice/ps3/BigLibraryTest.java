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
public class BigLibraryTest {

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
        Library library = new BigLibrary();
        Book book = new Book("This Test Is Just An Example", Arrays.asList("You Should", "Replace It", "With Your Own Tests"), 1990);
        assertEquals(Collections.emptySet(), library.availableCopies(book));
    }
    
    @Test
    public void testLose() {
        BigLibrary library = new BigLibrary();
        Book book = new Book("HB", Arrays.asList("CSF"), 1950);
        
        BookCopy copy1 = library.buy(book);
        BookCopy copy2 = library.buy(book);
        //System.out.println("Available copies after purchase: " + book);
        //System.out.println(library.availableCopies(book));

        assertEquals("Size of allCopies now should be 2",2,library.allCopies(book).size());
        
        // second copy was checked out, >1 copies of book
        library.checkout(copy2);
        //System.out.println("Available copies for: " + book);
        //System.out.println(library.availableCopies(book));
        //System.out.println("available books:");
        //System.out.println(library.availableBooks());
        assertEquals("Wrong number of available books:",1,library.availableCopies(book).size());
        library.lose(copy2);
        Set<BookCopy> allCopies = library.allCopies(book);
        assertEquals("Wrong number for allCopies.",1,allCopies.size());
        assertEquals("Content of allCopies is wrong:",new HashSet<>(Arrays.asList(copy1)), allCopies); 
        
        // lost copy was available, 1 copy of book
        library.lose(copy1);
        assertFalse("Book now should not be available.",library.isAvailable(copy1));
        assertTrue("Library should be empty now.",library.allCopies(book).isEmpty()); 
    }    

    @Test
    public void testAllCopiesAvailableCopies() {
        Library library = new BigLibrary();
        Book book = new Book("Sense and Sensibility", Arrays.asList("Jane Austen"), 1811);
        
        // no copies owned
        Set<BookCopy> noCopies = Collections.emptySet();
        assertEquals(noCopies, library.allCopies(book));
        assertEquals(noCopies, library.availableCopies(book));

        // 1 copy owned, available
        BookCopy copy1 = library.buy(book);
        Set<BookCopy> justCopy1 = new HashSet<>(Arrays.asList(copy1));
        assertEquals(justCopy1, library.allCopies(book));
        assertEquals(justCopy1, library.availableCopies(book));

        // 1 copy owned, checked out
        library.checkout(copy1);
        assertEquals(justCopy1, library.allCopies(book));
        assertEquals(noCopies, library.availableCopies(book));
        
        // >1 copy owned, >1 available
        library.checkin(copy1);
        assertEquals(justCopy1, library.availableCopies(book));
        assertEquals(justCopy1, library.allCopies(book));
        BookCopy copy2 = library.buy(book);
        assertEquals("Available copies after second purchase",2,library.availableCopies(book).size());
        Set<BookCopy> copy1and2 = new HashSet<>(Arrays.asList(copy1, copy2));
        assertEquals(copy1and2, library.allCopies(book));
        assertEquals(copy1and2, library.availableCopies(book));
        
        // >1 copy owned, 1 available
        library.checkout(copy2);
        assertEquals(copy1and2, library.allCopies(book));
        assertEquals(justCopy1, library.availableCopies(book));        
    }


    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */

}
