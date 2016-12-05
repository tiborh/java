package ps3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;

/**
 * BigLibrary represents a large collection of books that might be held by a city or
 * university library system -- millions of books.
 * 
 * In particular, every operation needs to run faster than linear time (as a function of the number of books
 * in the library).
 */
public class BigLibrary implements Library {

    // rep
    Map<Book,HashSet<BookCopy>> inLibrary;
    Map<Book,HashSet<BookCopy>> checkedOut;
    
    // rep invariant
    //      the intersection of inLibrary.get(book) and checkedOut.get(book) is the empty set
    // abstraction function
    //    represents the collection of books inLibrary union checkedOut,
    //      where if a book copy is in inLibrary then it is available,
    //      and if a copy is in checkedOut then it is checked out
    
    // safety from rep exposure argument
    //      inLibrary or checkedOut are never directly returned.
    //      if BookCopy is returned, a copy of it is returned only.
    
    public BigLibrary() {
        inLibrary = new TreeMap<Book,HashSet<BookCopy>>();
        checkedOut = new TreeMap<Book,HashSet<BookCopy>>();
    }
    
    // assert the rep invariant
    private void checkRep(Book aBook) {
        HashSet<BookCopy> intersection = new HashSet<BookCopy>(); // use the copy constructor
        if (inLibrary.containsKey(aBook) && checkedOut.containsKey(aBook)) {
            intersection = inLibrary.get(aBook);
            intersection.retainAll(checkedOut.get(aBook));
        }
        assert(intersection.isEmpty());
    }

    @Override
    public BookCopy buy(Book book) {
        BookCopy newCopy = new BookCopy(book);
        addCopyToMap(inLibrary,book,newCopy);
        //checkRep(book);
        return(newCopy);
    }
    
    @Override
    public void checkout(BookCopy copy) {
        Book aBook = copy.getBook();
        //System.out.println("inLibrary before checkout");
        //System.out.println(inLibrary);
        assert(inLibrary.containsKey(aBook));
        assert(inLibrary.get(aBook).contains(copy));
        inLibrary.get(aBook).remove(copy);        
        addCopyToMap(checkedOut,aBook,copy);        
        assert(checkedOut.get(aBook).contains(copy));
        //System.out.println("inLibrary after checkout");
        //System.out.println(inLibrary);
        //checkRep(aBook);
    }
    
    private void addCopyToMap(Map<Book,HashSet<BookCopy>> aMap, Book aBook, BookCopy aCopy) {
        if (aMap.containsKey(aBook))
            aMap.get(aBook).add(aCopy);            
        else
            aMap.put(aBook, new HashSet<BookCopy>(Arrays.asList(aCopy)));            
    }
    
    @Override
    public void checkin(BookCopy copy) {
        Book aBook = copy.getBook();
        assert(checkedOut.containsKey(aBook));
        assert(checkedOut.get(aBook).contains(copy));
        checkedOut.get(aBook).remove(copy);
        addCopyToMap(inLibrary,aBook,copy);
        //checkRep(aBook);
    }
    
    @Override
    public Set<BookCopy> allCopies(Book book) {
        Set<BookCopy> outSet = new HashSet<BookCopy>();
        boolean isOut = true;
        if (!checkedOut.containsKey(book) || checkedOut.get(book).size() == 0)
            isOut = false;
        
        if (!inLibrary.containsKey(book) || inLibrary.get(book).size() == 0) {
            if (!isOut)
                return new HashSet<BookCopy>();
        } else
            outSet.addAll(inLibrary.get(book));
            
        if (isOut)
            outSet.addAll(checkedOut.get(book));
        
        return Collections.unmodifiableSet(outSet);
    }

    public Set<Book> availableBooks() {
        return inLibrary.keySet();
    }
    
    @Override
    public Set<BookCopy> availableCopies(Book book) {        
        if (!inLibrary.containsKey(book))
            return new HashSet<BookCopy>();
        else
            return Collections.unmodifiableSet(inLibrary.get(book));
    }
    
    @Override
    public boolean isAvailable(BookCopy copy) {
        Book aBook = copy.getBook();
        if (!inLibrary.containsKey(aBook))
            return false;
        if (!inLibrary.get(aBook).contains(copy))
            return false;
        return true;
    }
    
    @Override
    public List<Book> find(String query) {
        throw new RuntimeException("not implemented yet");
    }
    
    @Override
    public void lose(BookCopy copy) {
        Book aBook = copy.getBook();
        if (checkedOut.get(aBook).contains(copy))
            checkedOut.get(aBook).remove(copy);
        else if (inLibrary.get(aBook).contains(copy))
            inLibrary.get(aBook).remove(copy);        
    }


    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */

}