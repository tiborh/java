package ps3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * SmallLibrary represents a small collection of books, like a single person's home collection.
 */
public class SmallLibrary implements Library {

    // This rep is required! 
    // Do not change the types of inLibrary or checkedOut, 
    // and don't add or remove any other fields.
    // (BigLibrary is where you can create your own rep for
    // a Library implementation.)

    // rep
    private Set<BookCopy> inLibrary;
    private Set<BookCopy> checkedOut;
    
    // rep invariant:
    //    the intersection of inLibrary and checkedOut is the empty set
    //
    // abstraction function:
    //    represents the collection of books inLibrary union checkedOut,
    //      where if a book copy is in inLibrary then it is available,
    //      and if a copy is in checkedOut then it is checked out

    // safety from rep exposure argument:
    //      inLibrary or checkedOut are never directly returned.
    //      if BookCopy is returned, a copy of it is returned only.
    
    public SmallLibrary() {
        inLibrary = new HashSet<BookCopy>();
        checkedOut = new HashSet<BookCopy>();
        checkRep();
    }
    
    // assert the rep invariant
    private void checkRep() {
        Set<BookCopy> intersection = new HashSet<BookCopy>(inLibrary); // use the copy constructor
        intersection.retainAll(checkedOut);
        assert(intersection.isEmpty());
    }

    @Override
    public BookCopy buy(Book book) {
        BookCopy newCopy = new BookCopy(book);
        inLibrary.add(newCopy);
        return(newCopy);
    }
    
    @Override
    public void checkout(BookCopy copy) {
        assert(inLibrary.contains(copy));
        inLibrary.remove(copy);
        checkedOut.add(copy);
        checkRep();
    }
    
    @Override
    public void checkin(BookCopy copy) {
        assert(checkedOut.contains(copy));
        checkedOut.remove(copy);
        inLibrary.add(copy);
        checkRep();
    }
    
    @Override
    public boolean isAvailable(BookCopy copy) {
        return inLibrary.contains(copy);
    }
    
    @Override
    public Set<BookCopy> allCopies(Book book) {
        //Set<BookCopy> allSet = getSetCopy(this.availableCopies(book));
        Set<BookCopy> allSet = this.availableCopies(book);
        allSet.addAll(copiesInSet(checkedOut,book));
        
        return allSet; 
    }
    
    private Set<BookCopy> getSetCopy(Set<BookCopy> inSet) {
        Set<BookCopy> outSet = new HashSet<BookCopy>();
        for (BookCopy aCopy : inSet)
            outSet.add(aCopy.clone());
        return outSet;
    }
    
    @Override
    public Set<BookCopy> availableCopies(Book book) {        
        return copiesInSet(inLibrary,book);
    }

    private Set<BookCopy> copiesInSet(final Set<BookCopy> inSet, Book aBook) {
        Set<BookCopy> outSet = new HashSet<BookCopy>();
        for (BookCopy aCopy : inSet) {
            if (aCopy.getBook().equals(aBook)) {
                outSet.add(aCopy);
            }
        }
        return outSet;        
    }
    
//     private Set<BookCopy> copiesInSet(final Set<BookCopy> inSet, Book aBook) {
//         Set<BookCopy> outSet = new HashSet<BookCopy>();
//         for (BookCopy aCopy : inSet) {
//             if (aCopy.getBook().equals(aBook)) {
//                 outSet.add(aCopy.clone());
//             }
//         }
//         return outSet;        
//     }
    
    @Override
    public List<Book> find(String query) {
        // all the books
        Set<BookCopy> allCopies = new HashSet<BookCopy>(inLibrary);
        allCopies.addAll(checkedOut);
        // found books
        Set<Book> foundBooks = new HashSet<Book>();
        for (BookCopy aCopy : allCopies) {
            Book aBook = aCopy.getBook();
            if (stringInBook(aBook,query))
                foundBooks.add(aBook);
        }
        // output creation
        List<Book> outList = new ArrayList<Book>(foundBooks.size());
        for (Book aBook : foundBooks) {
            outList.add(aBook);
        }
        Collections.sort(outList);
        
        return(outList);
    }
    
    private boolean stringInBook(Book aBook, String searchStr) {
        if (aBook.getTitle().contains(searchStr))
            return true;
        boolean authorSearchResult = stringInAuthors(aBook.getAuthors(),searchStr); 
        if (authorSearchResult)
            return authorSearchResult;
        return false;
    }
    
    private boolean stringInAuthors(List<String> theAuthors, String searchStr) {
        for (String anAuthor : theAuthors) {
            if (anAuthor.contains(searchStr))
                return true;
        }
        return false;
    }
    
    @Override
    public void lose(BookCopy copy) {
        //assert(checkedOut.contains(copy));
        if (checkedOut.contains(copy))
            checkedOut.remove(copy);
        else if (inLibrary.contains(copy))
            inLibrary.remove(copy);
        checkRep();
    }
    
    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */
}