package ps3;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test suite for Book ADT.
 */
public class BookTest {

    /*
     * Testing strategy
     * ==================
     * 
     * Partitions:
     *  * Positive vs Negative Test Cases
     *  * Test valid and invalid input
     *  * Test exposure of the List output
     *  * Test case sensitivity
     *  * implicitly: test equality
     */
    
    // TODO: put JUnit @Test methods here that you developed from your testing strategy
    
    private static final String authMin = "  b";
    Book bookMin = new Book(" a  ",Arrays.asList(authMin),0);

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testExampleTest() {
        Book book = new Book("This Test Is Just An Example", 
            Arrays.asList("You Should", "Replace It", "With Your Own Tests"), 1990);
        assertEquals("This Test Is Just An Example", book.getTitle());
    }
    
    //Minimum Test
    @Test
    public void testMinBook() {
        assertEquals("Title length should be 4",bookMin.getTitle().length(),4);
        assertEquals("Year should be 0",bookMin.getYear(),0);
        assertEquals("Length of authors list should be 1",bookMin.getAuthors().size(),1);
        assertTrue("First author should be '" + authMin + "'",
            bookMin.getAuthors().get(0).equals(authMin));
    }
    
    //Invalid input Tests
    @Test(expected=AssertionError.class)
    public void testZeroLengthTitle() {
        Book wrongBook = new Book("", Arrays.asList("one"), 1);
    }

    @Test(expected=AssertionError.class)
    public void testTitleWithSpaceOnly() {
        Book wrongBook = new Book(" 	 ", Arrays.asList("one"), 1);
    }

    @Test(expected=AssertionError.class)
    public void testEmptyAuthor() {
        Book wrongBook = new Book("z", Arrays.asList("one","","two"), 1);
    }

    @Test(expected=AssertionError.class)
    public void testSpacedAuthor() {
        Book wrongBook = new Book("z", Arrays.asList("one","	","two"), 1);
    }

    @Test(expected=AssertionError.class)
    public void testMinusYear() {
        Book wrongBook = new Book("j", Arrays.asList("one"), -1);
    }
            
    @Test
    public void testListExposure() {
        List<String> auths = bookMin.getAuthors();
        auths.add("second");
        assertEquals("Copied list should expand to two.",auths.size(),2);
        assertEquals("Original list should stay the same length.",bookMin.getAuthors().size(),1);
    }
    
    @Test
    public void testNonEquality() {
        final String aTitle = "fred";
        final String anAuth = "one";
        final int aYear = 1984;
        Book one = new Book(aTitle,Arrays.asList(anAuth),aYear);
        Book two = new Book(aTitle.toUpperCase(),Arrays.asList(anAuth),aYear);
        assertFalse("'" + aTitle + "' and '" + aTitle.toUpperCase() + "' should be handled as distinct",one.equals(two));
        assertFalse("'" + aTitle.toUpperCase() + "' and '" + aTitle + "' should be handled as distinct",two.equals(one));
        one = new Book(aTitle,Arrays.asList(anAuth),aYear);
        two = new Book(aTitle,Arrays.asList(anAuth.toUpperCase()),aYear);
        assertFalse("'" + anAuth + "' and '" + anAuth.toUpperCase() + "' should be handled as distinct",one.equals(two));
        assertFalse("'" + anAuth.toUpperCase() + "' and '" + anAuth + "' should be handled as distinct",two.equals(one));
        one = new Book(aTitle,Arrays.asList(anAuth),aYear);
        two = new Book(aTitle,Arrays.asList(anAuth),aYear+1);
        assertFalse("'" + aYear + "' and '" + (aYear+1) + "' should be handled as distinct",one.equals(two));
        assertFalse("'" + (aYear+1) + "' and '" + aYear + "' should be handled as distinct",two.equals(one));
    }
    
    @Test
    public void testEquality() {
        final String aTitle = "one";
        final String anAuth = "fred";
        final int aYear = 1984;
        Book one = new Book(aTitle,Arrays.asList(anAuth),aYear);
        Book two = new Book(aTitle,Arrays.asList(anAuth),aYear);
        assertTrue("Book one should be equal to Book two",one.equals(two));
        assertTrue("Book two should be equal to Book one",two.equals(one));
    }
    
    
    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */

}