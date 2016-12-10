package ps3;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * Test suite for Library ADT.
 */
public class BigLibraryTest {
    private Library library;
    
    @Before
    public void initialiser() {
        library = new BigLibrary();
    }

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
    public void testEmptyLibrary() {
        Book book = new Book("A Title", Arrays.asList("Author 1", "Author 2", "Author 3"), 384);
        assertEquals("No available copies.",Collections.emptySet(), library.availableCopies(book));
        assertEquals("Nothing in all copies",Collections.emptySet(), library.allCopies(book));
    }

    @Test
    public void testBuyCopy() {
        Book book = new Book("A Title", Arrays.asList("Author 1", "Author 2", "Author 3"), 384);
        BookCopy copy1 = library.buy(book);
        Set<BookCopy> bookset = new HashSet<BookCopy>(Arrays.asList(copy1));
        assertEquals("copy1 is available.",bookset, library.availableCopies(book));
        assertEquals("copy1 is in all copies",bookset, library.allCopies(book));
        assertTrue("Sample book is available.",library.isAvailable(copy1));
    }

    @Test
    public void testBuyTwoCopiesOfSameBook() {
        Book book = new Book("Emil i Lönneberga", Arrays.asList("Astrid Lindgren"), 1963);
        BookCopy copy1 = library.buy(book);
        BookCopy copy2 = library.buy(book);
        Set<BookCopy> bookset2 = new HashSet<BookCopy>(Arrays.asList(copy1,copy2));
        assertEquals("two copies in the set",2,bookset2.size());
        assertEquals("copy1 and copy2 are available.",bookset2, library.availableCopies(book));
        assertEquals("copy1 and copy2 are in all copies",bookset2, library.allCopies(book));
        assertTrue("copy1 is available.",library.isAvailable(copy1));
        assertTrue("copy2 is available.",library.isAvailable(copy2));
    }
    
    @Test
    public void testBuyTwoCopiesOfTwoBooks() {
        Book book1 = new Book("The Heart Goes Last", Arrays.asList("Margaret Atwood"), 2015);
        Book book2 = new Book("Emil i Lönneberga", Arrays.asList("Astrid Lindgren"), 1963);
        BookCopy copy1 = library.buy(book1);
        BookCopy copy2 = library.buy(book2);        
        Set<BookCopy> bookset1 = new HashSet<BookCopy>(Arrays.asList(copy1));
        Set<BookCopy> bookset2 = new HashSet<BookCopy>(Arrays.asList(copy2));        
        assertEquals("copy1 is available.",bookset1, library.availableCopies(book1));
        assertEquals("copy2 is available.",bookset2, library.availableCopies(book2));
        assertEquals("copy1 is in all copies",bookset1, library.allCopies(book1));
        assertEquals("copy2 is in all copies",bookset2, library.allCopies(book2));
        assertTrue("copy1 is available.",library.isAvailable(copy1));
        assertTrue("copy2 is available.",library.isAvailable(copy2));
    }
    
    @Test
    public void testCheckOut() {
        Book book = new Book("A Title", Arrays.asList("Author 1", "Author 2", "Author 3"), 384);
        BookCopy copy1 = library.buy(book);
        Set<BookCopy> bookset = new HashSet<BookCopy>(Arrays.asList(copy1));
        library.checkout(copy1);
        assertEquals("copy1 is not available.",Collections.emptySet(), library.availableCopies(book));
        assertEquals("copy1 is in all copies",bookset, library.allCopies(book));
        assertFalse("Sample book is not available.",library.isAvailable(copy1));
    }

    @Test
    public void testCheckIn() {
        Book book = new Book("A Title", Arrays.asList("Author 1", "Author 2", "Author 3"), 384);
        BookCopy copy1 = library.buy(book);
        Set<BookCopy> bookset = new HashSet<BookCopy>(Arrays.asList(copy1));
        library.checkout(copy1);
        library.checkin(copy1);
        assertEquals("copy1 is available.",bookset, library.availableCopies(book));
        assertEquals("copy1 is in all copies",bookset, library.allCopies(book));
        assertTrue("Sample book is available.",library.isAvailable(copy1));
    }

    
    @Test
    public void testLose() {
        Book book = new Book("HB", Arrays.asList("CSF"), 1950);
        
        BookCopy copy1 = library.buy(book);
        BookCopy copy2 = library.buy(book);    
        assertEquals("Size of allCopies now should be 2",2,library.allCopies(book).size());
        
        // second copy was checked out, >1 copies of book
        library.checkout(copy2);
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
    public void testLoseNonExistent() {
        Book book = new Book("HB", Arrays.asList("CSF"), 1950);
        BookCopy copy1 = new BookCopy(book);
        library.lose(copy1);
    }
    
    @Test
    public void testFindAfterLose() {
        Book book = new Book("HB", Arrays.asList("CSF"), 1950);
        BookCopy copy1 = library.buy(book);
        library.lose(copy1);
        assertEquals("Library should be empty",0,library.allCopies(book).size());
        
        List<Book> found = library.find("HB");
        assertNotNull("Returned list should not be null",found);
        assertEquals("Empty list should be returned",0,found.size());
    }
    
    @Test
    public void testFindTitleFromOne() {
        Book book1 = new Book("HB", Arrays.asList("CSF"), 1951);
        library.buy(book1);
        List<Book> found = library.find("HB");
        assertEquals("Book should be found",1,found.size());
        assertEquals("Book should be identical",book1,found.get(0));
    }

    @Test
    public void testFindTitleFromMulti() {
        Book book1 = new Book("HB", Arrays.asList("CSF"), 1951);
        Book book2 = new Book("AB", Arrays.asList("CSF"), 1951);
        Book book3 = new Book("B", Arrays.asList("CSF"), 1951);
        Book book4 = new Book("BC", Arrays.asList("CSF"), 1951);
        library.buy(book1);
        library.buy(book2);
        library.buy(book3);
        library.buy(book4);
        List<Book> found = library.find("HB");
        assertEquals("Book should be found",1,found.size());
        assertEquals("Book should be identical",book1,found.get(0));
    }

    @Test
    public void testFindAuthor() {
        Book book1 = new Book("HB", Arrays.asList("ASF","CSF","CFG"), 1951);
        library.buy(book1);
        List<Book> found = library.find("CSF");
        assertEquals("Book should be found",1,found.size());
        assertEquals("Book should be identical",book1,found.get(0));
    }
    
    @Test
    public void testFindYearDiff() {
        Book book1 = new Book("HB", Arrays.asList("CSF"), 1951);
        Book book2 = new Book("HB", Arrays.asList("CSF"), 1949);
        Book book3 = new Book("HB", Arrays.asList("CSF"), 1950);
        library.buy(book1);
        library.buy(book2);
        library.buy(book3);
        List<Book> found = library.find("HB");
        assertEquals("All three books should be found",3,found.size());
        assertEquals("First item test",1951,found.get(0).getYear());
        assertEquals("Second item test",1950,found.get(1).getYear());
        assertEquals("Third item test",1949,found.get(2).getYear());
    }
    
    @Test
    public void testFindOnEmptyLibrary() {
        List<Book> found = library.find("HB");
        assertNotNull("Returned list should not be null",found);
        assertEquals("Empty list should be returned",0,found.size());
    }
    
    @Test
    public void testAllCopiesAvailableCopies() {
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
        
        library.checkout(copy1);
        assertEquals(noCopies, library.availableCopies(book));        
    }


    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */

}
